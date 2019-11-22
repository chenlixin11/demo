package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.AcctTransRecord;
@Mapper
public interface AcctTransRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AcctTransRecord record);

    int insertSelective(AcctTransRecord record);

    AcctTransRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AcctTransRecord record);

    int updateByPrimaryKey(AcctTransRecord record);
}