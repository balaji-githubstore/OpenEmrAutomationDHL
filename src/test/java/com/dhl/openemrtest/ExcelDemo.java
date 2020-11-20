package com.dhl.openemrtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {
		
		//location //read only 
		FileInputStream file = new FileInputStream("testdata/openemrdata.xlsx");
		//open
		XSSFWorkbook book=new XSSFWorkbook(file);
		//sheet 
		XSSFSheet sheet = book.getSheet("invalidCredentialData");
		//rowCount
		int rowCount = sheet.getPhysicalNumberOfRows();
		//row 
		XSSFRow rowC= sheet.getRow(1);
		//ColCount
		int colCount=rowC.getPhysicalNumberOfCells();
		
		Object[][] main = new Object[rowCount-1][colCount];
		
		for(int rowIndex=1;rowIndex<rowCount;rowIndex++)
		{
			for(int cellIndex=0;cellIndex<colCount;cellIndex++)
			{
				XSSFRow row= sheet.getRow(rowIndex);
				XSSFCell cell = row.getCell(cellIndex);
				
				DataFormatter format = new DataFormatter();
				String value = format.formatCellValue(cell);
				System.out.println(value);
				main[rowIndex-1][cellIndex]=value;
			}
		}
		
		System.out.println(main);
	}
}







