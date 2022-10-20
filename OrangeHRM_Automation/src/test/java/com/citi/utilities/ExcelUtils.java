package com.citi.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static Object[][] getSheetIntoTwoDimensionalArrayString(String filename, String sheetname) throws IOException {
		FileInputStream file = new FileInputStream(filename);

		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetname);
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		int rowCount = sheet.getPhysicalNumberOfRows();
		// System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
		DataFormatter formatter = new DataFormatter();
		Object[][] data = new Object[rowCount - 1][columnCount];
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < columnCount; c++) {
				data[r - 1][c] = formatter.formatCellValue(sheet.getRow(r).getCell(c));
			}
		}
		return data;
	}
}
