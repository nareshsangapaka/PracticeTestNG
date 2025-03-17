package com.ExtentReports;

public class Test {

	public static void main(String[] args) {
        // Get Browser Version 
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
//		System.out.println(capabilities.getBrowserName());
//		System.out.println(capabilities.getBrowserVersion());	
//		driver.quit();
		
//		System.getProperties().list(System.out);  // Get System info
		System.out.println(System.getProperty("os.name"));
		System.out.println("java" +System.getProperty("java.version"));
	}

}
