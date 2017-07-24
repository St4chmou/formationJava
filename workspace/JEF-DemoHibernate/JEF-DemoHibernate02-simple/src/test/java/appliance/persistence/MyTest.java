package appliance.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import appliance.persistence.dao.ApplianceDao;
import appliance.persistence.model.Appliance;

/**
 * Classe de test avec TestNG.
 * 
 * Pour l'exécuter dans Eclipse, il faut le plugin Testng4Eclipse (à télécharger
 * dans le MarketPlace).
 * 
 * L'intégration avec Spring se fait par héritage
 *
 */
@ContextConfiguration(locations = "/applicationContext.xml")
public class MyTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ApplianceDao applianceDao;

	private int nbAuDebutDuTest;

	@BeforeMethod
	public void beforeMethod() {
		nbAuDebutDuTest = applianceDao.findAll().size();
	}

	@org.testng.annotations.Test
	public void test01Save() {

		// Arrange
		Appliance appliance = new Appliance("Philips", "A234", 22, true, 10, true);

		// Act
		applianceDao.save(appliance);

		// Assert
		List<Appliance> all = applianceDao.findAll();
		Assert.assertEquals(all.size(), nbAuDebutDuTest + 1);
	}

	@org.testng.annotations.Test
	public void test02FindByBrand() {

		// Arrange
		String brand = "Philips" + (new Date()).getTime();
		Appliance appliance = new Appliance(brand, "A234", 22, true, 10, true);
		applianceDao.save(appliance);

		// Act
		List<Appliance> byBrand = applianceDao.findByBrand(brand);

		// Assert
		Assert.assertEquals(byBrand.size(), 1);
		List<Appliance> all = applianceDao.findAll();
		Assert.assertEquals(all.size(), nbAuDebutDuTest + 1);
	}

	@org.testng.annotations.Test
	public void test02FindByBrandCriteria() {

		// Arrange
		String brand = "Philips" + (new Date()).getTime();
		Appliance appliance = new Appliance(brand, "A234", 22, true, 10, true);
		applianceDao.save(appliance);

		// Act
		List<Appliance> byBrand = applianceDao.findByBrandCriteria(brand);

		// Assert
		Assert.assertEquals(byBrand.size(), 1);
		List<Appliance> all = applianceDao.findAll();
		Assert.assertEquals(all.size(), nbAuDebutDuTest + 1);
	}

	@org.testng.annotations.Test
	public void test02FindByBrandSql() {

		// Arrange
		String brand = "Philips" + (new Date()).getTime();
		Appliance appliance = new Appliance(brand, "A234", 22, true, 10, true);
		applianceDao.save(appliance);

		// Act
		List<Appliance> byBrand = applianceDao.findByBrandNativeSql(brand);

		// Assert
		Assert.assertEquals(byBrand.size(), 1);
		List<Appliance> all = applianceDao.findAll();
		Assert.assertEquals(all.size(), nbAuDebutDuTest + 1);
	}
}
