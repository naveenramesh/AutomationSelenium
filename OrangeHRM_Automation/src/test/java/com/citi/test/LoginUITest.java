package com.citi.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper{

		@Test
		public void titleTest(){
			String text = driver.getTitle();
			
			Assert.assertEquals(text, "OrangeHRM");
		}
		
		@Test
		public void placeHolderTest() {
			String placeholderUsername = driver.findElement(By.name("username")).getAttribute("placeholder");
			String placeholderPassword = driver.findElement(By.name("password")).getAttribute("placeholder");
			
			Assert.assertEquals(placeholderUsername, "Username");
			Assert.assertEquals(placeholderPassword, "Password");
		}
}
