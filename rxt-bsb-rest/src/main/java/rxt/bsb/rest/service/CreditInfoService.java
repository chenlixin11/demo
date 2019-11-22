package rxt.bsb.rest.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.dao.AgentCreditConfigDao;
import rxt.bsb.rest.po.CreditApply;
import rxt.bsb.rest.vo.QueryVO.QueryCreditApplyVO;
import rxt.bsb.rest.vo.showVO.ShowCreditApplyVO;
import rxt.bsb.rest.dao.CreditApplyDao;

import java.util.Date;

@Service
public class CreditInfoService {
    @Autowired
    private  CreditApplyDao creditApplyDao;

    public Page<ShowCreditApplyVO> queryCreditApplyPage(QueryCreditApplyVO creditApply, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<ShowCreditApplyVO> page = creditApplyDao.queryCreditApplyPage(creditApply);
        return page;
    }

    /**
     * 更新授信申请
     * @param creditApply
     */
    public int updateCreditApply(CreditApply creditApply){
      return   creditApplyDao.updateByPrimaryKeySelective(creditApply);
    }

    public int  insertCreditApply(CreditApply creditApply){
        creditApply.setId(null);
        creditApply.setCreateTime(new Date());
      return  creditApplyDao.insertSelective(creditApply);
    }

    public int deleteCreditApply(CreditApply creditApply){
        return creditApplyDao.updateByPrimaryKey(creditApply);
    }

}
