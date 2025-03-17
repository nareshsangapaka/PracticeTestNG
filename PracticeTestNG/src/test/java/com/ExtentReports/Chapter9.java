package com.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Chapter9 {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file= new File("report.html");
		ExtentSparkReporter	sparkReporter= new ExtentSparkReporter(file);
		sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] {
				ViewName.DASHBOARD,
				ViewName.TEST,
				ViewName.EXCEPTION,
				ViewName.DEVICE,
				ViewName.CATEGORY
		}).apply();
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
