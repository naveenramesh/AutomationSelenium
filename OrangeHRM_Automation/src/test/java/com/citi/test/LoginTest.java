package com.citi.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;
import com.citi.utilities.DataUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends AutomationWrapper {

	

	@Test
	public void validCredentialTest() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));

		String actualvalue = driver.findElement(By.xpath("//h5[text()='Employee Information']")).getText();
		Assert.assertEquals(actualvalue, "Employee Information");
	}

	@Test(dataProvider = "invalidData",dataProviderClass = DataUtils.class)
	public void invalidCredentialTest(String username, String password, String expected) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Login']")));

		String actualvalue = driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
		Assert.assertEquals(actualvalue, expected);
	}
}
