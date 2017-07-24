package business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplianceServiceImpl implements ApplianceService {

	@Autowired
	private ApplianceDao applianceDao;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void loadAndPrintAllAppliances() {
		logger.debug("IN");
		applianceDao.findAll();
	}

}
