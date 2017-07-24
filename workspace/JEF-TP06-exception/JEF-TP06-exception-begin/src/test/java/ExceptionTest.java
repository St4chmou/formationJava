
import java.net.MalformedURLException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionTest {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionTest.class);

	@Test
	public void test01GoodUrl() throws MalformedURLException {
	}

	@Test
	public void test02BadUrl() throws MalformedURLException {
	}

	@Test
	public void test03BadUrlEncapsulatedInCheckedException() {
	}

	@Test
	public void test04BadUrlEncapsulatedInTworkException() {
	}
}
