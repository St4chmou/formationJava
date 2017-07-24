package appliance.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import appliance.persistence.dao.ApplianceDao;
import appliance.persistence.model.Appliance;

/**
 * Simple classe Java avec une méthode main.
 * 
 * Un peu pénible de coder un test ainsi car il faut regarder aux logs pour
 * savoir si le test est bon :(
 */
public class TestMain {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(TestMain.class);

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");) {
			ApplianceDao applianceDao = context.getBean(ApplianceDao.class);

			// List all on start
			List<Appliance> all = applianceDao.findAll();
			logger.info("Starting with {}", all);

			// Insert
			Appliance appliance = new Appliance("Philips", "A234", 22, true, 10, true);
			applianceDao.save(appliance);

			// List by brand
			List<Appliance> byBrand = applianceDao.findByBrand("Philips");
			logger.info("ByBrand = {}", byBrand);

			// List all at the end
			all = applianceDao.findAll();
			logger.info("End with {}", all);

		} catch (Exception e) {
			logger.error("exception occured :", e);
		}

		logger.info("finished !");
	}
}
