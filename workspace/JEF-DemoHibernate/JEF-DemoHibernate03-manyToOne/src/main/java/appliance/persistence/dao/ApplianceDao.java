package appliance.persistence.dao;

import java.util.List;

import appliance.persistence.model.Appliance;
import appliance.persistence.model.Brand;

public interface ApplianceDao {

	List<Appliance> findAll();

	List<Appliance> findByBrand(String _brand);

	void save(Appliance _appliance);

	void save(Brand _brand);

}
