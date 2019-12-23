package com.springdatabase.basics.databasedemo.restcontroller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdatabase.basics.databasedemo.entity.Files;
import com.springdatabase.basics.databasedemo.entity.Trending;
import com.springdatabase.basics.databasedemo.entity.User;
import com.springdatabase.basics.databasedemo.service.FilesService;
import com.springdatabase.basics.databasedemo.service.TrendingService;



@RestController
public class FilesRestController {
	@Autowired
	FilesService filesService;
	@Autowired
	TrendingService trendingService;
	public static String nameSearch;
	public static String catalogy;
	@GetMapping(value = {"fileshome"})
	@ResponseBody
	public List<Files> filesrest(HttpServletRequest request, String errors) {
	//	String nameSearch = file.getName();
	//	String catalogy = file.getCatalogy();

		System.out.println("nameSearch : "+nameSearch);
		System.out.println("catalogy : "+catalogy);
		if(!StringUtils.isEmpty(nameSearch)) {
			insertTableTrending(nameSearch);
		}
		if(StringUtils.isEmpty(nameSearch) && StringUtils.equals(catalogy, "Select catalogies")) {
			System.out.println("select findAll_where_Top100 ");
			return filesService.findAll_where_Top100();
		}
		else if(StringUtils.isEmpty(nameSearch) && StringUtils.isEmpty(catalogy)) {
			System.out.println("select findAll_where_Catalogy ");
			return filesService.findAll_where_Catalogy(catalogy);
		}else if(StringUtils.equals(catalogy, "Select catalogies")){
			System.out.println("select findAll_where_likeName");
			return filesService.findAll_where_likeName(nameSearch);
		}else {
			System.out.println("select findAll_where_likeNameAndInCatalogy");
			return filesService.findAll_where_likeNameAndInCatalogy(nameSearch, catalogy);
		}
	}
	
	@RequestMapping(value = "sitemap.xml", method = RequestMethod.GET)
	@ResponseBody public FileSystemResource getFile(HttpServletResponse response) {
	    response.setContentType("application/xml");
	  
	    return new FileSystemResource(new File("sitemap.xml")); //Or path to your file 
	}
	

	@RequestMapping("/filestrending")
	public @ResponseBody List<Files> trendingRest() {
		List<Files> arrayFiles = new ArrayList<Files>();
		//Get Top 3 Trending
		List<Trending> arrayTrending = new ArrayList<Trending>();
		arrayTrending = trendingService.findTop10Trending();
		for (Trending trending : arrayTrending) {
			List<Files> arrayFile = new ArrayList<Files>();
			arrayFile = filesService.findAll_where_likeName(trending.getNameSearch());
			arrayFiles.addAll(arrayFile);
		}
		return arrayFiles;
	}
	
	@RequestMapping("/filestopdownload")
	public @ResponseBody List<Files> topdownloadsRest() {
		List<Files> arrayFiles = new ArrayList<Files>();
		arrayFiles = filesService.findAll_where_Top100();
		return arrayFiles;
	}
	
	public void insertTableTrending(String nameSearch) {
		Trending trending = trendingService.findOne_where_Name(nameSearch);
		
		if(trending != null) {//Exist in Table Trending
			trending.setDateSearch(new Date());
			 trending.setNumberSearch(trending.getNumberSearch()+1);
			 trendingService.insert(trending);
		}else {
			trending = new Trending(nameSearch, 1, new Date());
			trendingService.insert(trending);
		}

	}

}
