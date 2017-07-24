package jef;

import twork.util.exception.TworkRuntimeException;

public class MyTworkException extends TworkRuntimeException {

	private static final long serialVersionUID = 1L;

	public static final String URL_ERROR = "URL_ERROR";

	public MyTworkException(String _key, Object... _tabParams) {
		super(_key, _tabParams);
	}

	public MyTworkException(Throwable cause) {
		super(cause);
	}

	public MyTworkException(Throwable cause, String _key, Object... _tabParams) {
		super(cause, _key, _tabParams);
	}
}
