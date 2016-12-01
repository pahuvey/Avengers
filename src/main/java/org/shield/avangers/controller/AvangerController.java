package org.shield.avangers.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.shield.avangers.model.Avenger;
import org.shield.avangers.service.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/avanger")
public class AvangerController {

	@Autowired
	private AvengerService avengerService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("avanger/index");
		//Get List avangers
		List<Avenger> listAvengers = avengerService.findAll();
		mv.addObject("size", listAvengers.size());
		mv.addObject("list", listAvengers);
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addAvanger(@RequestParam(value="lastName") String lastName, String firstName, String alias, Integer power, Integer id, String photo) {
		Avenger avanger= new Avenger();
		avanger.setId(id);
		avanger.setLastName(lastName);
		avanger.setFirstName(firstName);
		avanger.setAlias(alias);
		avanger.setPower(power);
		
		
		
		if(photo!=null){
			avanger.setPhoto(Base64.decodeBase64(photo));
		}
		avengerService.save(avanger);
		return "redirect:/app/avanger/";
	}

	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addAvangerFormulaire() {
		return "avanger/add-form";
	}
	
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public String delete(@PathVariable("id") Integer id) {
		avengerService.delete(id);
		return "redirect:/app/avanger/";
	}
	
	@RequestMapping (value="/{id}/edit", method=RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") Integer id){
	
	Avenger avanger=new Avenger();
	
	
	avanger = avengerService.getAvenger(id);
	ModelAndView mv = new ModelAndView("avanger/add-form");
	mv.addObject("avanger", avanger);
	
	
		return mv; 
	}

	
	
	
	@RequestMapping(value="/{id}/uploadPhoto", method=RequestMethod.GET)
	public ModelAndView uploadPhoto(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("avanger/upload-form");
		mv.addObject("id", id);
		return mv;
	}
	
	
	
	@RequestMapping(value="/{id}/uploadPhoto", method=RequestMethod.POST)
	public String uploadPhoto(MultipartFile file, @PathVariable("id") Integer idParam) {
		try {
			byte[] bytes = file.getBytes();
		     Avenger avenger = avengerService.getAvenger(idParam);
		     avenger.setPhoto(bytes);
		     avengerService.save(avenger);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/app/avanger/";
	}
	
	@RequestMapping(value="/uploadPhoto", method=RequestMethod.POST)
	public @ResponseBody String uploadPhoto1(MultipartFile file) {
		try {
			byte[] bytes = file.getBytes();
		     return Base64.encodeBase64String(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	
}
