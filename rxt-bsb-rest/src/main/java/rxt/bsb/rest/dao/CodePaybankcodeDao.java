package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.CodePaybankcode;
@Mapper
public interface CodePaybankcodeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CodePaybankcode record);

    int insertSelective(CodePaybankcode record);

    CodePaybankcode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodePaybankcode record);

    int updateByPrimaryKey(CodePaybankcode record);
}