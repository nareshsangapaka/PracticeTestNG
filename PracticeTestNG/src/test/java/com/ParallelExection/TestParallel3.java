package com.ParallelExection;

import org.testng.annotations.Test;

public class TestParallel3 {
	@Test
	public void Sample9() {
		System.out.println("TestParallel3>Sample9 >> thread count::"+ Thread.currentThread().threadId());
	}

	@Test
	public void Sample10() {
		System.out.println("TestParallel3>Sample10 >> thread count::"+ Thread.currentThread().threadId());
	}
	@Test
	public void Sample11() {
		System.out.println("TestParallel3>Sample11 >> thread count::"+ Thread.currentThread().threadId());
	}
	@Test
	public void Sample12() {
		System.out.println("TestParallel3>Sample12 >> thread count::"+ Thread.currentThread().threadId());
	}
}
