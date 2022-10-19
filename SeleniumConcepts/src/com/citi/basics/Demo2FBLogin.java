package com.citi.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		//find a element and then, on that we element, perform actions.
		//1. user name.
		driver.findElement(By.id("email")).sendKeys("Hello World!");
		//2. Password
		driver.findElement(By.id("pass")).sendKeys("password");
		//3. Click on login
		//driver.findElement(By.id("u_0_5_Vx")).click(); //fails. Cause this ID is dynamic. Go with name
		driver.findElement(By.name("login")).click();
		//driver.quit();
	}

}
