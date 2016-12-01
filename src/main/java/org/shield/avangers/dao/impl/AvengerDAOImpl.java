package org.shield.avangers.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.shield.avangers.dao.AvengerDAO;
import org.shield.avangers.model.Avenger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("avengerDAO")
@Transactional
public class AvengerDAOImpl implements AvengerDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Avenger getById(int id) {
		Avenger avanger = entityManager.find(Avenger.class, id);
		return avanger;
	}

	public void save(Avenger avanger) {
		entityManager.merge(avanger);
	}

	public void delete(Integer id) {
		Avenger attached = entityManager.find(Avenger.class, id);
		entityManager.remove(attached);
		
	}

	public List<Avenger> findAll() {
		String query = "SELECT avenger FROM Avenger avenger";
		String sql = "select * from avenger";
		List<Avenger> list  = (List<Avenger>) entityManager.createQuery(query).getResultList();
		
		return list;
	}
	
	

}
