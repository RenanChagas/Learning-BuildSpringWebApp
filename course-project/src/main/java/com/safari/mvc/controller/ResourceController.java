package com.safari.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.safari.mvc.model.Resource;
import com.safari.mvc.service.ResourceService;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {
	
	@Autowired
	private ResourceService resourceService;
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model){
		model.addAttribute("resource", new Resource());
		return "resource_add";
	}
	
	@RequestMapping(value="/add2", method=RequestMethod.POST)
	public String save2(@ModelAttribute Resource resource){
		System.out.println("Invoking save() method");
		System.out.println(resource);
		return "resource_add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(@ModelAttribute Resource resource, SessionStatus status){
		status.setComplete();
		return "resource";
	}
	
	@RequestMapping("/find")
	public String find(Model model){
		model.addAttribute("resources", resourceService.findAll());
		return "resources";
	}
	
	@RequestMapping("/{resourceId}")
	@ResponseBody
	public Resource findResource(@PathVariable("resourceId") Long resourceId){
		return resourceService.find(resourceId);
	}
	
	
	
}
