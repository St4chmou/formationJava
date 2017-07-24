package business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(TestMain.class);

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");) {
			ApplianceService applianceService = context.getBean(ApplianceService.class);

			applianceService.loadAndPrintAllAppliances();

		} catch (Exception e) {
			logger.error("exception occured :", e);
		}

		logger.info("finished !");
	}
}
