package org.shield.avangers.service.impl;

import org.shield.avangers.dao.AgentDAO;
import org.shield.avangers.model.Agent;
import org.shield.avangers.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("agentService")
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentDAO agentDAO;
	
	public Agent getAgent(int id) {
		return agentDAO.getById(id);
	}

}
