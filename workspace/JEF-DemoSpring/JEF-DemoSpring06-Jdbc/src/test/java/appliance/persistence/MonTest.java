package appliance.persistence;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import appliance.persistence.dao.ApplianceDao;
import appliance.persistence.model.Appliance;

/**
 * Test JUNIT sans intégration avec Spring. Du coup, la création du context et
 * la récupération du bean se font à la main.
 * 
 * N'oubliez pas de fermer le context.
 * 
 * Vive JUnit et son intégration dans les outils (comme Eclise, Jenkins, Sonar,
 * ...). Il permet de voir les tests en échec et de coder les tests plus
 * simplement.
 * 
 * L'organisation de code Arrange/Act/Assert est une bonne pratique de dev !
 * 
 * Pour en savoir plus, venez à la formation Java Unit Testing
 *
 *
 * Ce test echoue à partir du deuxième appel car il ne nettoie pas ses données
 * dernière lui. Pour les stratégies de test, venez à la formation Java Unit
 * Testing
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MonTest {

	private static ApplianceDao applianceDao;
	private static ClassPathXmlApplicationContext context;

	private static final Logger LOG = LoggerFactory.getLogger(MonTest.class);

	@AfterClass
	public static void afterClass() {
		context.close();
	}

	@BeforeClass
	public static void beforeClass() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		applianceDao = context.getBean(ApplianceDao.class);
	}

	@Before
	public void before() {
		LOG.info("***********************************");
	}

	@Test
	public void test01FindAll() throws SQLException {

		// Act
		List<Appliance> all = applianceDao.findAll();

		// Assert
		Assert.assertEquals(0, all.size());
	}

	@Test
	public void test02Save() throws SQLException {
		// Arrange
		Appliance appliance = new Appliance("Philips", "A234", 22, true, 10, true);

		// Act
		applianceDao.save(appliance);

		// Assert
		Assert.assertEquals(1, applianceDao.findAll().size());
	}

	@Test
	public void test03FindByBrand() throws SQLException {
		//

		//
		List<Appliance> byBrand = applianceDao.findByBrand("Philips");

		//
		Assert.assertEquals(1, byBrand.size());
		Assert.assertEquals("Philips", byBrand.get(0).getBrand());
	}
}
