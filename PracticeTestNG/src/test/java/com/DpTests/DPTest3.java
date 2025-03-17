package com.DpTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DPTest3 {
	
	WebDriver driver;
//	@Test(dataProvider = "logindata",dataProviderClass = ExcelDataSupplier.class)
	public void LaunchGitSite(String userName, String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://github.com/login");
		driver.findElement(By.id("login_field")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
		Thread.sleep(5000);
		driver.quit();
	}
//	@DataProvider()
//	public Object[][] LaunchGit() {
//		Object[][]	 data = new Object[2][2];
//		data[0][0] = "nareshsangapaka";
//		data[0][1] = "@Azure1234";
//		
//		data[1][0] = "nareshsangapaka";
//		data[1][1] = "Azure1234";
//		return data;
//			
//		}
}
