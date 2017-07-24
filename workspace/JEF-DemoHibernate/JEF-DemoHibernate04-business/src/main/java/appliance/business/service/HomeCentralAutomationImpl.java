package appliance.business.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appliance.business.model.ElectricalAppliance;
import appliance.business.model.MegaControllable;
import appliance.business.transformer.ApplianceTransformer;
import appliance.persistence.dao.ApplianceDao;
import appliance.persistence.model.Appliance;

@Service
public class HomeCentralAutomationImpl implements HomeCentralAutomation {

	@Autowired
	private ApplianceDao applianceDao;

	@Autowired
	private ApplianceTransformer applianceTransformer;

	List<MegaControllable> controllables = new ArrayList<MegaControllable>();

	@Override
	public void addElectricalAppliance(MegaControllable _controllable) {
		controllables.add(_controllable);
	}

	@Override
	public void decrementEveryAppliance() {

		for (MegaControllable controllable : controllables) {
			if (!controllable.isGraduable()) {
				controllable.decrement();
			}
		}

	}

	@Override
	public List<MegaControllable> getControllables() {
		return controllables;
	}

	@Override
	public void incrementEveryAppliance() {
		for (MegaControllable controllable : controllables) {
			if (!controllable.isGraduable()) {
				controllable.increment();
			}
		}
	}

	@Override
	public void loadAllElectricalAppliances() {
		List<Appliance> appliances = applianceDao.findAll();
		List<ElectricalAppliance> electricalAppliances = applianceTransformer.toBusinessModel(appliances);
		for (ElectricalAppliance _controllable : electricalAppliances) {
			this.addElectricalAppliance(_controllable);
		}
	}

	@Override
	public int reportTotalCosumption() {
		int totalConsumption = 0;
		for (MegaControllable controllable : controllables) {
			totalConsumption += controllable.getConsumption();
		}
		return totalConsumption;
	}

	@Override
	public void saveAllElectricalAppliances() {
		List<ElectricalAppliance> electricalAppliances = new ArrayList<ElectricalAppliance>();
		for (MegaControllable megaControllable : controllables) {
			if (megaControllable instanceof ElectricalAppliance) {
				electricalAppliances.add((ElectricalAppliance) megaControllable);
			}
		}
		List<Appliance> appliances = applianceTransformer.topersistentModel(electricalAppliances);
		this.applianceDao.saveAllAppliances(appliances);
	}

	@Override
	public void showAll() {
		System.out.println("Show notice : ");
		Iterator<MegaControllable> it = controllables.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Override
	public void startAll() {
		for (MegaControllable controllable : controllables) {
			controllable.start();
		}
	}

	@Override
	public void startAllSecurely() {
		for (MegaControllable controllable : controllables) {

			if (controllable.isOn()) {
				return;
			}
			if (controllable.isSecured()) {
				controllable.setSecurityOn();
			}
			controllable.start();

		}
	}

	@Override
	public void stopAll() {
		for (MegaControllable controllable : controllables) {
			controllable.stop();
		}
	}

}
