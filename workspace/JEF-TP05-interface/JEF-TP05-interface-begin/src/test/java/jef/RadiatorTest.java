package jef;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.catchexception.CatchException;

public class RadiatorTest {

	private static final Logger LOG = LoggerFactory.getLogger(RadiatorTest.class);

	@Test
	public void test01Radiator() {

		Radiator r = new Radiator(100, "SopraSteria", "TheBestOne");

		// Start and power is 100
		r.start();
		Assert.assertEquals(true, r.isOn());
		Assert.assertEquals(100, r.getConsumption());
		LOG.info("On={} and consumption={}", r.isOn(), r.getConsumption());

		// Stop and power is 0
		r.stop();
		Assert.assertEquals(false, r.isOn());
		Assert.assertEquals(0, r.getConsumption());
		LOG.info("On={} and consumption={}", r.isOn(), r.getConsumption());

	}

	@Test
	public void test02RegulatedRadiator() {

		RegulatedRadiator rr = new RegulatedRadiator(5, 100, "SopraSteria", "TheBestRegulated");

		// Start and power is 50
		rr.start();
		Assert.assertEquals(true, rr.isOn());
		Assert.assertEquals(50, rr.getConsumption());
		LOG.info("On={} and consumption={}", rr.isOn(), rr.getConsumption());

		// Stop and power is 0
		rr.stop();
		Assert.assertEquals(false, rr.isOn());
		Assert.assertEquals(0, rr.getConsumption());
		LOG.info("On={} and consumption={}", rr.isOn(), rr.getConsumption());

		// Start at 10 and power is 100
		rr.start();
		rr.setLevel(10);
		Assert.assertEquals(true, rr.isOn());
		Assert.assertEquals(100, rr.getConsumption());
		LOG.info("On={} and consumption={}", rr.isOn(), rr.getConsumption());

		// Test bad level value
		CatchException.catchException(rr).setLevel(11);
		Assert.assertEquals(IllegalArgumentException.class, CatchException.caughtException().getClass());
		LOG.info("Exception is {}", CatchException.caughtException().getMessage());
	}

	@Test
	public void test03Polymorphism() {

		Collection<Radiator> radiators = new ArrayList<>();
		radiators.add(new Radiator(100, "SopraSteria", "TheBestOne"));
		radiators.add(new Radiator(100, "SopraSteria", "TheSecond"));
		radiators.add(new RegulatedRadiator(5, 200, "SopraSteria", "TheBestRegulated200"));
		radiators.add(new RegulatedRadiator(10, 100, "SopraSteria", "TheBestRegulated100"));

		for (Radiator r : radiators) {
			r.start();
			Assert.assertEquals(100, r.getConsumption());
			LOG.info("For model " + r.getModel() + ", consumption=" + r.getConsumption());
		}

	}
}
