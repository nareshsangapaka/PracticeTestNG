package com.PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertTest {
	
	WebDriver driver;
	@Test
	public void TestFacebook() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("naresh");
		driver.findElement(By.name("login")).click();
//		driver.findElement(By.id("pass")).sendKeys("Naresh123");
		Thread.sleep(5000);
		SoftAssert softAssert = new SoftAssert();
		//Title Assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook";
		softAssert.assertEquals(actualTitle, expectedTitle,"Title is mismatched");
//		//URL Assertion
//		String actualUrl = driver.getCurrentUrl();
//		String expectedUrl = "https://www.facebook.com/two_step_verification/authentication/";
//		softAssert.assertEquals(actualUrl, expectedUrl,"Url is mismatched");
		//Text Assertion
//		String actualText = driver.findElement(By.id("email")).getDomAttribute("value");
//		String expectedText = "naresh";
//		softAssert.assertEquals(actualText, expectedText,"UsernameText is mismatched");
		//Border Assertion
//		String actualBorder = driver.findElement(By.id("email")).getCssValue("border");
//		String expectedBorder = "1px solid rgb(221, 223, 226)";
//		softAssert.assertEquals(actualBorder, expectedBorder,"UsernameBorder is mismatched");
		//ErrorMessage Assertion
//		String actualErrorMessage= driver.findElement(By.xpath("//div[@id='email_container']")).getText();
//		String expectedErrorMessage = "The password that you've entered is incorrect";
//		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage,"ErrorMessage is mismatched");
		
		System.out.println(driver.getTitle());
		driver.quit();
		softAssert.assertAll();
	}

} 
