package com.ParallelExection;

import org.testng.annotations.Test;

public class TestParallel1 {
	@Test
	public void Sample1() {
		System.out.println("TestParallel1>Sample1 >> thread count::"+ Thread.currentThread().threadId());
		
	}

	@Test
	public void Sample2() {
		System.out.println("TestParallel1>Sample2 >> thread count::"+ Thread.currentThread().threadId());
	}
	@Test
	public void Sample3() {
		System.out.println("TestParallel1>Sample3 >> thread count::"+ Thread.currentThread().threadId());
	}
	@Test
	public void Sample4() {
		System.out.println("TestParallel1>Sample4 >> thread count::"+ Thread.currentThread().threadId());
	}
}
