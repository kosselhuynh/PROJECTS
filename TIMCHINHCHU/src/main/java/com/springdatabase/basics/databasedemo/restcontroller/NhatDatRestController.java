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
	public static String loai;
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
		List<NhaDat> listSortNhaDat = new ArrayList<>();
		// getDataFromJsonChoTot();
		// Read from db
		
		//TAM BO VI NANG WEB
		if (StringUtils.equals(tinhthanhpho, "Toàn quốc") && StringUtils.equals(quanhuyen, "Chọn quận huyện ...")
				&& StringUtils.equals(loai, "Chọn loại ...") && StringUtils.isBlank(tutimkiem)) {
			// Find All 100 Top new
			listSortNhaDat = nhaDatService.findAll_where_Top100();
		//	return listSortNhaDat;
		}
		if (!StringUtils.equals(tinhthanhpho, "Toàn quốc") 
				&& (StringUtils.equals(quanhuyen, "Chọn quận huyện ...") || StringUtils.isBlank(quanhuyen))
				&& (StringUtils.equals(loai, "Chọn loại ...") || StringUtils.isBlank(loai))
				&& (StringUtils.isBlank(tutimkiem) || StringUtils.isBlank(tutimkiem))) {
			// Find All 100 Top new where region_name = tinhthanhpho
			listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionName(tinhthanhpho);
		//	return listSortNhaDat;
		}
		if (!StringUtils.equals(tinhthanhpho, "Toàn quốc") && !StringUtils.equals(quanhuyen, "Chọn quận huyện ...")
				&& StringUtils.equals(loai, "Chọn loại ...") && StringUtils.isBlank(tutimkiem)) {
			// Find All 100 Top new where region_name = tinhthanhpho and area_name =
			// quanhuyen
			listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionNameAreaName(tinhthanhpho, quanhuyen);
		//	return listSortNhaDat;
		}
		if (!StringUtils.equals(tinhthanhpho, "Toàn quốc") && !StringUtils.equals(quanhuyen, "Chọn quận huyện ...")
				&& !StringUtils.equals(loai, "Chọn loại ...") && StringUtils.isBlank(tutimkiem)) {
			// Find All 100 Top new where region_name = tinhthanhpho and area_name =
			// quanhuyen and TypeName = chuyenmuc
			//Xu ly loai
			try {
			String[] mString = loai.split("-");
			if(mString.length > 2) {//Co 3 phan tu
				String type = mString[0];
				String cata = mString[1];
				String road = mString[2];
				listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeNamePROPERTY_ROAD_CONDITION(tinhthanhpho,
						quanhuyen, cata, type, road);
			//	return listSortNhaDat;
			}else {
				String type = mString[0];
				String cata = mString[1];
				listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeName(tinhthanhpho,
						quanhuyen, cata, type);
			//	return listSortNhaDat;
			}
			}catch(Exception ex) {
				
			}
		}
		
		if (!StringUtils.equals(tinhthanhpho, "Toàn quốc") && !StringUtils.equals(quanhuyen, "Chọn quận huyện ...")
				&& !StringUtils.equals(loai, "Chọn loại ...") && !StringUtils.isBlank(tutimkiem)) {
			// Find All 100 Top new where region_name = tinhthanhpho and area_name =
			// quanhuyen and TypeName = chuyenmuc
			try {
				String[] mString = loai.split("-");
				if(mString.length > 2) {//Co 3 phan tu
					String type = mString[0];
					String cata = mString[1];
					String road = mString[2];
					listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeNamePROPERTY_ROAD_CONDITIONTuTimKiem(tinhthanhpho,
							quanhuyen, cata, type, road, tutimkiem);
			//		return listSortNhaDat;
				}else {
					String type = mString[0];
					String cata = mString[1];
					listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeNameTuTimKiem(tinhthanhpho,
							quanhuyen, cata, type, tutimkiem);
			//		return listSortNhaDat;
				}
				}catch(Exception ex) {
					
				}
			

		//	return listSortNhaDat;
		} 
		if (!StringUtils.equals(tinhthanhpho, "Toàn quốc") && StringUtils.equals(quanhuyen, "Chọn quận huyện ...")
				&& !StringUtils.equals(loai, "Chọn loại ...") && StringUtils.isBlank(tutimkiem)) {
			// Find All 100 Top new where region_name = tinhthanhpho and area_name =
			// quanhuyen and TypeName = chuyenmuc
			try {
				String[] mString = loai.split("-");
				if(mString.length > 2) {//Co 3 phan tu
					String type = mString[0];
					String cata = mString[1];
					String road = mString[2];
					listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionNameCatalogyNameTypeNamePROPERTY_ROAD_CONDITION(tinhthanhpho,
							cata, type, road);
			//		return listSortNhaDat;
				}else {
					String type = mString[0];
					String cata = mString[1];
					listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionNameCatalogyNameTypeName(tinhthanhpho,
							cata, type);
			//		return listSortNhaDat;
				}
				}catch(Exception ex) {
					
				}
			listSortNhaDat = nhaDatService.findAll_where_Top100_With_RegionNameAreaNameCatalogyNameTypeNameTuTimKiem(
					tinhthanhpho, quanhuyen, chuyenmuc, loai, tutimkiem);
			
		//	return listSortNhaDat;
		} 
		else if (!StringUtils.isBlank(tutimkiem)) {
			// Find All 100 Top new where region_name = tinhthanhpho and area_name =
			// quanhuyen and TypeName = chuyenmuc
			
			listSortNhaDat = nhaDatService.findAll_where_Top100_With_TuTimKiem(tutimkiem);
			
		//	return listSortNhaDat;
		}
		for (NhaDat nhaDat : listSortNhaDat) {
			TanSuat tansuat = tanSuatService.getOne_where_Phone(nhaDat.getPhone());
			nhaDat.setSobaidang(tansuat.getSoLanDangBai());
			nhaDat.setSongay(tansuat.getSoNgay());
		}
		return listSortNhaDat;

	}

	@Scheduled(cron = "*/600 * * * * *")
	public void calAVG_TanSuat_ofSDTCO() {
		logger.info("=== START calAVG_TanSuat_ofSDTCO() ==== ");
		// SDT dang qua 10 bai / ngay, SDT nam trong bang TAN SUAT
		List<TanSuat> listSDT_more10Post_inTanSuat = tanSuatService.findAll_Where_more10Post();
		logger.info("listSDT_more10Post_inTanSuat.size() :" + listSDT_more10Post_inTanSuat.size());
		// Them vao bang SDTCO
		List<SDTCO> listSDTCO10Post = new ArrayList<>();
		if(listSDT_more10Post_inTanSuat.size() > 0) {
			for (TanSuat tanSuat : listSDT_more10Post_inTanSuat) {
				logger.info("SDT co tan suat dang bai > 10 post : " + tanSuat.getPhone() + " tan suat = "
						+ tanSuat.getTanSuat());
				SDTCO sdtco = new SDTCO();
				sdtco.setPhone(tanSuat.getPhone());
				sdtco.setPhanTram((int)tanSuat.getTanSuat());
				listSDTCO10Post.add(sdtco);
			}
		}
		
		if (listSDTCO10Post.size() > 0) {
			sdtCOService.insert(listSDTCO10Post);
		}
		logger.info("Insert listSDTCO10Post into table SDTCO success voi so luong sdt la : " + listSDTCO10Post.size());
		// SDT nam trong bang SDTCO
		// get list
		List<SDTCO> listSDTCO_100Percent = sdtCOService.findAll();
		// So sanh voi bang Tan Suat va tinh ra trung binh tan suat
		List<TanSuat> listSDT_TanSuat = tanSuatService.findAll_Where_listSDTCO_100Percent(listSDTCO_100Percent);
		logger.info(
				"List<TanSuat> listSDT_TanSuat= tanSuatService.findAll_Where_listSDTCO_100Percent(listSDTCO_100Percent); : "
						+ listSDT_TanSuat.size());
		// Tinh trung binh
		double avgTanSuat = 0;
		if(listSDT_TanSuat.size() > 0 ) {
			avgTanSuat = Utils.calculateAVG(listSDT_TanSuat);
			logger.info("avgTanSuat : " + avgTanSuat);
		}
		
		// get list TAN SUAT co TanSuat > avgTanSuat
		List<TanSuat> listSDT_TanSuat_Bigger_AVGTanSuat = null;
		if(avgTanSuat > 10) {
			listSDT_TanSuat_Bigger_AVGTanSuat = tanSuatService
					.findAll_Where_TanSuat_Bigger_AVGTanSuat(avgTanSuat);
			logger.info("listSDT_TanSuat_Bigger_AVGTanSuat.size() : " + listSDT_TanSuat_Bigger_AVGTanSuat.size());
		}
		

		// Them listSDT_TanSuat_Bigger_AVGTanSuat vao bang SDTCO
		// Them vao bang SDTCO
		List<SDTCO> listSDT_Bigger_AVGTanSuat = new ArrayList<>();
		if(listSDT_TanSuat_Bigger_AVGTanSuat != null && listSDT_TanSuat_Bigger_AVGTanSuat.size() > 0) {
			for (TanSuat tanSuat : listSDT_TanSuat_Bigger_AVGTanSuat) {
				logger.info("SDT co tan suat dang bai listSDT_Bigger_AVGTanSuat : " + tanSuat.getPhone() + " tan suat = "
						+ tanSuat.getTanSuat());
				SDTCO sdtco = new SDTCO();
				sdtco.setPhone(tanSuat.getPhone());
				sdtco.setPhanTram((int)tanSuat.getTanSuat());
				listSDT_Bigger_AVGTanSuat.add(sdtco);
			}
		}
		
		if (listSDT_Bigger_AVGTanSuat.size() > 0) {
			sdtCOService.insert(listSDT_Bigger_AVGTanSuat);
		}
		logger.info("Insert listSDT_Bigger_AVGTanSuat into table SDTCO success voi so luong sdt la : " + listSDT_Bigger_AVGTanSuat.size());
		//Xoa cac tin trong bang NHA DAT co SDT trung voi bang SDTCO
		List<SDTCO> listSDTCO = sdtCOService.findAll();
		logger.info("listSDTCO chuan bi de xoa trong bang NHA DAT:" + listSDTCO.size());
		if(listSDTCO.size() > 0) {
			logger.info("So luong record Nha Dat ban dau " + nhaDatService.findAll().size());
			//xoa trong bang NHA DAT
			//Tim sdt co ton tai trong bang NHA DAT K, roi xoa
			for (SDTCO sdtco : listSDTCO) {
				if(nhaDatService.findOne_where_Phone(sdtco.getPhone())) {
					nhaDatService.deletePost_haveSDT_inTable_SDTCO(sdtco.getPhone());
					logger.info("-------- Deleted bai dang trong bang NHA DAT " + sdtco.getPhone() + "==========");
				}else {
					logger.info("Khong xoa duoc vi khong ton tai sdt nay :" + sdtco.getPhone()+ " trong bang NHA DAT");
				}
			}
		
			logger.info("So luong record Nha Dat sau khi xoa " + nhaDatService.findAll().size());
		}
		logger.info("=== END calAVG_TanSuat_ofSDTCO() ==== ");
		
	}

	// Data input à table sdt cò à nhà đất : mỗi phút
	// GET data from JSON CHO TOT
	@Scheduled(cron = "*/60 * * * * *")
	public void getDataFromJsonChoTot() {
		RestTemplate restTemplate = new RestTemplate();
		// Get list
		ChoTot chotot = restTemplate.getForObject("https://gateway.chotot.com/v1/public/ad-listing?cg=1000&limit=50&f=p",
				ChoTot.class);
		// Get element of list
		for (int i = 0; i < chotot.getAds().size(); i++) {
			AdParameters adParameter = restTemplate.getForObject(
					"https://gateway.chotot.com/v1/public/ad-listing/" + chotot.getAds().get(i).getList_id(),
					AdParameters.class);
			// Utils.convertString2Date(adParameter.getAd().getList_time());
			// END
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

			logger.info("Chua ton tai so dien thoai trong bang TAN SUAT ==> them moi");
			logger.info("tanSuatService.insert(nd); " + nd.getPhone());
		} else {
			TanSuat nd = tanSuatService.getOne_where_Phone(adParameter.getAd().getPhone());
			nd.setSoLanDangBai(nd.getSoLanDangBai() + 1);
			nd.setLastDate(adParameter.getAd().getList_time());
			logger.info(
					"date 2 - date 1 = " + Utils.calculateBetweenTwoDate(Utils.convertString2Date(nd.getFirstDate()),
							Utils.convertString2Date(adParameter.getAd().getList_time())));
			nd.setSoNgay((int) Utils.calculateBetweenTwoDate(Utils.convertString2Date(nd.getFirstDate()),
					Utils.convertString2Date(adParameter.getAd().getList_time())));// ??
			nd.setTanSuat(nd.getSoLanDangBai() / nd.getSoNgay());
			tanSuatService.insert(nd);

			logger.info("Da ton tai so dien thoai trong bang TAN SUAT ==> update");
			logger.info("Update tanSuatService.insert(nd); " + nd.getPhone());
		}

		// System.out.println("Save to NhaDatAll success");

	}

	// Kiem tra co ton tai trong db chua ==> them vao
	public void compareWithTableSDTCO_and_insertTableNhaDat(Ads chototAds, AdParameters adParameter) {
		// compareWithTableSDTCO and insertTableNhaDat

		if (!sdtCOService.findOneWithPhone(adParameter.getAd().getPhone()) && !nhaDatAllService.findOne_where_ListID(chototAds.getList_id())) {// Not Exist in Table NhaDat
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
			nd.setCatalogyName(adParameter.getAd().getCategory_name());
			nd.setPhone(adParameter.getAd().getPhone());
			nd.setTypeName(adParameter.getAd().getType_name());
			nd.setOwner(adParameter.getAd().isOwner());
			nd.setListTime(chototAds.getList_time());
			nd.setDateUploadConvert(Utils.convertString2Date(chototAds.getList_time()));
			nd.setSubjectLowerCase(chototAds.getSubject().toLowerCase());
			
			if(adParameter.getAd_params().getDirection() != null)
				nd.setDirection(adParameter.getAd_params().getDirection().getValue());
			else
				nd.setDirection("");
			
			if(adParameter.getAd_params().getProperty_legal_document() != null)
				nd.setPropertyLegalDocument(adParameter.getAd_params().getProperty_legal_document().getValue());
			else
				nd.setPropertyLegalDocument("");
			
			if(adParameter.getAd_params().getProperty_road_condition() != null)
				nd.setPropertyRoadCondition(adParameter.getAd_params().getProperty_road_condition().getValue());
			
			nhaDatService.insert(nd);
			logger.info(
					"So dien thoai chua ton tai trong bang NHA DAT ALL  ==> Kiem tra SDT de them vao bang TAN SUAT : "
							+ nd.getPhone());
			logger.info("So dien thoai chua ton tai trong bang SDTCO ==> Them moi");
			logger.info("sdtCOService.findOneWithPhone(adParameter.getAd().getPhone()) : " + false);
			logger.info("nhaDatService.insert(nd); : " + nd.getPhone());
		} else {
			logger.info("Da ton tai So dien thoai trong bang SDTCO ==> Khong them moi");
			logger.info("SDT ton tai la : " + adParameter.getAd().getPhone());
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
			nd.setCatalogyName(adParameter.getAd().getCategory_name());
			nd.setPhone(adParameter.getAd().getPhone());
			nd.setTypeName(adParameter.getAd().getType_name());
			nd.setOwner(adParameter.getAd().isOwner());
			nd.setListTime(chototAds.getList_time());
			nd.setDateUploadConvert(Utils.convertString2Date(chototAds.getList_time()));
			nd.setSubjectLowerCase(chototAds.getSubject().toLowerCase());
			if(adParameter.getAd_params().getDirection() != null)
				nd.setDirection(adParameter.getAd_params().getDirection().getValue());
			else
				nd.setDirection("");
			
			if(adParameter.getAd_params().getProperty_legal_document() != null)
				nd.setPropertyLegalDocument(adParameter.getAd_params().getProperty_legal_document().getValue());
			else
				nd.setPropertyLegalDocument("");
			if(adParameter.getAd_params().getProperty_road_condition() != null)
				nd.setPropertyRoadCondition(adParameter.getAd_params().getProperty_road_condition().getValue());
			
			nhaDatAllService.insert(nd);
			logger.info("List ID chua ton tai trong bang NHADAT_ALL ==> Them moi");
			logger.info("nhaDatAllService.findOne_where_ListID(chototAds.getList_id()) : " + false);
			logger.info("nhaDatAllService.insert(nd); " + nd.getPhone());
			// Data input à tần suất cò : đếm số lần xuất hiện trong tuần và tính ra tần
			// suất. Mỗi ngày.
			compareWithTableTanSuat_and_insertTableTanSuat(chototAds, adParameter);

		} else {
			logger.info("Da ton tai List ID trong bang NHADAT_ALL ==> Khong them moi");
			logger.info("List ID ton tai la : " + chototAds.getList_id());

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
