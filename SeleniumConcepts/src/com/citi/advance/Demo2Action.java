package com.citi.advance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v104.performance.Performance;
import org.openqa.selenium.interactions.Actions;

public class Demo2Action {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//https://nasscom.in/
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://nasscom.in/");
		
		Actions action  = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[@class = 'menu__link']"))).perform();
		
		driver.findElement(By.partialLinkText("Become a member")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
