package com.springdatabase.basics.databasedemo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdatabase.basics.databasedemo.entity.Contact;
import com.springdatabase.basics.databasedemo.entity.Files;
import com.springdatabase.basics.databasedemo.entity.Trending;
import com.springdatabase.basics.databasedemo.restcontroller.NhatDatRestController;
import com.springdatabase.basics.databasedemo.service.FilesService;
import com.springdatabase.basics.databasedemo.service.TrendingService;

@Controller
public class FilesController {
	/*private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FilesService filesJpaRepository;
	@Autowired
	TrendingService trendingService;
	@Autowired
	FilesRestController fileRestController;

	@RequestMapping(value = {"","/","files"})
	public String persons(Model model, HttpServletRequest request) {
		List<Files> arrayFiles = new ArrayList<Files>();
		arrayFiles = filesJpaRepository.findAll_where_Top10();
		model.addAttribute("files", arrayFiles);
		System.out.println(request.getRemoteAddr());
		return "files";
	}

	@GetMapping("trending")
	public String trending() {
		return "trending";
	}
	
	@GetMapping("topdownloads")
	public String topdownload(Model model) {
		return "topdownload";
	}
	
	
	@GetMapping("actionFormSearch")
	public String formSearch(@RequestParam("nameSearch") String nameSearch, @RequestParam("catalogy") String catalogy) {
		fileRestController.nameSearch = StringUtils.trim(nameSearch.toLowerCase());
		fileRestController.catalogy = StringUtils.trim(catalogy);
		return "searching";
	}

	
	@RequestMapping("{id}")
	public String downloads(@PathVariable("id") int id, Model model) {
		String urlEZ4Linkss = "https://ez4linkss.com/st?api=48d62de687b299c7bdcf23f9895928e092e813b1&url=";
		System.out.println("----------TEST DOWNLOADS-------" + id);
		Files file = filesJpaRepository.findById(id);
		increaseDownloads(file);
		model.addAttribute("path", urlEZ4Linkss + file.getPathView());
		model.addAttribute("name", file.getName());
		return "download";
	}

	
	@RequestMapping("contact")
	public String contact(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "contact";
	}

	@RequestMapping("upload")
	public String upload() {

		return "files";
	}

	// Func Utils
	public void increaseDownloads(Files file) {
		file.setDownloads(file.getDownloads() + 1);
		filesJpaRepository.insert(file);
	}

	*/
}
