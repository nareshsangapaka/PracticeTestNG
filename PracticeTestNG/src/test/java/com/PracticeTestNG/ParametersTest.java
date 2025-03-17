package com.PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTest {
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browserName")
	public void InitialiseBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
			default:
				System.err.println("Browsername is invalid");
			break;
		}
		
		
	}
	
	@Test
	public void LaunchApp() {
		driver.get("https://www.google.com/");
		driver.findElement(By.id("q")).sendKeys("Tv9",Keys.ENTER);
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
		
	}

}
