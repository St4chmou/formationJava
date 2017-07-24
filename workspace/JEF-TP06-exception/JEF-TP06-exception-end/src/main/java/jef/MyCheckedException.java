package jef;

public class MyCheckedException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String URL_ERROR = "URL_ERROR";

	public MyCheckedException(String message) {
		super(message);
	}

	public MyCheckedException(String message, Throwable nestedException) {
		super(message, nestedException);
	}
}
