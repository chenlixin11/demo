package rxt.bsb.rest.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.AgentCreditConfig;
import rxt.bsb.rest.vo.QueryVO.QueryAgentCreditConfigVO;
import rxt.bsb.rest.vo.showVO.ShowAgentCreditConfigVO;

@Mapper
public interface AgentCreditConfigDao {

    int deleteByPrimaryKey(Integer id);

    int insert(AgentCreditConfig record);

    int insertSelective(AgentCreditConfig record);

    AgentCreditConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AgentCreditConfig record);

    int updateByPrimaryKey(AgentCreditConfig record);

    Page<ShowAgentCreditConfigVO> queryCreditConfigPage(QueryAgentCreditConfigVO creditApply);

    AgentCreditConfig selectByAgentInfoId(Integer agentInfoId);
}