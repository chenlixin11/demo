package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.LogBusiness;
@Mapper
public interface LogBusinessDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LogBusiness record);

    int insertSelective(LogBusiness record);

    LogBusiness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogBusiness record);

    int updateByPrimaryKey(LogBusiness record);
}