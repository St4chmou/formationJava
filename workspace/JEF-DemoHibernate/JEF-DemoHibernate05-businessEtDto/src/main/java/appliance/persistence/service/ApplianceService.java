package appliance.persistence.service;

import java.util.List;

import appliance.business.dto.ApplianceDto;

public interface ApplianceService {

	/**
	 * transactionnal method to reload AppliancesDtos from the Database. All
	 * Appliances present in the DB are loaded.
	 */
	public List<ApplianceDto> loadAllAppliances();

	/**
	 * transactionnal method to save all AppliancesDto to the DB .All Appliances
	 * present in the DB are removed.
	 */
	void saveAllAppliances(List<ApplianceDto> _applianceDtos);

}
