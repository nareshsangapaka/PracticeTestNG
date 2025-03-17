package com.ExtentReports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Chapter4 {

	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();
		File file= new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		extentReports 						//Method changing process
		.createTest("Text Based Test")
		.log(Status.INFO, "Info1")
		.log(Status.INFO, "<b>info2<b/>") //only bold
		.log(Status.PASS, "<i>Pass<i/>") // only italic
		.log(Status.INFO, "<b><i>info3<i/><b/>"); // Bold ,italic
		
		String xmlData= "<menu id=\"file\" value=\"File\">\r\n"     //XML
		 + "<popup>\r\n"
		 +   "<menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
		 +  " <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
		 +  " <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
		 + "</popup>\r\n"
		+"</menu>";
		
		String jsonData="{\"menu\": {\r\n"              //JSON
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		extentReports 						//Method changing process
		.createTest("Xml Based Test")
		.info(MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
		
		extentReports 						//Method changing process
		.createTest("Json Based Test")
		.log(Status.INFO, MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		// Collection Data
		List<String> listData=new ArrayList<>();
		listData.add("Nidhi");
		listData.add("Nithya");
		listData.add("Lucky");
		
		Map<Integer, String> mapData= new HashMap<>();
		mapData.put(101, "Nidhi");
		mapData.put(102, "Nithya");
		mapData.put(103, "Lucky");
		Set<Integer> setData=mapData.keySet();
		
		extentReports 						//Method changing process
		.createTest("List Based Test")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));
		
		extentReports 						//Method changing process
		.createTest("Map Based Test")
		.info(MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));
		
		extentReports 						//Method changing process
		.createTest("Set Based Test")
		.info(MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));	
		// HighLight of Text
		extentReports 						//Method changing process
		.createTest("Highlight Log Test")
		.info("This is not a HighLighted Message")
		.info(MarkupHelper.createLabel("This is a HighLighted Message", ExtentColor.RED));
		
		try {
			int i=5/0;
			
		} catch (Exception e) {
			extentReports 						
			.createTest("Exception Test1")
			.info(e);			
		}
		Throwable t= new RuntimeException("this is customs Exceptions");
		extentReports 						
		.createTest("Exception Test2")
		.info(t);
		
			
		extentReports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
	}

}
