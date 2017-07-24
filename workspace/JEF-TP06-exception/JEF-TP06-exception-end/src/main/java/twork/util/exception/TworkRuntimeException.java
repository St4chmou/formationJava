package twork.util.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Super class of all standard Exceptions. Usage : subclass this Exception in your package, for
 * example mypack.Component1Exception, and create an according properties file in the same package
 * named : Component1Exception.properties. This properties file will contain the
 * Component1Exception's messages referenced by key. Check the example in package
 * "twork.util.exception.test" .
 * 
 * @author Gauthier Peel
 */
public class TworkRuntimeException extends RuntimeException implements ItfTworkExceptionnable {

	private static final long serialVersionUID = 996648040922402075L;
	public Logger logger = LoggerFactory.getLogger(getClass());

	private static Locale s_defaultLocale = new Locale("fr");
	private static int s_numero = 0;

	private int m_numero;
	protected String m_key;
	private Object[] m_params;
	private Locale m_locale;

	public static void setDefaultLocale(Locale _locale) {
		s_defaultLocale = _locale;
	}

	protected ResourceBundle getResourceBundle(Locale _locale) {
		ResourceBundle rb = null;
		try {
			rb = ResourceBundle.getBundle(this.getClass().getName(), _locale);
		} catch (MissingResourceException e) {
			// this is second hand pb, just log it
			logger.warn("Bundle " + this.getClass().getName() + " not Found", e.getMessage());
		}
		return rb;

	}

	/*
	 * @see sopra.twork.exception.ItfTworkExceptionnable#needNumeroInMessage()
	 */
	@Override
	public boolean needNumeroInMessage() {
		return true;
	}

	@Override
	public String getStackTraceAsString() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		this.printStackTrace(pw);
		return sw.getBuffer().toString();
	}

	protected String getMessageFromBundle(String _key, Object[] _objects) {
		String strBrute = getResourceBundle(getLocale()).getString(_key);
		strBrute = StringUtils.trim(strBrute);
		String str = MessageFormat.format(strBrute, _objects);
		return str;
	}

	protected String getMessageFromBundle(String _key, Object[] _objects, Locale _locale) {

		ResourceBundle rb = getResourceBundle(_locale);
		if (rb == null) {
			return _key;
		}
		String strBrute = "";
		try {
			strBrute = rb.getString(_key);
		} catch (MissingResourceException e) {
			strBrute = _key;
		}
		strBrute = StringUtils.trim(strBrute);
		String str = strBrute;
		if (strBrute != null)
			str = MessageFormat.format(strBrute, _objects);
		return str;
	}

	private Locale getLocale() {
		if (m_locale != null) {
			return m_locale;
		} else {
			return s_defaultLocale;
		}
	}

	@Override
	public int getNumero() {
		return m_numero;
	}

	@Override
	public String getKey() {
		return m_key;
	}

	@Override
	public Object[] getParams() {
		return m_params;
	}

	protected void setParams(Object... _params) {
		m_params = _params;
	}

	@Override
	public void setLocale(Locale _locale) {
		m_locale = _locale;
	}

	/**
	 * Enables to build an exception with no message (not advisable, in general)
	 */
	public TworkRuntimeException() {
		super();
	}

	/**
	 * It is the standard getMessage(), accessed through getStackTrace() by example
	 */
	@Override
	public String getMessage() {
		return getMessage(getLocale());
	}

	public String getMessage(Locale _locale) {
		if (m_key != null) {
			return getMessageFromBundle(getKey(), getParams(), _locale);
		} else {
			Throwable i_t = getCause();
			if ((i_t != null) && (i_t != this)) {
				String msg = extractMessage(i_t);
				if (msg == null) {
					return " caused by " + this.getClass().getName() + ": (no detail)";
				} else {
					return msg;
				}
			} else {
				return " caused by " + this.getClass().getName() + ": (no detail)";
			}
		}
	}

	protected String extractMessage(Throwable i_t) {
		String msg = i_t.getMessage();
		if (msg != null) {
			return msg;
		} else if (i_t.getCause() == null) {
			return null;
		} else if ((i_t.getCause() != null) && (!i_t.getCause().equals(i_t))) {
			return extractMessage(i_t.getCause());
		} else {
			return null;
		}
	}

	public TworkRuntimeException(String _key, Object... _tabParams) {
		super(_key);
		m_numero = createNumber();
		m_key = _key;
		m_params = _tabParams;
	}

	public TworkRuntimeException(Throwable cause, String _key, Object... _tabParams) {
		super(_key, cause);
		m_numero = createNumber();
		m_key = _key;
		m_params = _tabParams;
	}

	/**
	 * in case, no key has been defined for this exception (ie no message key in a bundle), the
	 * message will be extracted from e.getCause().getMessage().
	 * 
	 * @param cause
	 */
	public TworkRuntimeException(Throwable cause) {
		super(cause);
		m_numero = createNumber();
	}

	// public String toString() {
	// return getMessage();
	// }
	private synchronized int createNumber() {
		return ++s_numero;
	}
}