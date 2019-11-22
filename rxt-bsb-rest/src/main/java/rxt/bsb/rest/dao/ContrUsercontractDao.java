package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.ContrUsercontract;
@Mapper
public interface ContrUsercontractDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ContrUsercontract record);

    int insertSelective(ContrUsercontract record);

    ContrUsercontract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContrUsercontract record);

    int updateByPrimaryKey(ContrUsercontract record);

    ContrUsercontract selectByAgentInfoId(Integer agentInfoId);
}