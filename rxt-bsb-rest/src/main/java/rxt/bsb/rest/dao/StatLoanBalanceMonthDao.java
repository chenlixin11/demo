package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.StatLoanBalanceMonth;
@Mapper
public interface StatLoanBalanceMonthDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StatLoanBalanceMonth record);

    int insertSelective(StatLoanBalanceMonth record);

    StatLoanBalanceMonth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StatLoanBalanceMonth record);

    int updateByPrimaryKey(StatLoanBalanceMonth record);
}