package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.AgentOreditConfig;
@Mapper
public interface AgentOreditConfigDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AgentOreditConfig record);

    int insertSelective(AgentOreditConfig record);

    AgentOreditConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AgentOreditConfig record);

    int updateByPrimaryKey(AgentOreditConfig record);
}