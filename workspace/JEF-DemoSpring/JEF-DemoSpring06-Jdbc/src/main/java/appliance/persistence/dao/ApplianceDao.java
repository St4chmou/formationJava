package appliance.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import appliance.persistence.model.Appliance;

public interface ApplianceDao {

	List<Appliance> findAll() throws SQLException;

	List<Appliance> findByBrand(String _brand) throws SQLException;

	void save(Appliance _appliance) throws SQLException;

}
