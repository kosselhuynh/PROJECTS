package com.springdatabase.basics.databasedemo.controller;


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

	
}
