package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.EntrustRecord;
@Mapper
public interface EntrustRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(EntrustRecord record);

    int insertSelective(EntrustRecord record);

    EntrustRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntrustRecord record);

    int updateByPrimaryKey(EntrustRecord record);
}