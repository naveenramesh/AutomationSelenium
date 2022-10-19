package com.citi.assisgnment;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment4Tabs {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.online.citibank.co.in/");

		driver.findElement(By.xpath("//a[@title = 'Close']")).click();
		driver.findElement(By.className("txtSign")).click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.findElement(By.xpath("//div[@onclick = 'ForgotUserID();']")).click();

//		driver.switchTo().defaultContent();
//		tabs = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs.get(1));

//		Select account = new Select(driver.findElement(By.id("accountType")));
//		account.selectByValue("Credit Card");
		// driver.findElement(By.id("sbToggle_14186506")).click();
		action.click(driver.findElement(By.xpath("//a[@class='sbToggle']"))).perform();
		driver.findElement(By.partialLinkText("Credit Card")).click();
		driver.findElement(By.xpath("//input[@name = 'citiCard1']")).sendKeys("4545565688879998");
		driver.findElement(By.name("CCVNO")).click();
		// driver.quit();

	}
}
