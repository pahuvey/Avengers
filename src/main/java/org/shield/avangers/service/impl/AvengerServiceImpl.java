package org.shield.avangers.service.impl;

import java.util.List;

import org.shield.avangers.dao.AgentDAO;
import org.shield.avangers.dao.AvengerDAO;
import org.shield.avangers.model.Agent;
import org.shield.avangers.model.Avenger;
import org.shield.avangers.service.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("avengerService")
public class AvengerServiceImpl implements AvengerService {
	
	@Autowired
	private AvengerDAO avengerdao;
	
	@Autowired
	private AgentDAO agentDAO;

	public Avenger getAvenger(int id) {
		return avengerdao.getById(id);
	}

	public void save(Avenger avenger) {
		Agent agent = agentDAO.getById(10);
		avenger.setAgent(agent);
		avengerdao.save(avenger);
	}

	public void delete(Integer id) {
		avengerdao.delete(id);
	}

	public List<Avenger> findAll() {
		return avengerdao.findAll();
	}

}
