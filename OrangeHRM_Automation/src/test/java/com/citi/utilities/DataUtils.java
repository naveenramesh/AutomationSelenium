package com.citi.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider
	public String[][] invalidData()
	{
		String[][] loginData = new String[2][3];
		
		loginData[0][0] = "john";
		loginData[0][1]="john123";
		loginData[0][2] = "Invalid credentials";

		loginData[1][0] = "Admin";
		loginData[1][1]="Admin1234";
		loginData[1][2] = "Invalid credentials";

		return loginData;
	}
	
	@DataProvider
	public Object[][] commonDataProvider(Method method) throws Exception{
		// return ExcelUtils.getSheetIntoTwoDimensionalArrayString("test_data/orange_data.xlsx", "invalidCredentialTest");
		return ExcelUtils.getSheetIntoTwoDimensionalArrayString("test_data/orange_data.xlsx", method.getName());
	}
}
