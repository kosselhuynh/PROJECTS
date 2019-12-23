package com.springdatabase.basics.databasedemo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdatabase.basics.databasedemo.entity.User;
import com.springdatabase.basics.databasedemo.repository.FilesRepository;
import com.springdatabase.basics.databasedemo.service.ContactService;
import com.springdatabase.basics.databasedemo.service.FilesService;
import com.springdatabase.basics.databasedemo.service.TrendingService;
import com.springdatabase.basics.databasedemo.service.UserService;
import com.springdatabase.basics.databasedemo.controller.CountCatalogy;;


@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	FilesRepository filesRepository;
	
	@Autowired
	TrendingService trendingService;
	
	@RequestMapping("login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("/actionLogin")
	public String actionLogin(@ModelAttribute("user") User user, Model model, BindingResult bindingResult) {
		if (userService.findAll_where_emailAndpassword(user.getEmail(), user.getPassword())) {
			model.addAttribute("email", "Hello "+ user.getEmail());
			
			 /* List<CountCatalogy> listCountCatalogy = new ArrayList<CountCatalogy>();
			  listCountCatalogy.get(0).getCatalogy()
			  listCountCatalogy = filesRepository.findCatalogyCount(); for (CountCatalogy
			  countCatalogy : listCountCatalogy) { System.out.println("Catalogy : " +
			  countCatalogy.getCatalogy()); System.out.println("Count = " +
			  countCatalogy.getCount());}*/ 
			
			model.addAttribute("listTrending", trendingService.findAll());
			model.addAttribute("listCountCatalogy", filesRepository.findCatalogyCount());
			model.addAttribute("contacts", contactService.findAll());
			return "dashboard";
		} else {
			logger.info("Fail-----"+userService.findAll_where_emailAndpassword(user.getEmail(), user.getPassword()));
			model.addAttribute("error",true);
			return "login";
		
		}
	}
	
	

	 

}
