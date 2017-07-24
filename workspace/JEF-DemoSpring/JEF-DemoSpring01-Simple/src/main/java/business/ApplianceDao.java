package business;

import java.util.List;

import business.model.Appliance;

public interface ApplianceDao {

	void save(Appliance _appliance);

	List<Appliance> findAll();

}
