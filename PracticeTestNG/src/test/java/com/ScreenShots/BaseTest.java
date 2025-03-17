package com.ScreenShots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    public static WebDriver driver;
    public static String screenshotSubFolderName;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		driver.manage().window().maximize();

	}
	 @AfterMethod
	 public void screenshotCapture(ITestResult result) {
		 if(result.getStatus()==ITestResult.FAILURE) {
		 captureScreenshot(result.getTestContext().getName()+"_"+ result.getMethod().getMethodName()+".jpg");
		 }
		 
	 }

	@AfterTest
	public void teardown() {

		driver.quit();
	}
	
	public void captureScreenshot(String fileName) {
		if (screenshotSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    System.out.println("Before formatting: " + myDateObj);
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

		    screenshotSubFolderName = myDateObj.format(myFormatObj);
			
		}		
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+screenshotSubFolderName+"/"+fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		
	}

}
