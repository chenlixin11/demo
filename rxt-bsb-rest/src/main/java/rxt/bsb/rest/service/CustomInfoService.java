package rxt.bsb.rest.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.common.util.Encipher;
import rxt.bsb.rest.common.util.ValidateUtils;
import rxt.bsb.rest.dao.*;
import rxt.bsb.rest.po.*;
import rxt.bsb.rest.vo.QueryVO.QueryAgentCreditConfigVO;
import rxt.bsb.rest.vo.showVO.ShowAgentCreditConfigVO;
import rxt.bsb.rest.vo.showVO.ShowCustomVO;

import java.util.Date;
import java.util.List;

/**
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 * @Copyright (c)</ b> 2012融信通-版权所有<br/>
 * @createTime: 2019/10/21 14:31
 * @Description:
 */
@Service
public class CustomInfoService {

    @Autowired
    private AgentInfoDao agentInfoDao;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private ContrUsercontractDao contrUsercontractDao;
    @Autowired
    private AgentAccountDao agentAccountDao;
    @Autowired
    private AgentCreditConfigDao agentCreditConfigDao;

    /**
     * 查询客户列表
     */
    public Page<AgentInfo> queryAgentInfoList(AgentInfo agentInfo, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Page<AgentInfo> agentInfoList  = agentInfoDao.queryAgentInfoList(agentInfo);
        return agentInfoList;
    }

    /**
     * 修改客户信息
     */
    public int updateAgentInfo(AgentInfo agentInfo) {
        if( agentInfo.getId() == 0 ){ return 0 ;}
        return agentInfoDao.updateByPrimaryKeySelective(agentInfo);
    }

    /**
     * 删除客户信息
     */
    public int removeAgentInfo(Integer id) {
        return agentInfoDao.deleteByPrimaryKey(id);
    }

    /**
     * 根据客户名称查询客户
     * @param custName
     * @return
     */
    public List<AgentInfo> queryAgentInfoByCustName(String custName) {
        return agentInfoDao.queryAgentInfoByCustName(custName);
    }

    /**
     * 保存相关表信息
     */
    public void saveInfo(ShowCustomVO showCustomVO) {

        /*
         * 初始化用户表
         */
        Users users = new Users();
        users.setUserName(showCustomVO.getUserName());
        users.setUserType(1);//用户类型（1:客户；2:平台管理员；3：核心企业，4：银行）
        users.setPwd( Encipher.Encode( "123456" ));
        users.setCreateTime(new Date());
        usersDao.insert(users);

        /*
         * 保存客户基本信息表
         */
        AgentInfo agentInfo = new AgentInfo();
        agentInfo.setUserId(users.getId());
        agentInfo.setCustName(showCustomVO.getCustName());
        agentInfo.setCustType(showCustomVO.getCustType());
        agentInfo.setCreateTime(new Date());
        agentInfoDao.insert(agentInfo);

        /*
         * 上面保存agentInfo的insert，后面未能获取到id（待改进）
         * 根据custNo查询获取客户的id
         */
        agentInfo = agentInfoDao.selectByCustNo(agentInfo.getCustNo());
        /*
         * 初始化用户协议表
         */
        ContrUsercontract contrUsercontract = new ContrUsercontract();
        contrUsercontract.setUserInfoId(users.getId());
        contrUsercontract.setAgentInfoId(agentInfo.getId());
        contrUsercontract.setUserName(showCustomVO.getUserName());
        contrUsercontract.setCreateTime(new Date());
        contrUsercontractDao.insert(contrUsercontract);
        /*
         * 初始化客户账户表
         */
        AgentAccount agentAccount = new AgentAccount();
        agentAccount.setAgentInfoId(agentInfo.getId());
        agentAccount.setCustNo(agentInfo.getCustNo());
        agentAccount.setCustType(showCustomVO.getCustType());//客户类型（1:对公；2:对私）
        agentAccount.setCreateTime(new Date());
        agentAccountDao.insert(agentAccount);

        /*
         * 初始化客户信贷信息表
         */
        AgentCreditConfig agentCreditConfig = new AgentCreditConfig();
        agentCreditConfig.setAgentInfoId(agentInfo.getId());
        agentCreditConfig.setCustNo(agentInfo.getCustNo());
        agentCreditConfig.setIsStopLoan("0");//是否停贷（0:否；1:是）
        agentCreditConfig.setCreateTime(new Date());
        agentCreditConfigDao.insert(agentCreditConfig);
    }

    /**
     * 查询客户信贷信息
     */
    public Page<ShowAgentCreditConfigVO> queryCreditConfigPage(QueryAgentCreditConfigVO agentCreditConfigVO, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<ShowAgentCreditConfigVO> page = agentCreditConfigDao.queryCreditConfigPage(agentCreditConfigVO);
        return page;
    }

    /**
     * 设置停贷
     */
    public int updateAgentCreditConfig(AgentCreditConfig agentCreditConfig) {
        String isStopLoan  = agentCreditConfig.getIsStopLoan();
        if("0".equals(isStopLoan)){//设置正常
            agentCreditConfig.setStopLoanReason("");
        }
        agentCreditConfig.setStopLoanTime(new Date());
        return agentCreditConfigDao.updateByPrimaryKeySelective(agentCreditConfig);
    }

    /**
     * 删除相关表信息
     */
    public Integer removeInfo(Integer agentInfoId) {
        //判断客户是否已开户
        AgentAccount agentAccount = agentAccountDao.selectByAgentInfoId(agentInfoId);
        if(ValidateUtils.isNotEmpty(agentAccount.getSubacctNo())){
            return 0;
        }
        //删除客户基本信息表
        agentInfoDao.deleteByPrimaryKey(agentInfoId);
        //删除客户账户表
        agentAccountDao.deleteByPrimaryKey(agentAccount.getId());
        //删除客户信贷表
        AgentCreditConfig agentCreditConfig = agentCreditConfigDao.selectByAgentInfoId(agentInfoId);
        agentCreditConfigDao.deleteByPrimaryKey(agentCreditConfig.getId());
        //删除用户表
        AgentInfo agentInfo = agentInfoDao.selectByPrimaryKey(agentInfoId);
        usersDao.deleteByPrimaryKey(agentInfo.getUserId());
        //删除用户协议表
        ContrUsercontract contrUsercontract = contrUsercontractDao.selectByAgentInfoId(agentInfoId);
        contrUsercontractDao.deleteByPrimaryKey(contrUsercontract.getId());
        return 1;
    }
}
