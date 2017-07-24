package business;

import java.util.List;

import business.model.Appliance;

public interface ApplianceDao {

	List<Appliance> findAll();

	void save(Appliance _appliance);

}
