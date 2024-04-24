package com.shopperStackgeneric;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	FileInputStream fis;
	public String readPropertyData(String value) throws IOException {
		fis=new FileInputStream(FrameworkContants.propertyPath);
		Properties pro=new Properties();
		pro.load(fis);
		value=pro.getProperty(value);
		return value;
	}
	public String readExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		fis=new FileInputStream(FrameworkContants.excelPath);
		Workbook workbook=WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
}
