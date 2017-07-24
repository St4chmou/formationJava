package jef;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomeManagerWithoutInterfaceTest {

	private HomeManagerWithoutInterface homeManager;

	@Before
	public void beforeEachMethod() {
		homeManager = new HomeManagerWithoutInterface();
		homeManager.add(new Light("Kitchen"));
		homeManager.add(new Light("Bedroom"));
		homeManager.add(new Light("WC"));
		homeManager.add(new Radiator(100, "SopraSteria", "TheBestOne"));
		homeManager.add(new Radiator(80, "SopraSteria", "TheSecond"));
		homeManager.add(new RegulatedRadiator(5, 200, "SopraSteria", "TheBestRegulated"));
	}

	@Test
	public void testHomeManagerData() {
		Assert.assertEquals(3, homeManager.getLights().size());
		Assert.assertEquals(3, homeManager.getRadiators().size());
	}

	@Test
	public void testStartAll() {

		// Arrange : Check all is OFF by default
		for (Light l : homeManager.getLights()) {
			Assert.assertEquals(false, l.isAlight());
		}
		for (Radiator r : homeManager.getRadiators()) {
			Assert.assertEquals(false, r.isOn());
		}

		// Act
		homeManager.startAll();

		// Assert
		for (Light l : homeManager.getLights()) {
			Assert.assertEquals(true, l.isAlight());
		}
		for (Radiator r : homeManager.getRadiators()) {
			Assert.assertEquals(true, r.isOn());
		}
	}

	@Test
	public void testStopAll() {

		// Arrange : Check all is OFF by default
		for (Light l : homeManager.getLights()) {
			l.start();
			Assert.assertEquals(true, l.isAlight());
		}
		for (Radiator r : homeManager.getRadiators()) {
			r.start();
			Assert.assertEquals(true, r.isOn());
		}

		// Act
		homeManager.stopAll();

		// Assert
		for (Light l : homeManager.getLights()) {
			Assert.assertEquals(false, l.isAlight());
		}
		for (Radiator r : homeManager.getRadiators()) {
			Assert.assertEquals(false, r.isOn());
		}
	}
}
