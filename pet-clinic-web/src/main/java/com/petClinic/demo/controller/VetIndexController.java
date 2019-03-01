package com.petClinic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petClinic.demo.service.VetService;

@Controller
@RequestMapping({"vets", "vets.html"})
public class VetIndexController {
	
	
	private final VetService vetService;
	
	@Autowired
	public VetIndexController(VetService vetService) {
		this.vetService = vetService;
	}


	@RequestMapping({"","/","/index","/index.html", "/vets.html"})
	public String vetIndex(Model theModel) {
		theModel.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
	
	@RequestMapping("/find")
    public String find(){

        return "notImplemented";
    }
	
	@RequestMapping("/oups")
    public String oupsHandler(){

        return "notImplemented";
    }

}
