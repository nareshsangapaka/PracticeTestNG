package com.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Chapter10 {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		ExtentSparkReporter sparkReporter_fail = new ExtentSparkReporter("FailedTests.html");
		sparkReporter_fail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
		ExtentSparkReporter sparkReporter_skipAndWarning = new ExtentSparkReporter("SkippedTests.html");
		sparkReporter_skipAndWarning.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
				
				}).apply();
		
		extentReports.attachReporter(sparkReporter_all,sparkReporter_fail,sparkReporter_skipAndWarning);
		
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
		.skip("this is skipped test");
		
		extentReports
		.createTest("Attribute Test 4","Test desc")
		.assignAuthor("Nithya","Lucky","cutie","Laddu")
		.assignCategory("Sanity","smoke","Regretion","Funtctional")
		.assignDevice("edge 99","chrome","firefox","ie")
		.warning("this is Warnning test");
		
		Throwable t = new RuntimeException("This is a Custom Exceptions");
		extentReports
		.createTest("Exception Test")
		.fail(t);		
		
		extentReports.flush();
		Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("SkippedTests.html").toURI());
	
	}
}

