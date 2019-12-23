package com.springdatabase.basics.databasedemo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdatabase.basics.databasedemo.entity.User;
import com.springdatabase.basics.databasedemo.service.RegisterService;

@Controller
public class RegisterController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RegisterService registerJpaRepository;
//	@Autowired
//    private UserValidator userValidator;
	
	@RequestMapping("register")
	public String register(@ModelAttribute User user, Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping("/actionRegister")
	public String actionRegister(@Valid @ModelAttribute("user")  User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "register";
        }
		user.setUserId(2);//sai ne
		registerJpaRepository.insert(user);
		return "files";
	
	}


}
