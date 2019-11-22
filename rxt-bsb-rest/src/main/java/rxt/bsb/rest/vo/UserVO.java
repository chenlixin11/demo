package rxt.bsb.rest.vo;

import rxt.bsb.rest.po.AgentInfo;
import rxt.bsb.rest.po.Users;

import java.io.Serializable;

/**
 * @program: rxt-bsb
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-29 14:48
 **/
public class UserVO implements Serializable {
    private Users users;
    private AgentInfo agentInfo;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public AgentInfo getAgentInfo() {
        return agentInfo;
    }

    public void setAgentInfo(AgentInfo agentInfo) {
        this.agentInfo = agentInfo;
    }
}
