package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.Holidays;
@Mapper
public interface HolidaysDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Holidays record);

    int insertSelective(Holidays record);

    Holidays selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Holidays record);

    int updateByPrimaryKey(Holidays record);
}