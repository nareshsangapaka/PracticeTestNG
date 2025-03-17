package com.ExtentReports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Chapter5 {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file= new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		String base64code=captureScreenshot();
		String path=captureScreenshot("Google.jpg");
		
		extentReports
		.createTest("Screenshot Test1", "this is for attaching the Screeshot to the Test at testlevel")// test level
		.info("this is a info message") // Log Level
		.addScreenCaptureFromBase64String(base64code);
		
		extentReports
		.createTest("Screenshot Test2", "this is for attaching the Screeshot to the Test at testlevel")// test level
		.info("this is a info message") // Log Level
		.addScreenCaptureFromBase64String(base64code,"Google Homepage1")
		.addScreenCaptureFromBase64String(base64code,"Google Homepage2")
		.addScreenCaptureFromBase64String(base64code,"Google Homepage3");
		
		extentReports
		.createTest("Screenshot Test3", "this is for attaching the Screeshot to the Test at testlevel")// test level
		.info("this is a info message") // Log Level
		.addScreenCaptureFromPath(path);
			
		extentReports
		.createTest("Screenshot Test4", "this is for attaching the Screeshot to the Test at testlevel")// test level
		.info("this is a info message") // Log Level
		.addScreenCaptureFromPath(path,"Google Homepage1")
		.addScreenCaptureFromPath(path,"Google Homepage2")
		.addScreenCaptureFromPath(path,"Google Homepage3")
		.addScreenCaptureFromPath(path,"Google Homepage4");
		
		extentReports  // Log level BASE64
		.createTest("Screenshot Test5", "this is for attaching the Screeshot to the Test at Log level")// test level
		.info("this is a info message") // Log Level
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code,"Google Homepage").build());
		
		extentReports  // Log level Path 
		.createTest("Screenshot Test6", "this is for attaching the Screeshot to the Test at Log level")// test level
		.info("this is a info message") // Log Level
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Homepage").build());
		
		extentReports  // Log level BASE64
		.createTest("Screenshot Test7", "this is for attaching the Screeshot to the Test at Log level")// test level
		.info("this is a info message") // Log Level media method
		.fail("this is a info message",MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail("this is a info message",MediaEntityBuilder.createScreenCaptureFromBase64String(base64code,"Google Homepage").build());
		
		extentReports  // Log level Path 
		.createTest("Screenshot Test8", "this is for attaching the Screeshot to the Test at Log level")// test level
		.info("this is a info message") // Log Level
		.fail("this is a info message",MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail("this is a info message",MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Homepage").build());
		
		Throwable t=new Throwable("This is a throwable Exception");// throwable method
		
		extentReports  // Log level BASE64
		.createTest("Screenshot Test9", "this is for attaching the Screeshot to the Test at Log level")// test level
		.info("this is a info message") // Log Level
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail(t,MediaEntityBuilder.createScreenCaptureFromBase64String(base64code,"Google Homepage").build());
		
		extentReports  // Log level Path 
		.createTest("Screenshot Test10", "this is for attaching the Screeshot to the Test at Log level")// test level
		.info("this is a info message") // Log Level
		.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(path, "Google Homepage").build());
				
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}
	public static String captureScreenshot() {
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		String base64code=takeScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("Screenshot Saved Successfully");
		return base64code;
	}
	public static String captureScreenshot(String fileName) {
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		File DestFile= new File("./Screenshots/"+fileName);
		try {
			FileUtils.copyFile(sourceFile, DestFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot Saved Successfully");
		return DestFile.getAbsolutePath();
	}

}
