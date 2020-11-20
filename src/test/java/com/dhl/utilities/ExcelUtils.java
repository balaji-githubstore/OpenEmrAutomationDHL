package com.dhl.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getSheetIntoObjectArray(String fileDetail,String sheetName) throws IOException {		
		
		FileInputStream file = new FileInputStream(fileDetail);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow rowC = sheet.getRow(1);
		int colCount = rowC.getPhysicalNumberOfCells();
		Object[][] main = new Object[rowCount - 1][colCount];
		DataFormatter format = new DataFormatter();
		for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
			for (int cellIndex = 0; cellIndex < colCount; cellIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				XSSFCell cell = row.getCell(cellIndex);
				String value = format.formatCellValue(cell);
				main[rowIndex - 1][cellIndex] = value;
			}
		}
		return main;
	}

}
