package jef.part3;

import java.util.ArrayList;
import java.util.Collection;

public class RadiatorTest {

	public static void main(String[] args) {
		test01Radiator();
		test02RegulatedRadiator();
		test03Polymorphism();
	}

	private static void test01Radiator() {
		System.out.println("\n************************\ntestRadiator\n****************");

		Radiator r = new Radiator(100, "SopraSteria", "TheBestOne");

		// Start and power is 100
		r.start();
		System.out.println("On=" + r.isOn() + " and consumption=" + r.getConsumption());

		// Stop and power is 0
		r.stop();
		System.out.println("On=" + r.isOn() + " and consumption=" + r.getConsumption());

	}

	private static void test02RegulatedRadiator() {
		System.out.println("\n************************\ntestRegulatedRadiator\n****************");

		RegulatedRadiator rr = new RegulatedRadiator(5, 100, "SopraSteria", "TheBestRegulated");

		// Start and power is 50
		rr.start();
		System.out.println("On=" + rr.isOn() + " and consumption=" + rr.getConsumption());

		// Stop and power is 0
		rr.stop();
		System.out.println("On=" + rr.isOn() + " and consumption=" + rr.getConsumption());

		// Start at 10 and power is 100
		rr.start();
		rr.setLevel(10);
		System.out.println("On=" + rr.isOn() + " and consumption=" + rr.getConsumption());

		// Test bad level value
		try {
			rr.setLevel(11);
			System.err.println("FAIL!! Exception must be thrown");
		} catch (IllegalArgumentException e) {
			System.out.println("OK!! Exception is " + e.getMessage());
		}
	}

	private static void test03Polymorphism() {
		System.out.println("\n************************\ntestPolymorphism\n****************");

		Collection<Radiator> radiators = new ArrayList<>();
		radiators.add(new Radiator(100, "SopraSteria", "TheBestOne"));
		radiators.add(new Radiator(100, "SopraSteria", "TheSecond"));
		radiators.add(new RegulatedRadiator(5, 200, "SopraSteria", "TheBestRegulated200"));
		radiators.add(new RegulatedRadiator(10, 100, "SopraSteria", "TheBestRegulated100"));

		for (Radiator r : radiators) {
			r.start();
			System.out.println("For model " + r.getModel() + ", consumption=" + r.getConsumption());
		}

	}
}
