package com.PracticeTestNG;

import org.testng.annotations.Test;

public class FlightBookingPriorityTest {

	@Test(priority=1)
	public void SignUp() {
		System.out.println("SignUp");
		
	}
	@Test(priority=2)
	public void Login() {
		System.out.println("Login");
	}
	@Test(priority=3)
	public void SearchForTheFlight() {
		System.out.println("SearchForTheFlight");
	}
	@Test(priority=4)
	public void BookTheFlight() {
		System.out.println("BookTheFlight");
	}
	@Test(priority=5)
	public void SaveTheTiket() {
		System.out.println("SaveTheTiket");
		
	}
	@Test(priority=6)
	public void LogOut() {
		System.out.println("LogOut");
	}
}
