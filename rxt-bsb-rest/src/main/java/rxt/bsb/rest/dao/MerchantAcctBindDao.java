package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.MerchantAcctBind;
@Mapper
public interface MerchantAcctBindDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantAcctBind record);

    int insertSelective(MerchantAcctBind record);

    MerchantAcctBind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantAcctBind record);

    int updateByPrimaryKey(MerchantAcctBind record);
}