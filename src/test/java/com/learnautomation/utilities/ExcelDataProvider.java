package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() throws IOException
	{
		File src= new File("./TestData/TestDataExcel.xlsx");
		
		FileInputStream fis= new FileInputStream(src);
		
		wb= new XSSFWorkbook(fis);
	}
	
	public String getStringData(int sheetindex,int row, int column)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetname,int row, int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getnumericData(String sheetname,int row, int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}

	
}
