package com.PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationAttributes {
	@Test(invocationCount = 4,threadPoolSize = 2)
	public void methodLogin() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://randomuser.me/");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
	System.out.println("UserName"+ driver.findElement(By.id("user_value")));
	
	driver.findElement(By.xpath("//li[@data-label='email']")).click();
	System.out.println("My email address is"+ driver.findElement(By.id("user_title")));

	driver.quit();
		
	}

}
