package com.PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationLaunch {
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browserName")
	public void InitialiseBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
//			driver.manage().window().maximize();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
//			driver.manage().window().maximize();
			break;
		default:
			System.err.println("BrowserName is invalid");
			break;
		}
		
	}
	@Parameters("url")
	@Test
	public void LaunchApp(String url) {
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("tv9");
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void Teardown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
		
	}

}
