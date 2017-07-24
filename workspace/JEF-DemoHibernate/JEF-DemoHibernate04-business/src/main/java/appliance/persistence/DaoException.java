package appliance.persistence;

import twork.util.exception.TworkRuntimeException;

public class DaoException extends TworkRuntimeException {
	private static final long serialVersionUID = -7383306250478799310L;

	public DaoException() {
	}

	public DaoException(String _key, Object... _tabParams) {
		super(_key, _tabParams);
	}

	public DaoException(Throwable _cause) {
		super(_cause);
	}

	public DaoException(Throwable _cause, String _key, Object... _tabParams) {
		super(_cause, _key, _tabParams);
	}

}
