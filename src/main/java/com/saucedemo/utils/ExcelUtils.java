package com.saucedemo.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	XSSFWorkbook excel;
	
	//This constructor loads the excel sheet
	public ExcelUtils(String path) 
	{
		try {
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			excel = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Unable to load the excel sheet :"+e.getLocalizedMessage());
		}
		
	}
	
	//This method returns the active row count
	public int getRowCount(int sheetNum) {
	 return excel.getSheetAt(sheetNum).getLastRowNum()+1;
	}
	
	
	//This method returns the cell data
	public String getCellData(int sheetnum,int row, int cell) {
		return excel.getSheetAt(sheetnum).getRow(row).getCell(cell).toString();
		
	}

}
