package com.PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitTest {
	
	WebDriver driver;
	@Test
	public void LaunchGitSite() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/");
driver.findElement(By.xpath("//div[@class='position-relative HeaderMenu-link-wrap d-lg-inline-block']")).click();		
	}
	@Test
	public void LoginGit() {
		driver.findElement(By.id("login_field")).sendKeys("nareshsangapaka");
		driver.findElement(By.id("password")).sendKeys("@Azure1234");
		driver.findElement(By.name("commit")).click();
	}
	@Test
	public void VerifyLogin() throws Exception {
		driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.quit();
	}
	

}
