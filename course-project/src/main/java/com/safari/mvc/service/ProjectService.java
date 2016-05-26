package com.safari.mvc.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.safari.mvc.model.Project;

public class ProjectService {

		private List<Project> projects = new LinkedList<Project>();
		
		public ProjectService(){
			Project javaProject = this.createProject(1,"Java Project", "IBM","This is a Java Project" );
			Project javascriptProject = this.createProject(2,"Javascript Project", "Microsoft","This is a Javascript Project");
			Project htmlProject = this.createProject(3,"HTML Project", "Apple","This is an HTML project");
			
			this.projects.addAll(Arrays.asList(new Project[]{javaProject, javascriptProject, htmlProject}));
		}
		
		public List<Project> findAll(){
			return this.projects;
		}
		
		public Project find(Long projectId){
			return (Project) this.projects.stream().filter(p -> {
				return p.getProjectId().equals(projectId);
			}).collect(Collectors.toList()).get(0);
		}
		
		public void save(Project project){
			this.projects.add(project);
		}

		private Project createProject(long id, String title, String sponsor,String description) {
			Project project = new Project();
			project.setProjectId(id);
			project.setName(title);
			project.setSponsor(sponsor);
			project.setAuthorizedFunds(new BigDecimal("100000"));
			project.setAuthorizedHours(new BigDecimal("1000"));
			project.setSpecial(false);
			project.setType("multi");
			project.setYear("2015");
			project.setDescription(description);
			return project;
		}
		
		
		
}
