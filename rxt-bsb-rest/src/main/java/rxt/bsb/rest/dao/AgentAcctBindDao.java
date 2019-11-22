package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.AgentAcctBind;
@Mapper
public interface AgentAcctBindDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AgentAcctBind record);

    int insertSelective(AgentAcctBind record);

    AgentAcctBind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AgentAcctBind record);

    int updateByPrimaryKey(AgentAcctBind record);
}