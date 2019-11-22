package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.CreditApplyOrderRel;
@Mapper
public interface CreditApplyOrderRelDao {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditApplyOrderRel record);

    int insertSelective(CreditApplyOrderRel record);

    CreditApplyOrderRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditApplyOrderRel record);

    int updateByPrimaryKey(CreditApplyOrderRel record);
}