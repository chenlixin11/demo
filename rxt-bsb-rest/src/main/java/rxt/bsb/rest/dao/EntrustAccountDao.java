package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.EntrustAccount;
@Mapper
public interface EntrustAccountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EntrustAccount record);

    int insertSelective(EntrustAccount record);

    EntrustAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntrustAccount record);

    int updateByPrimaryKey(EntrustAccount record);
}