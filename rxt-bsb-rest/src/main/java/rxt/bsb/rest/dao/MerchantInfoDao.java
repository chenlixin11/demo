package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.MerchantInfo;
@Mapper
public interface MerchantInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantInfo record);

    int insertSelective(MerchantInfo record);

    MerchantInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantInfo record);

    int updateByPrimaryKey(MerchantInfo record);
}