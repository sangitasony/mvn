package com.crm.genericlib;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils {
	public Properties getpropertyFileObject() throws Exception{
		FileInputStream in=new FileInputStream("./testData/commanData.properties");
		Properties pobj=new Properties();
		pobj.load(in);
		return pobj;
	}
	public String getExcelData(String sheetName, int rownum,int colnum) throws Exception{
		FileInputStream in=new FileInputStream("./testData/testscript.xlsx");
		Workbook wb=WorkbookFactory.create(in);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rownum);
		String data=row.getCell(colnum).getStringCellValue();
		wb.close();
		return data;
	}
	public void setExcelData(String sheetName, int rownum,int colnum,String data) throws Exception{
		FileInputStream in=new FileInputStream("./testData/testscript.xlsx");
		Workbook wb=WorkbookFactory.create(in);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rownum);
		Cell cel=row.createCell(rownum);
		cel.setCellValue(data);
		FileOutputStream stream=new FileOutputStream("./testData/testscript.xlsx");
		wb.write(stream);
		wb.close();
	}


}


