package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.CodeBank;
@Mapper
public interface CodeBankDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeBank record);

    int insertSelective(CodeBank record);

    CodeBank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeBank record);

    int updateByPrimaryKey(CodeBank record);
}