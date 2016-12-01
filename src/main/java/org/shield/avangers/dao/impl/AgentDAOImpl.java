package org.shield.avangers.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.shield.avangers.dao.AgentDAO;
import org.shield.avangers.model.Agent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("agentDao")
@Transactional
public class AgentDAOImpl implements AgentDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Agent getById(int id) {
		Agent agent = entityManager.find(Agent.class, id);
		return agent;
	}

}
