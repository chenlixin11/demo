package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.FeeoutinRecord;
@Mapper
public interface FeeoutinRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(FeeoutinRecord record);

    int insertSelective(FeeoutinRecord record);

    FeeoutinRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FeeoutinRecord record);

    int updateByPrimaryKey(FeeoutinRecord record);
}