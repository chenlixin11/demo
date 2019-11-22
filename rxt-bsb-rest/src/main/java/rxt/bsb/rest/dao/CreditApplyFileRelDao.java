package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.CreditApplyFileRel;
@Mapper
public interface CreditApplyFileRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditApplyFileRel record);

    int insertSelective(CreditApplyFileRel record);

    CreditApplyFileRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditApplyFileRel record);

    int updateByPrimaryKey(CreditApplyFileRel record);
}