package com.safari.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safari.mvc.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/find")
	public String find(Model model){
		model.addAttribute("projects", projectService.findAll());
		return "projects";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addProject(){
		System.out.println("Invoking addProject");
		return "project_add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String saveProject(){
		System.out.println("Invoking saveProject");
		return "project_add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi"})
	public String saveMultiYearProject(){
		System.out.println("Invoking saveMultiYearProject");
		return "project_add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi","special"})
	public String saveSpecialProject(){
		System.out.println("Invoking saveSpecialProject");
		return "project_add";
	}

}