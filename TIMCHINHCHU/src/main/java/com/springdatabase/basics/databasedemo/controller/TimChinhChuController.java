package com.springdatabase.basics.databasedemo.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
			model.addAttribute("listTypeName", Utils.createTypeName(arrayNhaDat));
			model.addAttribute("listCatalogyName", Utils.createCatalogyName(arrayNhaDat));
			model.addAttribute("listAreaName", Utils.createWardName(arrayNhaDat));
			model.addAttribute("tinhTP", tinhTP);
			
		}else {
			SDTCO sdtCo = new SDTCO();
			sdtCo.setPhone("0" + String.valueOf(i));
			sdtCo.setPhanTram(100);
			sdtCOService.insert(sdtCo );
		//	return "redirect:timchinhchu";
		}
		model.addAttribute("khuvuc", tinhTP.get(i));
		return "timchinhchu";
		
	}
	
	
	
	
	@GetMapping("actionFormSearch")
	public String formSearch(@RequestParam("tinhthanhpho") String tinhthanhpho, @RequestParam("quanhuyen") String quanhuyen, 
			@RequestParam("chuyenmuc") String chuyenmuc, @RequestParam("tutimkiem") String tutimkiem, @RequestParam("loai") String loai,
			Model model) {
		nhaDatRestController.tinhthanhpho = StringUtils.trim(tinhthanhpho);
		nhaDatRestController.quanhuyen = StringUtils.trim(quanhuyen);
		nhaDatRestController.chuyenmuc = StringUtils.trim(chuyenmuc);
		nhaDatRestController.loai = StringUtils.trim(loai);
		nhaDatRestController.tutimkiem = StringUtils.trim(tutimkiem.toLowerCase());
		
		Utils.createtinhTP(tinhTP);
		model.addAttribute("tinhTP", tinhTP);
		return "timchinhchu";
	}
	

	
	@RequestMapping(value = "backupdb", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> backupdb(HttpServletRequest request) throws IOException{
		HttpHeaders responseHeader = new HttpHeaders();
	    try {
	      File file = ResourceUtils.getFile("classpath:file/sdtco.txt");
	//      FileWriter fw = new FileWriter(file);
	     
	     List<SDTCO> sdtCO = sdtCOService.findAll();
	     FileWriter fw = new FileWriter(file);
	      for (SDTCO sdt : sdtCO) {
	    	  fw.write("insert into SDT_CO (phone, phan_tram) values ('" + sdt.getPhone() + "'," + sdt.getPhanTram() +  ")" + "\n");
	      }
	      fw.close();
	      byte[] data = FileUtils.readFileToByteArray(file);
	      // Set mimeType trả về
	      responseHeader.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	      // Thiết lập thông tin trả về
	      responseHeader.set("Content-disposition", "attachment; filename=" + file.getName());
	      responseHeader.setContentLength(data.length);
	      InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
	      InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
	      return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeader, HttpStatus.OK);
	    } catch (Exception ex) {
	      return new ResponseEntity<InputStreamResource>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
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
	

	@GetMapping("trending")
	public String trending() {
		return "trending";
	}

	
}
