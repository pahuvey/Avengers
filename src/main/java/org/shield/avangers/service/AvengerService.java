package org.shield.avangers.service;

import java.util.List;

import org.shield.avangers.model.Avenger;

public interface AvengerService {
	
	public Avenger getAvenger(int id);
	
	public void save(Avenger avenger);
	
	public void delete(Integer id);

	public List<Avenger> findAll();

}
