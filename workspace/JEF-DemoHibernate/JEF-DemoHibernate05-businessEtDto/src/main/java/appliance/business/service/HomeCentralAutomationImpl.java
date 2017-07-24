package appliance.business.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appliance.business.dto.ApplianceDto;
import appliance.business.model.ElectricalAppliance;
import appliance.business.model.MegaControllable;
import appliance.business.transformer.ElectricalApplianceDtoTransformer;
import appliance.persistence.service.ApplianceService;

@Service
public class HomeCentralAutomationImpl implements HomeCentralAutomation {

	@Autowired
	private ApplianceService applianceService;

	List<MegaControllable> controllables = new ArrayList<MegaControllable>();

	@Autowired
	private ElectricalApplianceDtoTransformer electricalApplianceDtoTransformer;

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
		List<ApplianceDto> applianceDtos = applianceService.loadAllAppliances();
		List<ElectricalAppliance> electricalAppliances = electricalApplianceDtoTransformer
				.toBusinessModel(applianceDtos);
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
		List<ApplianceDto> applianceDtos = electricalApplianceDtoTransformer.toDto(electricalAppliances);
		this.applianceService.saveAllAppliances(applianceDtos);
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
