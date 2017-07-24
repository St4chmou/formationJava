package appliance.persistence.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import appliance.persistence.model.Appliance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class ApplianceDaoTestWithJunitAndSpringIntegration {

	@Autowired
	private ApplianceDao applianceDao;

	@Test
	public void save() {
		Appliance appliance = new Appliance("PhilipsGradSecu", "ALL234", 22, true, 10, true);
		applianceDao.save(appliance);

		List<Appliance> list = applianceDao.findAll();

		org.junit.Assert.assertTrue(list.size() == 1);
	}
}