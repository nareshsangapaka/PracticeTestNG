package com.DpTests;

import org.testng.annotations.Test;

public class DPTest1 {
	@Test(dataProvider = "dp1",dataProviderClass = DataSupplier.class)
	public void TestLogin(String s) {
		System.out.println(s);
	}
//	@DataProvider(indices = {0,2})
//	public String[] dp1() {
//	String[] data = new String[] {
//			"Nidhi",
//			"nithya",
//			"karuna",
//			"naresh"
//	};
//	return data;
//	}
}
