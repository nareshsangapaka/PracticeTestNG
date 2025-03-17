package com.Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ITestListenerClass.class)
public class TestParallel1 {
	@Test
	public void Sample1() {
		System.out.println("i'm inside sample1");	
	}
	@Test
	public void Sample2() {
		System.out.println("i'm inside sample2");
		Assert.assertTrue(false);
		}
	@Test(timeOut = 1000)
	public void Sample3() throws Exception {
		Thread.sleep(2000);
		System.out.println("i'm inside sample3");
	}
	@Test(dependsOnMethods = "Sample3")
	public void Sample4() {
		System.out.println("i'm inside sample4");
	}
}
