package com.CrossBrowser;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestClass_012 extends BaseTest{

	@Test(priority=2,testName = "TestDemo",groups= {"smoke","functional"})
	public void TestDemo() throws IOException {
		
		driver.get("https://demo.guru99.com/V1/index.php");
		extentTest.info("Navigated to URL");
		
		driver.findElement(By.name("uid")).sendKeys("mngr610706");
		extentTest.info("Entered text in search box ");
		
		driver.findElement(By.name("password")).sendKeys("AdUzYbU");
		extentTest.info("Entered text in search box ");
		driver.findElement(By.name("btnLogin")).click();
		
		System.out.println(driver.getTitle());
		String expectedTitle = "GTPL Bank Manager HomePage";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle,"Title is mismatched");
		extentTest.pass("Assertion is passed for Web Title");
		
	}
	@Test(priority=1,testName = "TestFacebook",groups= {"sanity","Regreesion"})
	public void TestFacebook() throws Exception { 
		driver.get("https://www.facebook1.com/");
		driver.findElement(By.id("email")).sendKeys("nnaresh.s538@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Naresh123");
		
		driver.findElement(By.name("login")).click();
		System.out.println(driver.getTitle());
		
		
	}

}
