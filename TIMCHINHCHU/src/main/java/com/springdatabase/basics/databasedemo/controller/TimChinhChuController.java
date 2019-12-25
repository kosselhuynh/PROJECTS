package com.springdatabase.basics.databasedemo.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.springdatabase.basics.databasedemo.entity.Contact;
import com.springdatabase.basics.databasedemo.entity.Files;
import com.springdatabase.basics.databasedemo.entity.NhaDat;
import com.springdatabase.basics.databasedemo.entity.SDTCO;
import com.springdatabase.basics.databasedemo.restcontroller.NhatDatRestController;
import com.springdatabase.basics.databasedemo.service.FilesService;
import com.springdatabase.basics.databasedemo.service.NhaDatService;
import com.springdatabase.basics.databasedemo.service.SDTCOService;
import com.springdatabase.basics.databasedemo.service.TrendingService;

@Controller
public class TimChinhChuController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FilesService filesJpaRepository;
	@Autowired
	TrendingService trendingService;
	@Autowired
	NhatDatRestController nhaDatRestController;
	@Autowired
	SDTCOService sdtCOService;
	
	@Autowired
	NhaDatService nhadatService;
	public static Map<Integer,String> tinhTP = new LinkedHashMap<Integer,String>();

	
	@RequestMapping(value = {"","/","files"})
	public String persons(Model model, HttpServletRequest request) {
		Utils.createtinhTP(tinhTP);
		model.addAttribute("tinhTP", tinhTP);
		return "timchinhchu";
	}

	@GetMapping("{i}")
	public String catalogy(@PathVariable("i") int i, Model model, HttpServletRequest request) {
		if(i < 100) {
			List<NhaDat> arrayNhaDat = new ArrayList<NhaDat>();
			arrayNhaDat = nhadatService.findAll_With_RegionName(tinhTP.get(i));
			model.addAttribute("listAreaName", Utils.createWardName(arrayNhaDat));
			model.addAttribute("tinhTP", tinhTP);
			
		}else {
			SDTCO sdtCo = new SDTCO();
			sdtCo.setPhone("0" + String.valueOf(i));
			sdtCOService.insert(sdtCo );
		}
		
		return "timchinhchu";
		
	}
	
	
	
	
	@GetMapping("actionFormSearch")
	public String formSearch(@RequestParam("nameSearch") String nameSearch, @RequestParam("catalogy") String catalogy) {
		nhaDatRestController.nameSearch = StringUtils.trim(nameSearch.toLowerCase());
		nhaDatRestController.catalogy = StringUtils.trim(catalogy);
		return "searching";
	}
	
	
	
	

	@GetMapping("trending")
	public String trending() {
		return "trending";
	}
	
	@GetMapping("backupdb")
	public String topdownload(Model model) {
		
		return "topdownload";
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

	
}
