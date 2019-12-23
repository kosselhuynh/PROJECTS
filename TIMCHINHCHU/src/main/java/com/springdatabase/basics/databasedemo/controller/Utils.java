package com.springdatabase.basics.databasedemo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.springdatabase.basics.databasedemo.entity.NhaDat;

public class Utils {
 
	//Convert KB to MB, GB
	public static String convert2MB_GB(double size) {
		String sizeNew = null;
		if(size > 1024) {
			size = Math.round(size/1024);
			if(size > 1024) {
				size = Math.round(size/1024);
				if(size > 1024) {
					size = Math.round(size/1024);
					sizeNew = String.valueOf(size) + " GB"; 
				}else {
					sizeNew = String.valueOf(size) + " MB"; 
				}
			}else {
				sizeNew = String.valueOf(size) + " KB"; 
			}
		}else {
			sizeNew = String.valueOf(size) + " Byte"; 
		}
		return sizeNew;
		
	}

	////
	
	public static boolean checkExist(List<String> listString, String str){
		boolean rs = false;
		for (String string : listString) {
			if(StringUtils.equals(string, str)) {
				rs = true;
				break;
			}
		}
		return rs;
	}

	public static List<String> createWardName(List<NhaDat> arrayFiles){
		List<String> listAreaName = new ArrayList<String>();
		for (int i = 0; i < arrayFiles.size(); i++) {
			if(!Utils.checkExist(listAreaName, arrayFiles.get(i).getAreaName())) {
				listAreaName.add(arrayFiles.get(i).getAreaName());
			}
			
		}
		Collections.sort(listAreaName);
		return listAreaName;
	}
//Tao mang
	public static void createtinhTP(Map<Integer,String> tinhTP) {
		tinhTP.put(1, "Tp Hồ Chí Minh");
		tinhTP.put(2, "Hà Nội");
		tinhTP.put(3, "Đà Nẵng");
		
		tinhTP.put(4, "Cần Thơ");
		tinhTP.put(5, "Bình Dương");
		tinhTP.put(6, "An Giang");
		
		tinhTP.put(7, "Bà Rịa - Vũng Tàu");
		tinhTP.put(8, "Bắc Giang");
		tinhTP.put(9, "Bắc Kạn");
		
		tinhTP.put(10, "Bạc Liêu");
		tinhTP.put(11, "Bắc Ninh");
		tinhTP.put(12, "Bến Tre");
		
		tinhTP.put(13, "Bình Định");
		tinhTP.put(14, "Bình Phước");
		tinhTP.put(15, "Bình Thuận");
		
		tinhTP.put(16, "Cà Mau");
		tinhTP.put(17, "Cao Bằng");
		tinhTP.put(18, "Đắk Lắk");
		
		tinhTP.put(19, "Đắk Nông");
		tinhTP.put(20, "Điện Biên");
		tinhTP.put(21, "Đồng Nai");
		
		tinhTP.put(22, "Đồng Tháp");
		tinhTP.put(23, "Gia Lai");
		tinhTP.put(24, "Hà Giang");
		
		tinhTP.put(25, "Hà Nam");
		tinhTP.put(26, "Hà Tĩnh");
		tinhTP.put(27, "Hải Dương");
		
		tinhTP.put(28, "Hải Phòng");
		tinhTP.put(29, "Hậu Giang");
		tinhTP.put(30, "Hòa Bình");
		
		tinhTP.put(31, "Hưng Yên");
		tinhTP.put(32, "Khánh Hòa");
		tinhTP.put(33, "Kiên Giang");
		
		tinhTP.put(34, "Kon Tum");
		tinhTP.put(35, "Lai Châu");
		tinhTP.put(36, "Lâm Đồng");
		
		tinhTP.put(37, "Lạng Sơn");
		tinhTP.put(38, "Lào Cai");
		tinhTP.put(39, "Long An");
		
		tinhTP.put(40, "Nam Định");
		tinhTP.put(41, "Nghệ An");
		tinhTP.put(42, "Ninh Bình");
		
		tinhTP.put(43, "Ninh Thuận");
		tinhTP.put(44, "Phú Thọ");
		tinhTP.put(45, "Phú Yên");
		
		tinhTP.put(46, "Quảng Bình");
		tinhTP.put(47, "Quảng Nam");
		tinhTP.put(48, "Quảng Ngãi");
		
		tinhTP.put(49, "Quảng Ninh");
		tinhTP.put(50, "Quảng Trị");
		tinhTP.put(51, "Sóc Trăng");
		
		tinhTP.put(52, "Sơn La");
		tinhTP.put(53, "Tây Ninh");
		tinhTP.put(54, "Thái Bình");
		
		tinhTP.put(55, "Thái Nguyên");
		tinhTP.put(56, "Thanh Hóa");
		tinhTP.put(57, "Thừa Thiên Huế");
		
		tinhTP.put(58, "Tiền Giang");
		tinhTP.put(59, "Trà Vinh");
		tinhTP.put(60, "Tuyên Quang");
		
		tinhTP.put(61, "Vĩnh Long");
		tinhTP.put(62, "Vĩnh Phúc");
		tinhTP.put(63, "Yên Bái");
	}
	
}
