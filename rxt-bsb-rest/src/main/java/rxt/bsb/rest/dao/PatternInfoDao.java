package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.PatternInfo;
@Mapper
public interface PatternInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PatternInfo record);

    int insertSelective(PatternInfo record);

    PatternInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PatternInfo record);

    int updateByPrimaryKey(PatternInfo record);
}