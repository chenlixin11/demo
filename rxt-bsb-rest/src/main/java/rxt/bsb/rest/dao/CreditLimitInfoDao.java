package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.CreditLimitInfo;
@Mapper
public interface CreditLimitInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditLimitInfo record);

    int insertSelective(CreditLimitInfo record);

    CreditLimitInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditLimitInfo record);

    int updateByPrimaryKey(CreditLimitInfo record);
}