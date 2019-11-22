package rxt.bsb.rest.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import rxt.bsb.rest.po.MerchantAcct;


@Mapper
public interface MerchantAcctDao {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantAcct record);

    int insertSelective(MerchantAcct record);

    MerchantAcct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantAcct record);

    int updateByPrimaryKey(MerchantAcct record);

    Page<MerchantAcct> findByPage(MerchantAcct merchant);
}