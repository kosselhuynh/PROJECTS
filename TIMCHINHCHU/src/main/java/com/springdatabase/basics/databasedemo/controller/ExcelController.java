package com.springdatabase.basics.databasedemo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.springdatabase.basics.databasedemo.entity.Files;
import com.springdatabase.basics.databasedemo.service.FilesService;

@Controller
public class ExcelController {
	@Autowired
	FilesService filesService;

	private String fileLocation;

	@PostMapping("/uploadExcelFile")
	public String uploadFile(Model model, MultipartFile file, HttpServletRequest request) throws IOException {
		String catalogySelect = request.getParameter("catalogySelect");
		InputStream in = file.getInputStream();
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
		readFileExcelAndSaveDB(fileLocation, catalogySelect);

		FileOutputStream f = new FileOutputStream(fileLocation);
		int ch = 0;
		while ((ch = in.read()) != -1) {
			f.write(ch);
		}
		f.flush();
		f.close();
		model.addAttribute("message", "File: " + file.getOriginalFilename() + " has been uploaded successfully!");
		return "dashboard";
	}

	// Excel
	public void readFileExcelAndSaveDB(String fileLocation, String catalogy) {
		FileInputStream file;
		try {
			file = new FileInputStream(new File(fileLocation));
			Workbook workbook = new XSSFWorkbook(file);

			//For Catalogy
			List<String> listCatalogy = new ArrayList<String>();
			listCatalogy.add("ANTIVIRUS");
			listCatalogy.add("DRIVER");
			listCatalogy.add("GAMES");
			listCatalogy.add("GRAPHICS");
			listCatalogy.add("INTERNET");
			listCatalogy.add("MULTIMEDIA");
			listCatalogy.add("NETWORK");
			listCatalogy.add("OFFICE");
			listCatalogy.add("OPERATOR_SYSTEM");
			listCatalogy.add("OTHER");
			listCatalogy.add("PROGRAMER");
			listCatalogy.add("SCIENCE");
			for (int i = 0; i <= 11; i++) {
				Sheet sheet = workbook.getSheet(listCatalogy.get(i));
			//	System.out.println("listCatalogy.get(i) " + listCatalogy.get(i));
				
				List<Files> listFiles = new ArrayList<>();
				for (Row row : sheet) {
				//	System.out.println("row.getRowNum() " + row.getRowNum());
					if (!(StringUtils.equals("Name", row.getCell(0).getRichStringCellValue().toString()))) {
						//Check file exist in database with Name and Size
						String nameNew = row.getCell(0).getRichStringCellValue().toString().toLowerCase();
						String sizeNew = Utils.convert2MB_GB(row.getCell(2).getNumericCellValue());
						if(!filesService.findAll_isExist_Where_sameNameAndSize(nameNew, sizeNew)) {//If new Files is not Exist in DB
							Files files = new Files();
							files.setName(row.getCell(0).getRichStringCellValue().toString().toLowerCase());
							files.setPathView(row.getCell(1).getRichStringCellValue().toString());
							// files.setSize(String.valueOf(row.getCell(2).getNumericCellValue() + " KB"));
							files.setSize(Utils.convert2MB_GB(row.getCell(2).getNumericCellValue()));
		
							files.setDateUpload(new Date());
							// Default
							Random rand = new Random();

							// Obtain a number between [0 - 49].
							int n = rand.nextInt(1000) + 1000;
							
							files.setDownloads(n);
							files.setCatalogy(listCatalogy.get(i).toString());
							// Add to List
							listFiles.add(files);
						}
					}
				}
				// Save DB
				filesService.insert(listFiles);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
