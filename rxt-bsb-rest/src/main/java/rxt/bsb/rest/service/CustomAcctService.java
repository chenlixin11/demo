package rxt.bsb.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.dao.AgentAccountDao;

@Service
public class CustomAcctService {
    @Autowired
    private AgentAccountDao agentAccountDao;

}
