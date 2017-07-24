package appliance.persistence.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import appliance.persistence.model.Appliance;

public class ApplianceDaoTestWithJunitWithoutSpringIntegration {

	static ApplianceDao applianceDao;
	static ClassPathXmlApplicationContext context;
	static boolean firstMethodCall;
	static Logger logger = LoggerFactory.getLogger(ApplianceDaoTestWithJunitWithoutSpringIntegration.class);

	@AfterClass
	public static void afterClass() {
		context.close();
	}

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext("classpath:applicationContext-test.xml");
		applianceDao = context.getBean(ApplianceDao.class);
	}

	@Test
	public void save() {
		Appliance appliance = new Appliance("PhilipsGradSecu", "ALL234", 22, true, 10, true);
		applianceDao.save(appliance);
		List<Appliance> list = applianceDao.findAll();
		org.junit.Assert.assertTrue(list.size() == 1);
	}
}
