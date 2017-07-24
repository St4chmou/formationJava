package appliance.persistence;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import appliance.persistence.dao.ApplianceDao;
import appliance.persistence.model.Appliance;

/**
 * Test JUNIT AVEC intégration avec Spring (en utilisant @RunWith).
 * 
 * Du coup, la création du context et la récupération du bean se font
 * automatiquement avec l'annotation ContextConfiguration.
 * 
 * Autre avantage de l'intégration JUnit et Spring : le context se ferme tout
 * seul.
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
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MonTest {

	private static final Logger LOG = LoggerFactory.getLogger(MonTest.class);

	@Autowired
	private ApplianceDao applianceDao;

	@Before
	public void before() {
		LOG.info("***********************************");
	}

	@Test
	public void test01FindAll() {

		// Act
		List<Appliance> all = applianceDao.findAll();

		// Assert
		Assert.assertEquals(0, all.size());
	}

	@Test
	public void test02Save() {
		//
		Appliance appliance = new Appliance("Philips", "A234", 22, true, 10, true);

		//
		applianceDao.save(appliance);

		//
		Assert.assertEquals(1, applianceDao.findAll().size());
	}

	@Test
	public void test03FindByBrand() {
		//
		//
		List<Appliance> byBrand = applianceDao.findByBrand("Philips");

		//
		Assert.assertEquals(1, byBrand.size());
		Assert.assertEquals("Philips", byBrand.get(0).getBrand());
	}
}
