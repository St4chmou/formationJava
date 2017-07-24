package jef.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest2 {

	/** Logger Slf4j. */
	private static final Logger LOG = LoggerFactory.getLogger(Slf4jTest2.class);

	@Test
	public void test() {
		LOG.trace("debug line2");
		LOG.debug("debug line2");
		LOG.info("info line2");
		LOG.warn("warn line2");

		String param1 = "param1";
		String param2 = "param2";
		LOG.error("error line2 {} {}", param1, param2);

		for (int i = 0; i < 1000; i++) {
			LOG.error("error line");
		}
	}

}
