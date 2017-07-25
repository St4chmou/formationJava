package jef;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class BikeTest {

	private void changeObject(Bike aBike) {
		aBike.setColor("blue");
	}

	private void changeValuePrimitiveString(String color) {
		color = "blue";
	}

	@Test
	public void test() {

		// Create an object
		Bike myBike = new Bike("red", "VTT");

		// Print it to the console
		Assert.assertEquals("red", myBike.getColor());

		// Pass a primitive to a method, no change
		changeValuePrimitiveString(myBike.getColor());
		Assert.assertEquals("red", myBike.getColor());

		// Pass an object to a method, changes can be made
		changeObject(myBike);
		Assert.assertEquals("blue", myBike.getColor());

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
