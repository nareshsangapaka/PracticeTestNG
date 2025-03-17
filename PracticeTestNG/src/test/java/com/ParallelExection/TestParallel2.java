package com.ParallelExection;

import org.testng.annotations.Test;

public class TestParallel2 {
	@Test
	public void Sample5() {
		System.out.println("TestParallel2>Sample5 >> thread count::"+ Thread.currentThread().threadId());
	}

	@Test
	public void Sample6() {
		System.out.println("TestParallel2>Sample6 >> thread count::"+ Thread.currentThread().threadId());
	}
	@Test
	public void Sample7() {
		System.out.println("TestParallel2>Sample7 >> thread count::"+ Thread.currentThread().threadId());
	}
	@Test
	public void Sample8() {
		System.out.println("TestParallel2>Sample8 >> thread count::"+ Thread.currentThread().threadId());
	}
}
