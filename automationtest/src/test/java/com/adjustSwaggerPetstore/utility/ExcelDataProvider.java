package com.adjustSwaggerPetstore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataProvider {
	HSSFWorkbook wb;

	public ExcelDataProvider(){
		File src = new File("./TestData/Test.xls");
		try {
		FileInputStream fis = new FileInputStream(src);
			wb = new HSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read file "+e.getMessage());
		}
	}
	
	public String getStringData(String sheetName,int rownum,int cellnum){
		return wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	}
	
	public String getStringData(int sheetIndex,int rownum,int cellnum){
		return wb.getSheetAt(sheetIndex).getRow(rownum).getCell(cellnum).getStringCellValue();
	}
		
	public double getNumbericData(String sheetName,int rownum,int cellnum){
		 return wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getNumericCellValue();
	}
}
