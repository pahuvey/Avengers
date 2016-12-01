package org.shield.avangers;

import org.shield.avangers.model.Agent;
import org.shield.avangers.model.Avenger;
import org.shield.avangers.service.AgentService;
import org.shield.avangers.service.AvengerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {	

		
		ApplicationContext appContext = 
	    		new ClassPathXmlApplicationContext("spring/config/application-context.xml");
	
		
		Avenger avenger = new Avenger();
		avenger.setLastName("STARK");
		avenger.setFirstName("Tony");
		avenger.setAlias("Iron man");
		
	
		
		AvengerService avengerService = (AvengerService) appContext.getBean("avengerService");
		
		AgentService agentService = (AgentService) appContext.getBean("agentService");
		
		
		//avengerService.save(avenger);
		Agent agentFury = agentService.getAgent(10);
		
		System.out.println("Nom : "+agentFury.getLastName());
		System.out.println("Prénom : "+agentFury.getFirstName());
		
		System.out.println("Liste des avengers : ");
		
		for(Avenger avenger1 : agentFury.getAvengers()) {
			System.out.println("----- " + avenger1.getAlias());
		}
		
		Avenger avengerToDelete = avengerService.getAvenger(70);
		
		avengerService.delete(avengerToDelete.getId());
		
		
		
		
	}

}
