package com.petClinic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petClinic.demo.service.OwnerService;

@Controller
@RequestMapping("owners")
public class OwnerIndexController {
	
	private final OwnerService ownerService;	
	
	@Autowired
	public OwnerIndexController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"","/","/index","/index.html"})
	public String ownerIndex(Model theModel) {
		theModel.addAttribute("owners", ownerService.findAll());
		return "owner/index";
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
