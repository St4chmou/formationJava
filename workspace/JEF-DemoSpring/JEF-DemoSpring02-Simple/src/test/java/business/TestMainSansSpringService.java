package business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMainSansSpringService {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(TestMainSansSpringService.class);

		try {

			// i play the role of a FACTORY
			ApplianceServiceImpl applianceServiceImpl = new ApplianceServiceImpl();
			ApplianceDaoImpl applianceDaoImpl = new ApplianceDaoImpl();
			applianceServiceImpl.setApplianceDao(applianceDaoImpl);

			// service on :
			applianceServiceImpl.loadAndPrintAllAppliances();

		} catch (Exception e) {
			logger.error("exception occured :", e);
		}
		logger.info("finished !");
	}
}
