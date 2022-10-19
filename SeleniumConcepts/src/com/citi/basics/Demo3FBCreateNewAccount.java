package com.citi.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo3FBCreateNewAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.partialLinkText("Create ")).click();
		driver.findElement(By.name("firstname")).sendKeys("Human");
		driver.findElement(By.name("lastname")).sendKeys("Being");
		driver.findElement(By.xpath("//input[@value='-1']")).click();
		
		//dropdown: 2/2/2022
		
		Select selectDay = new Select(driver.findElement(By.id("day")));
		selectDay.selectByVisibleText("2");
		
		Select selectMonth = new Select(driver.findElement(By.id("month")));
		selectMonth.selectByValue("2");
		
		Select selectYear = new Select(driver.findElement(By.id("year")));
		selectYear.selectByIndex(0);
	}

}
