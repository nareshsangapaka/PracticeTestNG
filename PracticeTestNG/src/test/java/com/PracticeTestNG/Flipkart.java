package com.PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	WebDriver driver;
	@Test
	public void HomePage() {
		driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("flipkart", Keys.ENTER);
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
//		System.out.println(driver.getTitle());
//		String expectedTitle = "flipkart - GoogleSearch";
//		String actualTitle = driver.getTitle();
//		assertEquals(actualTitle, expectedTitle,"Title is mismatched");
//		driver.get("https://www.flipkart.com/");
		driver.quit();
	}
	@Test
	public void LoginDetail() throws Exception {
		driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']")).click();
		driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("123456789");
		Thread.sleep(5000);
//		driver.quit();
	}
	@Test
	public void SearchProduct() throws Exception {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("mobiles",Keys.ENTER);
		Thread.sleep(5000);
		driver.quit();
	}
	
}
