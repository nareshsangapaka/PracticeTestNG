package com.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Chapter7 {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file= new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
//		ExtentSparkReporterConfig config= sparkReporter.config(); 
//		config.setTheme(Theme.DARK);
//		config.setReportName("Report name");
//		config.setDocumentTitle("Doc Title");
//		config.setTimeStampFormat("dd-mm-yyyy hh:mm:ss");
//		config.setCss(".badge-primary{background-color:#bc3869}");
//		config.setJs("document.getElementsByClassName('logo')[0].style.display='none';");
		
//		sparkReporter.loadJSONConfig(new File("./src/test/resources/extent-reports-config.json"));
		sparkReporter.loadXMLConfig(new File("./src/test/resources/extent-reports-config.xml"));
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
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
