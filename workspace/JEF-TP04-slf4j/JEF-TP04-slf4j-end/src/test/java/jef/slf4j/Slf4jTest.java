package jef.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

	/** Logger Slf4j. */
	private static final Logger LOG = LoggerFactory.getLogger(Slf4jTest.class);

	@Test
	public void test() {
		LOG.trace("debug line");
		LOG.debug("debug line");
		LOG.info("info line");
		LOG.warn("warn line");

		String param1 = "param1";
		String param2 = "param2";
		LOG.error("error line {} {}", param1, param2);
	}

}
