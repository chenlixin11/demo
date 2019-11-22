package rxt.bsb.rest.dao;

import com.github.pagehelper.Page;
import rxt.bsb.rest.po.CreditApply;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.vo.QueryVO.QueryCreditApplyVO;
import rxt.bsb.rest.vo.showVO.ShowCreditApplyVO;

@Mapper
public interface CreditApplyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditApply record);

    int insertSelective(CreditApply record);

    CreditApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditApply record);

    int updateByPrimaryKeyWithBLOBs(CreditApply record);

    int updateByPrimaryKey(CreditApply record);

    Page<ShowCreditApplyVO> queryCreditApplyPage(QueryCreditApplyVO company);

}