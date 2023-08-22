package com.wordpress.utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil 
{
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	
	
	public ExcelUtil(String filePath,int sheetNo)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheetAt(sheetNo);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public String getCellValue(int rowNo,int colNo)
	{
		 HSSFRow row = sheet.getRow(rowNo);
		 HSSFCell cell = row.getCell(colNo);
		 return cell.toString();
	}
	
	public String getCellValue(String sheetName, int rowNo,int colNo)
	{
		 HSSFRow row = sheet.getRow(rowNo);
		 HSSFCell cell = row.getCell(colNo);
		 return cell.toString();
	}
	
	
	public int getNumberOfRows()
	{
		return sheet.getLastRowNum();
	}
	
	
}
