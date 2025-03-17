package com.DpTests;

import org.testng.annotations.DataProvider;

public class DataSupplier {

	@DataProvider
	public String[] dp1() {
	String[] data = new String[] {
			"Nidhi",
			"nithya",
			"karuna",
			"naresh"
	};
	return data;
	}
	
	@DataProvider
	public String[] dp2() {
	String[] data = new String[] {
			"dady",
			"mummy",
			"brother",
			"sister"
	};
	return data;
	}
}
