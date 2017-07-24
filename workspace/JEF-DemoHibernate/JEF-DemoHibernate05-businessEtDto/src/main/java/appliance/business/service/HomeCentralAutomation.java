package appliance.business.service;

import java.util.List;

import appliance.business.model.MegaControllable;

public interface HomeCentralAutomation {

	void addElectricalAppliance(MegaControllable _controllable);

	void decrementEveryAppliance();

	public List<MegaControllable> getControllables();

	void incrementEveryAppliance();

	/**
	 * method to reload Appliances from the Database. All Appliances present in
	 * the DB are loaded.
	 */
	void loadAllElectricalAppliances();

	int reportTotalCosumption();

	/**
	 * method to save all ElectricalAppliances to the DB .All Appliances present
	 * in the DB are removed.
	 */
	void saveAllElectricalAppliances();

	void showAll();

	/**
	 * invoke start() on all appliances, even the Secured ones.
	 */
	void startAll();

	/**
	 * all appliances should be started, even secured ones, after having set the
	 * security off
	 */
	void startAllSecurely();

	void stopAll();

}
