package com.safari.mvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.safari.mvc.model.Project;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Project project = (Project) obj;
		
		if (project.getName().length() < 5){
			errors.rejectValue("name", "project.name", "The name is too short");
		} 	
	}

}
