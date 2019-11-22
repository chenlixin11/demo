package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.LoanRepayInfo;
@Mapper
public interface LoanRepayInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanRepayInfo record);

    int insertSelective(LoanRepayInfo record);

    LoanRepayInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanRepayInfo record);

    int updateByPrimaryKey(LoanRepayInfo record);
}