package com.springdatabase.basics.databasedemo.restcontroller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springdatabase.basics.databasedemo.controller.Utils;
import com.springdatabase.basics.databasedemo.entity.AdParameters;
import com.springdatabase.basics.databasedemo.entity.Ads;
import com.springdatabase.basics.databasedemo.entity.ChoTot;
import com.springdatabase.basics.databasedemo.entity.Files;
import com.springdatabase.basics.databasedemo.entity.NhaDat;
import com.springdatabase.basics.databasedemo.entity.NhaDatAll;
import com.springdatabase.basics.databasedemo.entity.SDTCO;
import com.springdatabase.basics.databasedemo.entity.TanSuat;
import com.springdatabase.basics.databasedemo.entity.Trending;
import com.springdatabase.basics.databasedemo.service.FilesService;
import com.springdatabase.basics.databasedemo.service.NhaDatAllService;
import com.springdatabase.basics.databasedemo.service.NhaDatService;
import com.springdatabase.basics.databasedemo.service.SDTCOService;
import com.springdatabase.basics.databasedemo.service.TanSuatService;
import com.springdatabase.basics.databasedemo.service.TrendingService;


@RestController
public class NhatDatRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	FilesService filesService;
	@Autowired
	TrendingService trendingService;
	public static String tinhthanhpho;
	public static String quanhuyen;
	public static String chuyenmuc;
	public static String tutimkiem;

	@Autowired
	NhaDatService nhaDatService;
	@Autowired
	NhaDatAllService nhaDatAllService;
	@Autowired
	SDTCOService sdtCOService;
	@Autowired
	TanSuatService tanSuatService;

	@GetMapping(value = { "fileshome" })
	@ResponseBody

	public List<NhaDat> filesrest(HttpServletRequest request, String errors) {

		// getDataFromJsonChoTot();
		// Read from db
		if(StringUtils.equals(tinhthanhpho, "Toàn quốc") && StringUtils.equals(quanhuyen, "Chọn quận huyện ...")
				&& StringUtils.equals(chuyenmuc, "Chọn chuyên mục ...") && StringUtils.isBlank(tutimkiem)) {
			//Find All 100 Top new 
			return nhaDatService.findAll_where_Top100();
		}
		return nhaDatService.findAll_where_Top100();

	}

	// @Scheduled(cron = "*/65 * * * * *")
	/*
	 * public void calculateTanSuatMoiNgay() { // Dem so lan xuat hien cua sdt
	 * List<NhaDatAll> listNhaDatAll = nhaDatAllService.findAll(); List<String>
	 * listPhone = new ArrayList<String>(); for (NhaDatAll nda : listNhaDatAll)
	 * listPhone.add(nda.getPhone()); if (listPhone.size() > 0) { Map<String,
	 * Integer> result = new HashMap<>(); for(String unique : new
	 * HashSet<>(listPhone)) { result.put(unique, Collections.frequency(listPhone,
	 * unique)); }
	 * 
	 * System.out.println("calculateTanSuatMoiNgay" + result); } //Save to db
	 * TanSuat TanSuat ts = new TanSuat(); for (String str : listPhone) {
	 * ts.setPhone(str.split("=")[0]);
	 * ts.setSoLanDangBai(Integer.valueOf(str.split("=")[1])); //
	 * ts.setSoLanNgayDangBai();
	 * 
	 * } // Calendar calendar2 = Calendar.getInstance(); //
	 * calendar2.setTimeInMillis(1576824300017); // System.out.println(calendar2);
	 * // System.out.println(calendar2.getTime()); // // Calendar rightNow =
	 * Calendar.getInstance(); // long integerRepresentation =
	 * rightNow.getTimeInMillis(); // System.out.println(integerRepresentation);
	 * 
	 * 
	 * }
	 */

	// Data input à table sdt cò à nhà đất : mỗi phút
	// GET data from JSON CHO TOT
	@Scheduled(cron = "*/60 * * * * *")
	public void getDataFromJsonChoTot() {
		RestTemplate restTemplate = new RestTemplate();
		// Get list
		ChoTot chotot = restTemplate.getForObject("https://gateway.chotot.com/v1/public/ad-listing?cg=1000&limit=30",
				ChoTot.class);
		// Get element of list
		for (int i = 0; i < chotot.getAds().size(); i++) {
			AdParameters adParameter = restTemplate.getForObject(
					"https://gateway.chotot.com/v1/public/ad-listing/" + chotot.getAds().get(i).getList_id(),
					AdParameters.class);
			com.springdatabase.basics.databasedemo.controller.Utils.convertString2Date(adParameter.getAd().getList_time());
			 //END
			// So sanh table SDTCO va save to table NhaDat
			compareWithTableSDTCO_and_insertTableNhaDat(chotot.getAds().get(i), adParameter);
			// Data input à nhà đất all : mỗi phút (kiểm tra có tồn tại hay không mới lưu)
			compareWithTableNhaDatAll_and_insertTableNhaDatAll(chotot.getAds().get(i), adParameter);

		}
	}

	private void compareWithTableTanSuat_and_insertTableTanSuat(Ads chototAds, AdParameters adParameter) {
		// compareWithTableSDTCO and insertTableNhaDat
		if (!tanSuatService.findOne_where_Phone(adParameter.getAd().getPhone())) {
			// Neu chua co thi them moi
			// Save db
			TanSuat nd = new TanSuat();
			nd.setPhone(adParameter.getAd().getPhone());
			nd.setSoLanDangBai(1);
			nd.setFirstDate(adParameter.getAd().getList_time());
			nd.setLastDate("");
			nd.setSoNgay(1);
			nd.setTanSuat(nd.getSoLanDangBai() / nd.getSoNgay());

			tanSuatService.insert(nd);
		} else {
			TanSuat nd = tanSuatService.getOne_where_Phone(adParameter.getAd().getPhone());
			nd.setSoLanDangBai(nd.getSoLanDangBai() + 1);
			nd.setLastDate(adParameter.getAd().getList_time());
			nd.setSoNgay(nd.getSoNgay() + 1);//??
			
			tanSuatService.insert(nd);
		}

		// System.out.println("Save to NhaDatAll success");

	}

	// Kiem tra co ton tai trong db chua ==> them vao
	public void compareWithTableSDTCO_and_insertTableNhaDat(Ads chototAds, AdParameters adParameter) {
		// compareWithTableSDTCO and insertTableNhaDat
		if (!sdtCOService.findOneWithPhone(adParameter.getAd().getPhone())) {// Not Exist in Table NhaDat
			// Save db
			NhaDat nd = new NhaDat();
			nd.setListId(chototAds.getList_id());
			nd.setSubject(chototAds.getSubject());
			nd.setDateUpload(chototAds.getDate());
			nd.setAccountName(chototAds.getAccount_name());
			nd.setBody(chototAds.getBody());
			nd.setAddress(adParameter.getAd().getAddress());
			nd.setWardName(chototAds.getWard_name());
			nd.setAreaName(chototAds.getArea_name());
			nd.setRegion(chototAds.getRegion());
			nd.setRegionName(chototAds.getRegion_name());
			nd.setPrice(chototAds.getPrice());
			nd.setPriceString(chototAds.getPrice_string());
			nd.setRooms(chototAds.getRooms());
			nd.setCategoryname(adParameter.getAd().getCategory_name());
			nd.setPhone(adParameter.getAd().getPhone());
			nd.setTypeName(adParameter.getAd().getType_name());
			nd.setOwner(adParameter.getAd().isOwner());
			nd.setListTime(chototAds.getList_time());
			nd.setDateUploadConvert(Utils.convertString2Date(chototAds.getList_time()));
			nhaDatService.insert(nd);
			// System.out.println("Save to NhaDat success");
		} else {
			System.out.println("Save to NhaDat not success");
			System.out.println("sdtCOService.findOneWithPhone(adParameter.getAd().getPhone())"
					+ sdtCOService.findOneWithPhone(adParameter.getAd().getPhone()));
		}
	}

	// Kiem tra co ton tai trong db chua ==> them vao
	public void compareWithTableNhaDatAll_and_insertTableNhaDatAll(Ads chototAds, AdParameters adParameter) {
		// compareWithTableSDTCO and insertTableNhaDat
		if (!nhaDatAllService.findOne_where_ListID(chototAds.getList_id())) {// Not Exist in Table NhaDat
			// Save db
			NhaDatAll nd = new NhaDatAll();
			nd.setListId(chototAds.getList_id());
			nd.setSubject(chototAds.getSubject());
			nd.setDateUpload(chototAds.getDate());
			nd.setAccountName(chototAds.getAccount_name());
			nd.setBody(chototAds.getBody());
			nd.setAddress(adParameter.getAd().getAddress());
			nd.setWardName(chototAds.getWard_name());
			nd.setAreaName(chototAds.getArea_name());
			nd.setRegion(chototAds.getRegion());
			nd.setRegionName(chototAds.getRegion_name());
			nd.setPrice(chototAds.getPrice());
			nd.setPriceString(chototAds.getPrice_string());
			nd.setRooms(chototAds.getRooms());
			nd.setCategoryname(adParameter.getAd().getCategory_name());
			nd.setPhone(adParameter.getAd().getPhone());
			nd.setTypeName(adParameter.getAd().getType_name());
			nd.setOwner(adParameter.getAd().isOwner());
			nd.setListTime(chototAds.getList_time());
			nd.setDateUploadConvert(Utils.convertString2Date(chototAds.getList_time()));
			nhaDatAllService.insert(nd);
			// System.out.println("Save to NhaDatAll success");

			// Data input à tần suất cò : đếm số lần xuất hiện trong tuần và tính ra tần
			// suất. Mỗi ngày.
			compareWithTableTanSuat_and_insertTableTanSuat(chototAds, adParameter);

		} else {
			System.out.println("Save to NhaDatAll not success");
			System.out.println("nhaDatAllService.findOne_where_ListID(adParameter.getAd().getPhone())"
					+ nhaDatAllService.findOne_where_ListID(adParameter.getAd().getPhone()));
		}
	}

	// Old
	@RequestMapping("/filestrending")
	public @ResponseBody List<Files> trendingRest() {
		List<Files> arrayFiles = new ArrayList<Files>();
		// Get Top 3 Trending
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

}
