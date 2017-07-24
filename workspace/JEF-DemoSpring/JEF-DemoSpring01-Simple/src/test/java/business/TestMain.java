package business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.model.Appliance;

public class TestMain {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(TestMain.class);

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");) {
			ApplianceDao applianceDao = context.getBean(ApplianceDao.class);

			Appliance appliance = new Appliance("Philips", "A234", 22, true, 10, true);

			applianceDao.save(appliance);

		} catch (Exception e) {
			logger.error("exception occured :", e);
		}

		logger.info("finished !");
	}
}
