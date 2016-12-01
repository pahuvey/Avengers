package org.shield.avangers.dao;

import java.util.List;

import org.shield.avangers.model.Avenger;

public interface AvengerDAO {
	
	public Avenger getById(int id);
	
	public void save(Avenger avanger);
	
	public void delete(Integer avenger);

	public List<Avenger> findAll();

}
