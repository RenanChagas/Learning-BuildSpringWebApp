package com.safari.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.safari.mvc.service.ProjectService;
import com.safari.mvc.validator.ProjectValidator;
import com.safari.mvc.model.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/{projectId}")
	public String findProject(Model model, @PathVariable long projectId){
		model.addAttribute("project", this.projectService.find(projectId));
		return "project";
	}
	
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
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors){
		if(!errors.hasErrors()){
			System.out.println("The project validated");
		}else{
			System.out.println("The project did not validated");
		}
		System.out.println(project);
		return "redirect:/project/find";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params={"type=multi","special"})
	public String saveSpecialProject(@Valid @ModelAttribute Project project, RedirectAttributes attributes){
		System.out.println("Invoking saveSpecialProject");
		project.setProjectId(55L);
		this.projectService.save(project);
		attributes.addAttribute("projectId", project.getProjectId().toString());
		return "redirect:/";
	}
	
	/* Validators */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProjectValidator());
	}

}