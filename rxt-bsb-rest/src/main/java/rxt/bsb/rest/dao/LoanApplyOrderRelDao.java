package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.LoanApplyOrderRel;
@Mapper
public interface LoanApplyOrderRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanApplyOrderRel record);

    int insertSelective(LoanApplyOrderRel record);

    LoanApplyOrderRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanApplyOrderRel record);

    int updateByPrimaryKey(LoanApplyOrderRel record);
}