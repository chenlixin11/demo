package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.CodeCity;
@Mapper
public interface CodeCityDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeCity record);

    int insertSelective(CodeCity record);

    CodeCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeCity record);

    int updateByPrimaryKey(CodeCity record);
}