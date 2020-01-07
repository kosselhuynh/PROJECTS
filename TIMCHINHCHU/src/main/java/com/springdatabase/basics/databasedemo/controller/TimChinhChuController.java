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
import com.springdatabase.basics.databasedemo.entity.TanSuat;
import com.springdatabase.basics.databasedemo.entity.User;
import com.springdatabase.basics.databasedemo.restcontroller.NhatDatRestController;
import com.springdatabase.basics.databasedemo.service.FilesService;
import com.springdatabase.basics.databasedemo.service.NhaDatService;
import com.springdatabase.basics.databasedemo.service.SDTCOService;
import com.springdatabase.basics.databasedemo.service.TanSuatService;
import com.springdatabase.basics.databasedemo.service.TrendingService;
import com.springdatabase.basics.databasedemo.service.UserService;

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
	TanSuatService tanSuatService;
	@Autowired
	UserService userService;
	@Autowired
	NhaDatService nhadatService;
	public static Map<Integer,String> tinhTP = new LinkedHashMap<Integer,String>();

	@RequestMapping(value = {"","/","index"})
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("tongsotin", nhadatService.count_All());
		model.addAttribute("sotinhochiminh", nhadatService.count_Where_RegionName("Tp Hồ Chí Minh"));
		model.addAttribute("sotinhanoi", nhadatService.count_Where_RegionName("Hà Nội"));
		model.addAttribute("sotindanang", nhadatService.count_Where_RegionName("Đà Nẵng"));

		return "index";
	}
	
	@RequestMapping(value = {"danhsachtin_hochiminh"})
	public String danhsachtin_hochiminh(Model model, HttpServletRequest request) {
		nhaDatRestController.tinhthanhpho = Utils.tphochiminh;
		List<NhaDat> arrayNhaDat = new ArrayList<NhaDat>();
		arrayNhaDat = nhadatService.findAll_With_RegionName(Utils.tphochiminh);
		//Loai nha dat gom 4 loai : Can mua, can ban, can thue, cho thue
		List<NhaDat> arrayNhatDat_CanBan = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_CanMua = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_ChoThue = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_CanThue = new ArrayList<NhaDat>();
		for (NhaDat nhaDat : arrayNhaDat) {
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần bán")){
				arrayNhatDat_CanBan.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần mua")){
				arrayNhatDat_CanMua.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cho thuê")){
				arrayNhatDat_ChoThue.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần thuê")){
				arrayNhatDat_CanThue.add(nhaDat);
			}
		}
		model.addAttribute("arrayNhatDat_CanBan", Utils.createLoaiNhaDat_CanBan(arrayNhatDat_CanBan));
		model.addAttribute("arrayNhatDat_CanMua", Utils.createLoaiNhaDat_CanMua(arrayNhatDat_CanMua));
		model.addAttribute("arrayNhatDat_ChoThue", Utils.createLoaiNhaDat_ChoThue(arrayNhatDat_ChoThue));
		model.addAttribute("arrayNhatDat_CanThue", Utils.createLoaiNhaDat_CanThue(arrayNhatDat_CanThue));
		Utils.createtinhTP(tinhTP);
		model.addAttribute("tinhTP", tinhTP);
		model.addAttribute("regionName", Utils.tphochiminh);
		model.addAttribute("listAreaName", Utils.createQuanHuyenTPHCM());
		model.addAttribute("quanhuyen", "Chọn quận huyện ...");
		model.addAttribute("loai", "Chọn loại ...");
		return "danhsachtin";
	}
	
	@RequestMapping(value = {"danhsachtin_hanoi"})
	public String danhsachtin_hanoi(Model model, HttpServletRequest request) {
		nhaDatRestController.tinhthanhpho = Utils.tphanoi;
		List<NhaDat> arrayNhaDat = new ArrayList<NhaDat>();
		arrayNhaDat = nhadatService.findAll_With_RegionName(Utils.tphanoi);
		//Loai nha dat gom 4 loai : Can mua, can ban, can thue, cho thue
		List<NhaDat> arrayNhatDat_CanBan = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_CanMua = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_ChoThue = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_CanThue = new ArrayList<NhaDat>();
		for (NhaDat nhaDat : arrayNhaDat) {
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần bán")){
				arrayNhatDat_CanBan.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần mua")){
				arrayNhatDat_CanMua.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cho thuê")){
				arrayNhatDat_ChoThue.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần thuê")){
				arrayNhatDat_CanThue.add(nhaDat);
			}
		}
		model.addAttribute("arrayNhatDat_CanBan", Utils.createLoaiNhaDat_CanBan(arrayNhatDat_CanBan));
		model.addAttribute("arrayNhatDat_CanMua", Utils.createLoaiNhaDat_CanMua(arrayNhatDat_CanMua));
		model.addAttribute("arrayNhatDat_ChoThue", Utils.createLoaiNhaDat_ChoThue(arrayNhatDat_ChoThue));
		model.addAttribute("arrayNhatDat_CanThue", Utils.createLoaiNhaDat_CanThue(arrayNhatDat_CanThue));
		Utils.createtinhTP(tinhTP);
		model.addAttribute("tinhTP", tinhTP);
		model.addAttribute("regionName", Utils.tphanoi);
		model.addAttribute("listAreaName", Utils.createWardName(arrayNhaDat));//Quan Huyen
		model.addAttribute("quanhuyen", "Chọn quận huyện ...");//Chọn loại ...
		model.addAttribute("loai", "Chọn loại ...");
		return "danhsachtin";
	}
	
	@RequestMapping(value = {"files"})
	public String persons(Model model, HttpServletRequest request) {
		Utils.createtinhTP(tinhTP);
		
		model.addAttribute("tinhTP", tinhTP);
		model.addAttribute("tongsotin", nhadatService.findAll().size());
		
		return "timchinhchu";
	}

	@GetMapping("{i}")
	public String catalogy(@PathVariable("i") int i, Model model, HttpServletRequest request) {//regionName
		if(i < 100) {
			List<NhaDat> arrayNhaDat = new ArrayList<NhaDat>();
			arrayNhaDat = nhadatService.findAll_With_RegionName(tinhTP.get(i));
			
			NhaDat nd = nhadatService.findOne_where_ID(i);
			model.addAttribute("quanhuyen", "Chọn quận huyện ...");
			model.addAttribute("loai", "Chọn loại ...");
	//		User user = new User();
	//		userService.updateUser(user );
			//Loai nha dat gom 4 loai : Can mua, can ban, can thue, cho thue
			List<NhaDat> arrayNhatDat_CanBan = new ArrayList<NhaDat>();
			List<NhaDat> arrayNhatDat_CanMua = new ArrayList<NhaDat>();
			List<NhaDat> arrayNhatDat_ChoThue = new ArrayList<NhaDat>();
			List<NhaDat> arrayNhatDat_CanThue = new ArrayList<NhaDat>();
			for (NhaDat nhaDat : arrayNhaDat) {
				if(StringUtils.equals(nhaDat.getTypeName(), "Cần bán")){
					arrayNhatDat_CanBan.add(nhaDat);
				}
				if(StringUtils.equals(nhaDat.getTypeName(), "Cần mua")){
					arrayNhatDat_CanMua.add(nhaDat);
				}
				if(StringUtils.equals(nhaDat.getTypeName(), "Cho thuê")){
					arrayNhatDat_ChoThue.add(nhaDat);
				}
				if(StringUtils.equals(nhaDat.getTypeName(), "Cần thuê")){
					arrayNhatDat_CanThue.add(nhaDat);
				}
			}
			model.addAttribute("arrayNhatDat_CanBan", Utils.createLoaiNhaDat_CanBan(arrayNhatDat_CanBan));
			model.addAttribute("arrayNhatDat_CanMua", Utils.createLoaiNhaDat_CanMua(arrayNhatDat_CanMua));
			model.addAttribute("arrayNhatDat_ChoThue", Utils.createLoaiNhaDat_ChoThue(arrayNhatDat_ChoThue));
			model.addAttribute("arrayNhatDat_CanThue", Utils.createLoaiNhaDat_CanThue(arrayNhatDat_CanThue));
			
			model.addAttribute("listTypeName", Utils.createTypeName(arrayNhaDat));//Can mua, Can ban
			model.addAttribute("listCatalogyName", Utils.createCatalogyName(arrayNhaDat));//Chuyen muc (Nha o, chung cu,...)
			model.addAttribute("listAreaName", Utils.createWardName(arrayNhaDat));//Quan Huyen
			model.addAttribute("tinhTP", tinhTP);//Tinh TP
			
		}else {
			SDTCO sdtCo = new SDTCO();
			sdtCo.setPhone("0" + String.valueOf(i));
			sdtCo.setPhanTram(100);
			sdtCOService.insert(sdtCo );
		}
		model.addAttribute("khuvuc", tinhTP.get(i));
		model.addAttribute("tongsotin", nhadatService.count_All());
		return "danhsachtin";
		
	}
	
	
	
	
	@GetMapping("actionFormSearch")
	public String formSearch(@RequestParam("tinhthanhpho") String tinhthanhpho, @RequestParam("quanhuyen") String quanhuyen, 
			 @RequestParam("tutimkiem") String tutimkiem, @RequestParam("loai") String loai,
			Model model) {
		nhaDatRestController.tinhthanhpho = StringUtils.trim(tinhthanhpho);
		nhaDatRestController.quanhuyen = StringUtils.trim(quanhuyen);
		nhaDatRestController.loai = StringUtils.trim(loai);
		nhaDatRestController.tutimkiem = StringUtils.trim(tutimkiem.toLowerCase());
		
		List<NhaDat> arrayNhaDat = new ArrayList<NhaDat>();
		arrayNhaDat = nhadatService.findAll_With_RegionName(tinhthanhpho);
		//Loai nha dat gom 4 loai : Can mua, can ban, can thue, cho thue
		List<NhaDat> arrayNhatDat_CanBan = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_CanMua = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_ChoThue = new ArrayList<NhaDat>();
		List<NhaDat> arrayNhatDat_CanThue = new ArrayList<NhaDat>();
		for (NhaDat nhaDat : arrayNhaDat) {
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần bán")){
				arrayNhatDat_CanBan.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần mua")){
				arrayNhatDat_CanMua.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cho thuê")){
				arrayNhatDat_ChoThue.add(nhaDat);
			}
			if(StringUtils.equals(nhaDat.getTypeName(), "Cần thuê")){
				arrayNhatDat_CanThue.add(nhaDat);
			}
		}
		model.addAttribute("arrayNhatDat_CanBan", Utils.createLoaiNhaDat_CanBan(arrayNhatDat_CanBan));
		model.addAttribute("arrayNhatDat_CanMua", Utils.createLoaiNhaDat_CanMua(arrayNhatDat_CanMua));
		model.addAttribute("arrayNhatDat_ChoThue", Utils.createLoaiNhaDat_ChoThue(arrayNhatDat_ChoThue));
		model.addAttribute("arrayNhatDat_CanThue", Utils.createLoaiNhaDat_CanThue(arrayNhatDat_CanThue));
		
		model.addAttribute("regionName", tinhthanhpho);
		model.addAttribute("listAreaName", Utils.createWardName(arrayNhaDat));//Quan Huyen
		
		Utils.createtinhTP(tinhTP);
		model.addAttribute("tinhTP", tinhTP);
		model.addAttribute("tongsotin", nhadatService.count_All());//quanhuyen
		model.addAttribute("quanhuyen", quanhuyen);
		model.addAttribute("loai", loai);
		return "danhsachtin";
	}
	
	@GetMapping("profile")
	public String userProfile() {
		
		return "profile";
	}
	
	
	@RequestMapping(value = "backupsdtco", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> backupsdtco(HttpServletRequest request) throws IOException{
		HttpHeaders responseHeader = new HttpHeaders();
	    try {
	      File file = ResourceUtils.getFile("classpath:file/sdtco.txt");
	      List<SDTCO> sdtCO = sdtCOService.findAll();
	      FileWriter fw = new FileWriter(file);
	      for (SDTCO sdt : sdtCO) {
	    	  fw.write("insert into SDT_CO (phone, phan_tram) values ('" + sdt.getPhone() + "'," + sdt.getPhanTram() +  ");" + "\n");
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
		
	@RequestMapping(value = "backuptansuat", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> backuptansuat(HttpServletRequest request) throws IOException{
		HttpHeaders responseHeader = new HttpHeaders();
	    try {
		      File file = ResourceUtils.getFile("classpath:file/tansuat.txt");
		      List<TanSuat> tanSuat = tanSuatService.findAll();
		      FileWriter fw = new FileWriter(file);
		      for (TanSuat ts : tanSuat) {
		    	  fw.write("insert into TAN_SUAT (phone, first_date, last_date, so_lan_dang_bai, so_ngay, tan_suat) values ('" +
		      ts.getPhone() + "','" + ts.getFirstDate() + "','" + ts.getLastDate() + "'," + 
		    			  ts.getSoLanDangBai() + "," + ts.getSoNgay() + "," + ts.getTanSuat() +  ");" + "\n");
		      }
		      fw.close();
		      byte[] data = FileUtils.readFileToByteArray(file);
		      // Set mimeType trả về
		      responseHeader.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		      // Thiết lập thông tin trả về
		      responseHeader.set("Content-disposition", "attachment; filename=" + file.getName());
		      responseHeader.setContentLength(data.length);
		      InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
		      InputStreamResource inputStreamResource1 = new InputStreamResource(inputStream);
		      return new ResponseEntity<InputStreamResource>(inputStreamResource1, responseHeader, HttpStatus.OK);
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

	

	@RequestMapping("userdashboard")
	public String contact(Model model) {
	//	Contact contact = new Contact();
	//	model.addAttribute("contact", contact);
		return "userdashboard";
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
