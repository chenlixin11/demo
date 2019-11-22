package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.LogLoginInfo;
@Mapper
public interface LogLoginInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LogLoginInfo record);

    int insertSelective(LogLoginInfo record);

    LogLoginInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogLoginInfo record);

    int updateByPrimaryKey(LogLoginInfo record);
}