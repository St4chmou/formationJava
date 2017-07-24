package jef.part1;

public class BikeTest {

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

	}

}
