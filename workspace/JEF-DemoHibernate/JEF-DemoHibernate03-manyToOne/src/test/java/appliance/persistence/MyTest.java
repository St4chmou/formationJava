package appliance.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import appliance.persistence.dao.ApplianceDao;
import appliance.persistence.model.Appliance;
import appliance.persistence.model.Brand;

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

	@org.testng.annotations.Test
	public void test01Save() {

		// Arrange
		Brand brand = new Brand("Philips");
		Appliance appliance = new Appliance("A234", 22, true, 10, true);
		appliance.setBrand(brand);

		int nbStart = applianceDao.findAll().size();

		// Act
		applianceDao.save(brand);
		applianceDao.save(appliance);

		// Assert
		List<Appliance> all = applianceDao.findAll();
		Assert.assertEquals(all.size(), nbStart + 1);
	}
}
