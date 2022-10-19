package com.citi.advance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo1Upload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		////input[@type = 'file' ]
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		
		driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys("C:\\Users\\Administrator\\Downloads\\demo pdf.pdf");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
