package org.shield.avangers.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.shield.avangers.model.Avenger;
import org.shield.avangers.service.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/avengers")
public class RestAvangerController {

	@Autowired
	private AvengerService avengerService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Avenger> listAvengers(){
		return avengerService.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Avenger avenger(@PathVariable("id") Integer id){
		return avengerService.getAvenger(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void add(@RequestBody Avenger avenger){
		
		avengerService.save(avenger);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id){
		avengerService.delete(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") Integer id, @RequestBody Avenger avenger ){
		avenger.setId(id);
		avengerService.save(avenger);
		
	}
	
}
