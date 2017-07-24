package appliance.business.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import appliance.business.model.ElectricalAppliance;
import appliance.persistence.model.Appliance;

@Component
public class ApplianceTransformer {

	public ApplianceTransformer() {
	}

	public ElectricalAppliance toBusinessModel(Appliance _appliance) {
		ElectricalAppliance electricalAppliance = null;
		if (_appliance.getGraduations() == 0) {
			electricalAppliance = new ElectricalAppliance(_appliance.getBrand(), _appliance.getModel(),
					_appliance.getPower(), _appliance.isSecured());
		} else {
			electricalAppliance = new ElectricalAppliance(_appliance.getBrand(), _appliance.getModel(),
					_appliance.getPower(), _appliance.getGraduations(), _appliance.isSecured());
		}
		return electricalAppliance;
	}

	public List<ElectricalAppliance> toBusinessModel(List<Appliance> _appliances) {
		List<ElectricalAppliance> electricalAppliances = new ArrayList<ElectricalAppliance>(_appliances.size());
		for (Appliance Appliance : _appliances) {
			electricalAppliances.add(this.toBusinessModel(Appliance));
		}
		return electricalAppliances;
	}

	public List<Appliance> topersistentModel(List<ElectricalAppliance> _electricalAppliances) {
		List<Appliance> Appliances = new ArrayList<Appliance>(_electricalAppliances.size());
		for (ElectricalAppliance electricalAppliance : _electricalAppliances) {
			Appliances.add(this.toPersistentModel(electricalAppliance));
		}
		return Appliances;
	}

	public Appliance toPersistentModel(ElectricalAppliance _electricalAppliance) {
		Appliance Appliance = new Appliance(_electricalAppliance.getBrand(), _electricalAppliance.getModel(),
				_electricalAppliance.getMaxPower(), _electricalAppliance.isGraduable(),
				_electricalAppliance.getTotalGraduations(), _electricalAppliance.isSecured());
		return Appliance;

	}
}
