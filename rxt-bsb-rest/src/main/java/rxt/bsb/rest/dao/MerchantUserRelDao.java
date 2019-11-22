package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.MerchantUserRel;
@Mapper
public interface MerchantUserRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantUserRel record);

    int insertSelective(MerchantUserRel record);

    MerchantUserRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantUserRel record);

    int updateByPrimaryKey(MerchantUserRel record);
}