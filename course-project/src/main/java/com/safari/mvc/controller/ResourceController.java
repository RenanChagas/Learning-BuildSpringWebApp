package com.safari.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safari.mvc.model.Resource;

@Controller
@RequestMapping("/resource")
public class ResourceController {
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("resource", new Resource());
		return "resource_add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(@ModelAttribute Resource resource){
		System.out.println("Invoking save() method");
		System.out.println(resource);
		return "resource_add";
	}
	
}
