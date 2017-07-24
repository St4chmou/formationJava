package jef;

import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionLauncher {

	public void createUrlAndThrowMyCheckedException() throws MyCheckedException {
		try {
			new URL("aze://www.google.com");
		} catch (MalformedURLException e) {
			throw new MyCheckedException(MyCheckedException.URL_ERROR, e);
		}
	}

	public void createUrlAndThrowMyTworkException() {
		try {
			new URL("aze://www.google.com");
		} catch (MalformedURLException e) {
			throw new MyTworkException(MyTworkException.URL_ERROR, e);
		}
	}
}
