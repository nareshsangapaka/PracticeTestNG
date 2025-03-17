package com.PracticeTestNG;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataSupplier {
	@DataProvider(name="logindata")
	public String[][]  GetData() throws Exception  {
		File excelfile= new File("C:\\Users\\user\\eclipse-workspace\\PracticeTestNG\\src\\test\\resources\\Test.xlsx");
		System.out.println(excelfile.exists());
		FileInputStream file = new FileInputStream(excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int noofRows=sheet.getPhysicalNumberOfRows();
		int noofColumn = sheet.getRow(0).getLastCellNum();
		
		String[][] data= new String[noofRows-1][noofColumn];
		for (int i = 0; i < noofRows-1; i++) {
			for (int j = 0; j < noofColumn; j++) {
				DataFormatter df= new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				
			}
			
		}
		workbook.close();
		file.close();
//		for (String[] dataArr : data) {
//			System.out.println(Arrays.toString(dataArr));
//	}
		
	return data;
	}

}
