package com.ParallelExection;

import org.testng.annotations.Test;

public class TestParallel4{
	@Test
	public void Sample13() {
		System.out.println("TestParallel4>Sample13 >> thread count::"+ Thread.currentThread().threadId());
		
	}

	@Test
	public void Sample14() {
		System.out.println("TestParallel4>Sample14 >> thread count::"+ Thread.currentThread().threadId());
	}
	@Test
	public void Sample15() {
		System.out.println("TestParallel4>Sample15 >> thread count::"+ Thread.currentThread().threadId());
	}
	@Test
	public void Sample16() {
		System.out.println("TestParallel4>Sample16 >> thread count::"+ Thread.currentThread().threadId());
	}
}
