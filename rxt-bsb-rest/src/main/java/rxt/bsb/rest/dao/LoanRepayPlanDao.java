package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.LoanRepayPlan;
@Mapper
public interface LoanRepayPlanDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanRepayPlan record);

    int insertSelective(LoanRepayPlan record);

    LoanRepayPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanRepayPlan record);

    int updateByPrimaryKey(LoanRepayPlan record);
}