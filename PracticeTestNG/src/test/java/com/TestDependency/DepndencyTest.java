package com.TestDependency;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DepndencyTest {
	static String trackingNumber= null;
	@Ignore
	@Test()
	public void CreateShipment() {
		System.out.println(5/0);
		System.out.println("CreateShipment");
		trackingNumber= "ABC12@H";
	}
	
	@Test(dependsOnMethods = {"CreateShipment"}
)
	public void TrackShipment() throws Exception {
		if (trackingNumber!=null) {
			System.out.println("TrackShipment");
		}
		else 
			throw new Exception("Invalid Trakingnumber");
		
	}
	@Test(dependsOnMethods = {"CreateShipment","TrackShipment"})
	public void CancelShipment() throws Exception {
		if (trackingNumber!=null) {
			System.out.println("CancelShipment");
		}
		else 
			throw new Exception("Invalid Trakingnumber");
	}

}
