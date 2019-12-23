package com.springdatabase.basics.databasedemo.Validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springdatabase.basics.databasedemo.entity.User;
import com.springdatabase.basics.databasedemo.service.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	UserService userJpaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "NotEmpty");
        if (user.getFullname().length() < 1 || user.getFullname().length() > 32) {
            errors.rejectValue("fullname", "Size.userForm.fullName");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if(!StringUtils.isEmpty(user.getEmail())) {
        	if (userJpaRepository.findByEmail(user.getEmail())) {
                errors.rejectValue("email", "Duplicate.userForm.emailname");
            }
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty");
        if(!StringUtils.isEmpty(user.getConfirmPassword()) && !StringUtils.isEmpty(user.getPassword())) {
        	if (!user.getConfirmPassword().equals(user.getPassword())) {
                errors.rejectValue("confirmPassword", "Diff.userForm.confirmPassword");
            }
        }
        
		
	}

}
