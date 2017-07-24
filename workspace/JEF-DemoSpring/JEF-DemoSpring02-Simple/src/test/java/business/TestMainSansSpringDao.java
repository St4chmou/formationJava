package business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMainSansSpringDao {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(TestMainSansSpringDao.class);

		try {

			ApplianceDao applianceDao = new ApplianceDaoImpl();
			applianceDao.findAll();

		} catch (Exception e) {
			logger.error("exception occured :", e);
		}
		logger.info("finished !");
	}
}
