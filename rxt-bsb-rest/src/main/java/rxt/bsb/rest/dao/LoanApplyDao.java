package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.LoanApply;
@Mapper
public interface LoanApplyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanApply record);

    int insertSelective(LoanApply record);

    LoanApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanApply record);

    int updateByPrimaryKey(LoanApply record);
}