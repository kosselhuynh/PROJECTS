package com.springdatabase.basics.databasedemo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdatabase.basics.databasedemo.entity.Contact;
import com.springdatabase.basics.databasedemo.entity.User;
import com.springdatabase.basics.databasedemo.service.ContactService;

@Controller
public class ContactController {
@Autowired ContactService contactService;

	@RequestMapping(value = "/actionSendMail")
	public String sendEmail(@ModelAttribute("contact") Contact contact, Model model) {
		contact.setDateSend(new Date());
		contactService.insert(contact);
		String messageReturn = "Send mail successful !";
		model.addAttribute("messagereturn", messageReturn);
		return "contact";
    }
}
