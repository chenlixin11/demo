package rxt.bsb.rest.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.common.util.Encipher;
import rxt.bsb.rest.common.util.ValidateUtils;
import rxt.bsb.rest.po.*;
import rxt.bsb.rest.service.CustomInfoService;
import rxt.bsb.rest.service.UsersService;
import rxt.bsb.rest.vo.QueryVO.QueryAgentCreditConfigVO;
import rxt.bsb.rest.vo.showVO.ShowAgentCreditConfigVO;
import rxt.bsb.rest.vo.showVO.ShowCustomVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 * @Copyright (c)</ b> 2012融信通-版权所有<br/>
 * @createTime: 2019/10/21 14:23
 * @Description:
 */
@RestController
@RequestMapping("custom")
public class CustomController<main> {

    private final static Logger logger = LoggerFactory.getLogger(CustomController.class);

    @Autowired
    private CustomInfoService customInfoService;
    @Autowired
    private UsersService usersService;

    /**
     * 分页查询
     */
    @RequestMapping( value = "page" ,method = { RequestMethod.GET ,RequestMethod.POST})
    PageInfo<AgentInfo> queryAgnetInfoList(HttpServletRequest request, AgentInfo agentInfo, @RequestParam(name = "pageNo" ,defaultValue = "1") int pageNo , @RequestParam(name = "pageSize" ,defaultValue = "10")int pageSize ) throws  Exception{
        //System.out.println(agentInfo.getCustName());
        //System.out.println(agentInfo.getCustNo());
        //System.out.println(agentInfo.getCustType());
        //System.out.println(agentInfo.getIsBankStaff());
        Page<AgentInfo> page = customInfoService.queryAgentInfoList(agentInfo,pageNo,pageSize);
        PageInfo<AgentInfo> agentInfoList=  new PageInfo<>(page);
        return agentInfoList;
    }

    /**
     * 添加客户信息
     */
    @PostMapping( "add" )
    public Object save(ShowCustomVO showCustomVO) {
        try {
            //后台校验userName是否存在
            int n = usersService.selectByUserName(showCustomVO.getUserName());
            if(n == 1){
                logger.error("用户名已存在");
                return ResultCode.ERROR;
            }else{
                //保存相关表信息
                customInfoService.saveInfo(showCustomVO);
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("保存客户异常",e);
            return ResultCode.ERROR;
        }
        return ResultCode.SUCCESS;
    }
    /**
     * 修改客户信息
     */
    @PutMapping("update")
    private Object updateAgentInfo(AgentInfo agentInfo){
        return customInfoService.updateAgentInfo(agentInfo) == 1 ? ResultCode.SUCCESS: ResultCode.ERROR;
    }

    /**
     * 重置密码
     */
    @PutMapping("resetPwd/{userId}")
    public Object resetPwd(@PathVariable Integer userId){
        //System.out.println(userId);
        return usersService.resetPwd(userId) == 1 ? ResultCode.SUCCESS: ResultCode.ERROR;
    }

    /**
     * 删除客户信息
     */
    @DeleteMapping("remove/{id}")
    public Object removeAgentInfo(@PathVariable Integer agentInfoId) {
        //System.out.println(id);
        try {
            //删除相关表信息
            Integer n = customInfoService.removeInfo(agentInfoId);
            if(n == 1){
                return ResultCode.SUCCESS;
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("删除客户异常",e);
            return ResultCode.ERROR;
        }
        return ResultCode.SUCCESS;
    }

    /**
     * 根据客户名称查询客户信息
     * @param request
     * @param custName
     * @return
     */
    @RequestMapping(value = "showCust",method = {RequestMethod.POST})
    public Object showAgentInfoByCustName(HttpServletRequest request,String custName){
        return customInfoService.queryAgentInfoByCustName(custName);
    }

    //====================================  信贷设置类   start=========================================
    /**
     * 查询客户信贷设置
     */
    @RequestMapping( value = "creditConfig" ,method = { RequestMethod.GET ,RequestMethod.POST})
    PageInfo<ShowAgentCreditConfigVO> queryCreditConfigPage(HttpServletRequest request, QueryAgentCreditConfigVO agentCreditConfigVO, @RequestParam(name = "pageNo" ,defaultValue = "1") int pageNo , @RequestParam(name = "pageSize" ,defaultValue = "10")int pageSize ){
        Page<ShowAgentCreditConfigVO> page = customInfoService.queryCreditConfigPage(agentCreditConfigVO, pageNo, pageSize);
        PageInfo<ShowAgentCreditConfigVO> uPage=  new PageInfo<>(page);
        return uPage;
    }

    /**
     *  设置停贷
     */
    @PutMapping("updateCreditConfig")
    public Object updateCreditConfig(AgentCreditConfig agentCreditConfig){
        return customInfoService.updateAgentCreditConfig(agentCreditConfig) == 1 ? ResultCode.SUCCESS: ResultCode.ERROR;
    }

    //====================================  信贷设置类   end=========================================


    public static void main(String args[]){
        System.out.println(Encipher.Encode("123456"));
        //System.out.println(Encipher.Decode("?g=h?dclQ5@44*I:7)"));
    }
}
