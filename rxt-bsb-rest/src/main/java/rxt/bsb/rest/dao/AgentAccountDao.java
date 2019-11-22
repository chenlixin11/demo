package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.AgentAccount;
@Mapper
public interface AgentAccountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AgentAccount record);

    int insertSelective(AgentAccount record);

    AgentAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AgentAccount record);

    int updateByPrimaryKey(AgentAccount record);

    AgentAccount selectByAgentInfoId(Integer agentInfoId);
}