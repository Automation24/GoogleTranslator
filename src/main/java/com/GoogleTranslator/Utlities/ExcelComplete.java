package com.GoogleTranslator.Utlities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelComplete {

	//Reading the values from Excel sheet
	
	@SuppressWarnings({ "resource", "incomplete-switch" })
	public ArrayList<HashMap<String, String>> readExcel(String excelFile, String sheetName) throws Exception {
		String heading = "", key = "";
		ArrayList<HashMap<String, String>> arrMap = new ArrayList<HashMap<String, String>>();
		FileInputStream fis = new FileInputStream(excelFile);
		 XSSFWorkbook wb = new XSSFWorkbook(fis);
//		HSSFWorkbook wb = new HSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getPhysicalNumberOfRows();
		for (int i = 1; i < rowCount; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			Row row = sh.getRow(i);
			int colCount = row.getLastCellNum() - row.getFirstCellNum();
			for (int j = 0; j < colCount; j++) {
				heading = sh.getRow(0).getCell(j).getStringCellValue();
				Cell cel = row.getCell(j);
				switch (cel.getCellTypeEnum()) {
				case STRING:
					key = cel.getStringCellValue();
					break;
				}
				hm.put(heading, key);
			}
			arrMap.add(hm);
		}
		return arrMap;
	}
	
	
	//Writing the values to Excel sheet
	
	@SuppressWarnings("incomplete-switch")
	public void writeData(String excelFile, String sheetName,String excelTestData, String testData, String value, String excelColumName) {
		try {
			String heading = "", key = "";boolean flag=false;
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetName);
			int rowCount = sh.getPhysicalNumberOfRows();
			for (int i = 1; i <rowCount; i++) {
				HashMap<String, String> hm = new HashMap<String, String>();
				Row row = sh.getRow(i);
				int colCount = row.getPhysicalNumberOfCells();
				for (int j = 0; j <colCount; j++) {
					heading = sh.getRow(0).getCell(j).getStringCellValue();
					Cell cel = row.getCell(j);
					switch (cel.getCellTypeEnum()) {
					case STRING:
						key = cel.getStringCellValue();
						break;
					}
					hm.put(heading, key);
					if(heading.equals(excelColumName) && hm.get(excelTestData).equals(testData)) {
						flag=true;
						cel = row.createCell(j);
						cel.setCellValue(value);
						break;
					}
				}
				if(flag) {
					FileOutputStream outputStream = new FileOutputStream(excelFile);
			        wb.write(outputStream);
			        wb.close();
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
