package appliance.persistence.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import appliance.persistence.model.Appliance;

public class ApplianceDaoTestWithMain {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(ApplianceDaoTestWithMain.class);

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");) {
			ApplianceDao applianceDao = context.getBean(ApplianceDao.class);

			Appliance appliance = new Appliance("PhilipsGradSecu", "ALL234", 22, true, 10, true);
			applianceDao.save(appliance);

			Appliance appliance2 = new Appliance("PhilipsNOGradSecu", "Secu56", 60, false, 0, true);
			applianceDao.save(appliance2);

			Appliance appliance3 = new Appliance("PhilipsBasic", "Basic333", 22, false, 0, false);
			applianceDao.save(appliance3);

			List<Appliance> list = applianceDao.findByBrand("PhilipsBasic");
			logger.info(list.toString());

		} catch (Exception e) {
			logger.error("exception occured :", e);
		}
		logger.info("finished !");
	}
}
