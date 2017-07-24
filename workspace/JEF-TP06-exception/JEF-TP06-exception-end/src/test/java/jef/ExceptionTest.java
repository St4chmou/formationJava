package jef;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.catchexception.CatchException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExceptionTest {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionTest.class);

	@Before
	public void before() {
		LOG.info("----------------------------------");
	}

	@Test
	public void test01GoodUrl() throws MalformedURLException {
		URL goodUrl = new URL("http://www.google.com");
		LOG.info(goodUrl.toString());
	}

	@Test(expected = MalformedURLException.class)
	public void test02BadUrl() throws MalformedURLException {
		new URL("aze://www.google.com");
	}

	@Test
	public void test03BadUrlEncapsulatedInCheckedException() throws MyCheckedException {
		// Arrange
		ExceptionLauncher el = new ExceptionLauncher();

		// Act
		CatchException.catchException(el).createUrlAndThrowMyCheckedException();

		// Assert
		Assert.assertNotNull(CatchException.caughtException());
		Assert.assertEquals("URL_ERROR", CatchException.caughtException().getMessage());
	}

	@Test
	public void test04BadUrlEncapsulatedInTworkException() {
		// Arrange
		ExceptionLauncher el = new ExceptionLauncher();

		// Act
		CatchException.catchException(el).createUrlAndThrowMyTworkException();

		// Assert
		Assert.assertNotNull(CatchException.caughtException());
		Assert.assertEquals("Error during URL creation", CatchException.caughtException().getMessage());
	}
}
