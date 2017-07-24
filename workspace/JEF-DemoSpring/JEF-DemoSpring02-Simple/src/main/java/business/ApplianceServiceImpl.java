package business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplianceServiceImpl implements ApplianceService {

	private static final Logger logger = LoggerFactory.getLogger(ApplianceServiceImpl.class);

	private ApplianceDao applianceDao;

	private String attrString;

	@Override
	public void loadAndPrintAllAppliances() {
		logger.debug("IN");

		logger.debug("attrString={}", attrString);

		applianceDao.findAll();

	}

	public void setApplianceDao(ApplianceDao _applianceDao) {
		applianceDao = _applianceDao;
	}

	public void setAttrString(String attrString) {
		this.attrString = attrString;
	}

}
