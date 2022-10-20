package com.citi.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("test_data/orange_data.xlsx");

		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("invalidCredentialTest");
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		int rowCount = sheet.getPhysicalNumberOfRows();
		// System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());

		Object[][] data = new Object[rowCount-1][columnCount];
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < columnCount; c++) {
				data[r - 1][c] = sheet.getRow(r).getCell(c).getStringCellValue();
			}
		}
	}
}
