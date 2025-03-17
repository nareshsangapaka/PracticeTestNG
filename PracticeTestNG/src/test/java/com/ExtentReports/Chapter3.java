package com.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Chapter3 {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file= new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		extentReports 						//Method changing process
		.createTest("Test 1")
		.log(Status.INFO, "Info1")
		.log(Status.INFO, "info2")
		.log(Status.PASS, "Pass")
		.log(Status.WARNING, "Warn")
		.log(Status.WARNING, "Warn")
		.log(Status.FAIL, "Failed")
		.log(Status.PASS, "Pass");
		
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
