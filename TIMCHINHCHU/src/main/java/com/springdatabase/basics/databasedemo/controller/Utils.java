package com.springdatabase.basics.databasedemo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.springdatabase.basics.databasedemo.entity.NhaDat;
import com.springdatabase.basics.databasedemo.entity.TanSuat;

public class Utils {
	public static String tphochiminh = "Tp Hồ Chí Minh";//444
	public static String tphanoi = "Hà Nội";
	
	public static long calculateBetweenTwoDate(Date d1, Date d2) {
		long getDaysDiff = 0;
		long getDiff = 0;
		try {
			if(d2.after(d1)) {
				getDiff = d2.getTime() - d1.getTime();
			}else {
				getDiff = d1.getTime() - d2.getTime();
			}
			   // using TimeUnit class from java.util.concurrent package
			   getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);

			   System.out.println("Differance between date is " + getDaysDiff + " days.");
			  } catch (Exception e) {
			   e.printStackTrace();
			  }
		return getDaysDiff + 1;
			 
	}

	public static void sortByDate(List<NhaDat> listSortNhaDat) {
		Collections.sort(listSortNhaDat, new DateComparator());
	}
	public static class DateComparator implements Comparator<NhaDat> {
		public int compare(NhaDat s2, NhaDat s1) {
		//	return s2.getListTime().compareTo(s1.getListTime());
			return s1.getDateUploadConvert().compareTo(s2.getDateUploadConvert());
		}
	}
	//Convert String to Date from Json
	public static Date convertString2Date(String strTime) {
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTimeInMillis(Long.valueOf(strTime));
		 return calendar.getTime();
	}
	
	////
	public static boolean checkExist(List<String> listString, String str) {
		boolean rs = false;
		for (String string : listString) {
			if (StringUtils.equals(string, str)) {
				rs = true;
				break;
			}
		}
		return rs;
	}

	public static List<String> createWardName(List<NhaDat> arrayFiles) {
		List<String> listAreaName = new ArrayList<String>();
		for (int i = 0; i < arrayFiles.size(); i++) {
			if (!Utils.checkExist(listAreaName, arrayFiles.get(i).getAreaName())) {
				listAreaName.add(arrayFiles.get(i).getAreaName());
			}

		}
	//	Collections.sort(listAreaName);
		
		Collections.sort(listAreaName, new Comparator<String>() {
	        public int compare(String o1, String o2) {
	            return extractInt(o1) - extractInt(o2);
	        }

	        int extractInt(String s) {
	            String num = s.replaceAll("\\D", "");
	            // return 0 if no digits found
	            return num.isEmpty() ? 0 : Integer.parseInt(num);
	        }
	    });
		
		
		return listAreaName;
	}
	

	public static List<String> createCatalogyName(List<NhaDat> arrayNhaDat) {
		List<String> listCatalogyName = new ArrayList<String>();
		for (int i = 0; i < arrayNhaDat.size(); i++) {
			if (!listCatalogyName.contains(arrayNhaDat.get(i).getCatalogyName())) {
				listCatalogyName.add(arrayNhaDat.get(i).getCatalogyName());
			}

		}
		Collections.sort(listCatalogyName);
		return listCatalogyName;
	}
	
	public static List<String> createTypeName(List<NhaDat> arrayNhaDat) {
		List<String> listTypeName = new ArrayList<String>();
		for (int i = 0; i < arrayNhaDat.size(); i++) {
			if (!listTypeName.contains(arrayNhaDat.get(i).getTypeName())) {
				listTypeName.add(arrayNhaDat.get(i).getTypeName());
			}

		}
		Collections.sort(listTypeName);
		return listTypeName;
	}
	public static List<String> createLoaiNhaDat_CanBan(List<NhaDat> arrayNhaDat_CanBan){
		List<String> listTypeName = new ArrayList<String>();
		for (int i = 0; i < arrayNhaDat_CanBan.size(); i++) {
			if(StringUtils.isBlank(arrayNhaDat_CanBan.get(i).getPropertyRoadCondition())) {
				if (!listTypeName.contains(arrayNhaDat_CanBan.get(i).getTypeName()+"-"+arrayNhaDat_CanBan.get(i).getCatalogyName())) {
					listTypeName.add(arrayNhaDat_CanBan.get(i).getTypeName()+"-"+arrayNhaDat_CanBan.get(i).getCatalogyName());
				}
			}else {
				if (!listTypeName.contains(arrayNhaDat_CanBan.get(i).getTypeName()+"-"+arrayNhaDat_CanBan.get(i).getCatalogyName()+"-"+arrayNhaDat_CanBan.get(i).getPropertyRoadCondition())) {
					listTypeName.add(arrayNhaDat_CanBan.get(i).getTypeName()+"-"+arrayNhaDat_CanBan.get(i).getCatalogyName()+"-"+arrayNhaDat_CanBan.get(i).getPropertyRoadCondition());
				}
			}
			

		}
		Collections.sort(listTypeName);
		return listTypeName;
	}
	public static List<String> createLoaiNhaDat_CanMua(List<NhaDat> arrayNhatDat_CanMua) {
		List<String> listTypeName = new ArrayList<String>();
		for (int i = 0; i < arrayNhatDat_CanMua.size(); i++) {
			if(StringUtils.isBlank(arrayNhatDat_CanMua.get(i).getPropertyRoadCondition())) {
				if (!listTypeName.contains(arrayNhatDat_CanMua.get(i).getTypeName()+"-"+arrayNhatDat_CanMua.get(i).getCatalogyName())) {
					listTypeName.add(arrayNhatDat_CanMua.get(i).getTypeName()+"-"+arrayNhatDat_CanMua.get(i).getCatalogyName());
				}
			}else {
				if (!listTypeName.contains(arrayNhatDat_CanMua.get(i).getTypeName()+"-"+arrayNhatDat_CanMua.get(i).getCatalogyName()+"-"+arrayNhatDat_CanMua.get(i).getPropertyRoadCondition())) {
					listTypeName.add(arrayNhatDat_CanMua.get(i).getTypeName()+"-"+arrayNhatDat_CanMua.get(i).getCatalogyName()+"-"+arrayNhatDat_CanMua.get(i).getPropertyRoadCondition());
				}
			}
			

		}
		Collections.sort(listTypeName);
		return listTypeName;
	}
	public static List<String> createLoaiNhaDat_ChoThue(List<NhaDat> arrayNhatDat_ChoThue) {
		List<String> listTypeName = new ArrayList<String>();
		for (int i = 0; i < arrayNhatDat_ChoThue.size(); i++) {
			if(StringUtils.isBlank(arrayNhatDat_ChoThue.get(i).getPropertyRoadCondition())) {
				if (!listTypeName.contains(arrayNhatDat_ChoThue.get(i).getTypeName()+"-"+arrayNhatDat_ChoThue.get(i).getCatalogyName())) {
					listTypeName.add(arrayNhatDat_ChoThue.get(i).getTypeName()+"-"+arrayNhatDat_ChoThue.get(i).getCatalogyName());
				}
			}else {
				if (!listTypeName.contains(arrayNhatDat_ChoThue.get(i).getTypeName()+"-"+arrayNhatDat_ChoThue.get(i).getCatalogyName()+"-"+arrayNhatDat_ChoThue.get(i).getPropertyRoadCondition())) {
					listTypeName.add(arrayNhatDat_ChoThue.get(i).getTypeName()+"-"+arrayNhatDat_ChoThue.get(i).getCatalogyName()+"-"+arrayNhatDat_ChoThue.get(i).getPropertyRoadCondition());
				}
			}
			

		}
		Collections.sort(listTypeName);
		return listTypeName;
	}

	public static List<String> createLoaiNhaDat_CanThue(List<NhaDat> arrayNhatDat_CanThue) {
		List<String> listTypeName = new ArrayList<String>();
		for (int i = 0; i < arrayNhatDat_CanThue.size(); i++) {
			if(StringUtils.isBlank(arrayNhatDat_CanThue.get(i).getPropertyRoadCondition())) {
				if (!listTypeName.contains(arrayNhatDat_CanThue.get(i).getTypeName()+"-"+arrayNhatDat_CanThue.get(i).getCatalogyName())) {
					listTypeName.add(arrayNhatDat_CanThue.get(i).getTypeName()+"-"+arrayNhatDat_CanThue.get(i).getCatalogyName());
				}
			}else {
				if (!listTypeName.contains(arrayNhatDat_CanThue.get(i).getTypeName()+"-"+arrayNhatDat_CanThue.get(i).getCatalogyName()+"-"+arrayNhatDat_CanThue.get(i).getPropertyRoadCondition())) {
					listTypeName.add(arrayNhatDat_CanThue.get(i).getTypeName()+"-"+arrayNhatDat_CanThue.get(i).getCatalogyName()+"-"+arrayNhatDat_CanThue.get(i).getPropertyRoadCondition());
				}
			}
			

		}
		Collections.sort(listTypeName);
		return listTypeName;
	}
//Tao mang
	public static void createtinhTP(Map<Integer, String> tinhTP) {
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
	
	//CU
	// Convert KB to MB, GB
		public static String convert2MB_GB(double size) {
			String sizeNew = null;
			if (size > 1024) {
				size = Math.round(size / 1024);
				if (size > 1024) {
					size = Math.round(size / 1024);
					if (size > 1024) {
						size = Math.round(size / 1024);
						sizeNew = String.valueOf(size) + " GB";
					} else {
						sizeNew = String.valueOf(size) + " MB";
					}
				} else {
					sizeNew = String.valueOf(size) + " KB";
				}
			} else {
				sizeNew = String.valueOf(size) + " Byte";
			}
			return sizeNew;

		}

		public static double calculateAVG(List<TanSuat> listSDT_TanSuat) {
			double sum = 0;
			for (TanSuat tanSuat : listSDT_TanSuat) {
				sum += tanSuat.getTanSuat();
			}
			return sum/listSDT_TanSuat.size();
		}

		

		

		

		

}
