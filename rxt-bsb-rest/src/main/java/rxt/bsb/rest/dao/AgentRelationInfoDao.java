package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.AgentRelationInfo;
@Mapper
public interface AgentRelationInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AgentRelationInfo record);

    int insertSelective(AgentRelationInfo record);

    AgentRelationInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AgentRelationInfo record);

    int updateByPrimaryKey(AgentRelationInfo record);
}