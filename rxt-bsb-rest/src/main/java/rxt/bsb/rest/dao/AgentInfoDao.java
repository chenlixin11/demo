package rxt.bsb.rest.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.AgentInfo;
import rxt.bsb.rest.vo.showVO.ShowCustomVO;

import java.util.List;

@Mapper
public interface AgentInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(AgentInfo record);

    int insertSelective(AgentInfo record);

    AgentInfo selectByPrimaryKey(Integer id);

    AgentInfo queryAgentInfoByUsersId(Integer userId);

    int updateByPrimaryKeySelective(AgentInfo record);

    int updateByPrimaryKey(AgentInfo record);

    Page<AgentInfo> queryAgentInfoList(AgentInfo agentInfo);

    /**
     * 根据客户名称查询客户
     * @param custName
     * @return
     */
    List<AgentInfo> queryAgentInfoByCustName(String custName);

    int insertAgentInfo(ShowCustomVO saveAgentVO);

    /**
     * 获取客户信息表id
     */
    AgentInfo queryAgentByCustName(ShowCustomVO saveAgentVO);

    AgentInfo selectByCustNo(String custNo);
}