package jef;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BikeTest {

	private static Logger logger = LoggerFactory.getLogger(BikeTest.class);
	
	private static void changeObject(Bike aBike) {
		aBike.setColor("blue");
	}

	private static void changeValuePrimitiveString(String color) {
		color = "blue";
	}

	public static void main(String[] args) {

		// Create an object
		Bike myBike = new Bike("red", "VTT");

		// Print it to the console
		System.out.println(myBike);

		// Pass a primitive to a method, no change
		changeValuePrimitiveString(myBike.getColor());
		System.out.println("after changeValuePrimitiveString : " + myBike);

		// Pass an object to a method, changes can be made
		changeObject(myBike);
		System.out.println("after changeObject : " + myBike);

		logger.debug("test_debug");
	}

	@Test
	public void testChangeValuePrimitiveString() {
		Bike myBike = new Bike("red", "VTT");
		changeValuePrimitiveString(myBike.getColor());
		Assertions.assertThat(myBike.getColor()).isEqualTo("red");
	}

	@Test
	public void testChangeObject() {
		Bike myBike = new Bike("red", "VTT");
		changeObject(myBike);
		Assertions.assertThat(myBike.getColor()).isEqualTo("blue");
	}

}
