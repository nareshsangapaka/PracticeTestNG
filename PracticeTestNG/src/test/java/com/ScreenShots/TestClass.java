package com.ScreenShots;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TestClass extends BaseTest   {
	
	@Test(testName = "TestGoogle")
	public void TestGoogle() throws Exception {
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
		System.out.println(driver.getTitle());
		String expectedTitle = "HYR Tutorials - Google Search";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle,"Title is mismatched");
		assertTrue(false);
		
	}
	@Test(testName = "TestFacebook")
	public void TestFacebook() throws Exception { 
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("naresh.s538@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Naresh123");
		
		driver.findElement(By.name("login")).click();
		System.out.println(driver.getTitle());
		
		
	}

}
