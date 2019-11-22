package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.LoanApplyFileRel;
@Mapper
public interface LoanApplyFileRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanApplyFileRel record);

    int insertSelective(LoanApplyFileRel record);

    LoanApplyFileRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanApplyFileRel record);

    int updateByPrimaryKey(LoanApplyFileRel record);
}