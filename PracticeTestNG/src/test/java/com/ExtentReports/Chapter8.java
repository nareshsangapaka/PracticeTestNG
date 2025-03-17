package com.ExtentReports;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Chapter8 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();

		ExtentReports extentReports = new ExtentReports();
		File file= new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		ExtentSparkReporterConfig config= sparkReporter.config(); 
		config.setTheme(Theme.DARK);
		config.setReportName("Report name");
		config.setDocumentTitle("Doc Title");
		config.setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
		config.setCss(".badge-primary{background-color:#bc3869}");
		config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
		// get System and Browser version
		extentReports.setSystemInfo("os", System.getProperty("os.name"));
		extentReports.setSystemInfo("java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("browser", capabilities.getBrowserName()+capabilities.getBrowserVersion());
		extentReports.setSystemInfo("App URL", "www.Google.com");
		
//		sparkReporter.loadJSONConfig(new File("./src/test/resources/extent-reports-config.json"));
//		sparkReporter.loadXMLConfig(new File("./src/test/resources/extent-reports-config.xml"));
		extentReports.attachReporter(sparkReporter);
		
		extentReports
		.createTest("Attribute Test 1","Test desc")
		.assignAuthor("Nidhi")
		.assignCategory("Smoke")
		.assignDevice("Chrome")
		.pass("this is a Passed Test");
		
		extentReports
		.createTest("Attribute Test 2","Test desc")
		.assignAuthor("Nithya")
		.assignCategory("Sanity")
		.assignDevice("edge 99")
		.fail("this is a Failed Test");
		
		extentReports
		.createTest("Attribute Test 3","Test desc")
		.assignAuthor("Nithya","Lucky","cutie","Laddu")
		.assignCategory("Sanity","smoke","Regretion","Funtctional")
		.assignDevice("edge 99","chrome","firefox","ie")
		.fail("this is a Failed Test");
		
		
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
