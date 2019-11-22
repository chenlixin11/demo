package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.StatLoanBalanceDays;
@Mapper
public interface StatLoanBalanceDaysDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StatLoanBalanceDays record);

    int insertSelective(StatLoanBalanceDays record);

    StatLoanBalanceDays selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StatLoanBalanceDays record);

    int updateByPrimaryKey(StatLoanBalanceDays record);
}