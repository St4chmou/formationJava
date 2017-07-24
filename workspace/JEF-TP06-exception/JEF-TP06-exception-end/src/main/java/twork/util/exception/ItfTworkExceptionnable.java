package twork.util.exception;

import java.util.Locale;

public interface ItfTworkExceptionnable {

	String getKey();

	int getNumero();

	Object[] getParams();

	boolean needNumeroInMessage();

	void setLocale(Locale _locale);

	String getMessage();

	String getStackTraceAsString();
}
