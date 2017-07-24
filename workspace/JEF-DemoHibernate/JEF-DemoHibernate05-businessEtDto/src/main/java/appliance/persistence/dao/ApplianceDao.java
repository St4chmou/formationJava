package appliance.persistence.dao;

import java.util.List;

import appliance.business.dto.ApplianceDto;
import appliance.persistence.model.Appliance;

public interface ApplianceDao {

	List<ApplianceDto> finAllDto();

	List<Appliance> findAll();

	List<Appliance> findByBrand(String _brand);

	void removeAllAppliances();

	void save(Appliance _appliance);

}
