package jef.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {

	/** Logger Log4j. */
	private static final Logger LOG = Logger.getLogger(Log4jTest.class);

	@Test
	public void test() {
		LOG.trace("debug line");
		LOG.debug("debug line");
		LOG.info("info line");
		LOG.warn("warn line");

		String param1 = "param1";
		String param2 = "param2";
		LOG.error("error line " + param1 + " " + param2);
	}

}
