package com.citi.frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo1Frame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//https://netbanking.hdfcbank.com/netbanking/
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
//		driver.findElement(By.name("fldLoginUserId")).sendKeys("user1234");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name= 'login_page']"))).
		findElement(By.xpath("//input[@name= 'fldLoginUserId']")).sendKeys("user1234");
		
		driver.findElement(By.partialLinkText("CONTINUE")).click();
		Thread.sleep(5000);
		driver.quit();
	}

}
