package appliance.business.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import appliance.business.dto.ApplianceDto;
import appliance.business.model.ElectricalAppliance;

@Component
public class ElectricalApplianceDtoTransformer {

	public ElectricalApplianceDtoTransformer() {
	}

	public ElectricalAppliance toBusinessModel(ApplianceDto _applianceDto) {
		ElectricalAppliance electricalAppliance = null;
		if (_applianceDto.getGraduations() == 0) {
			electricalAppliance = new ElectricalAppliance(_applianceDto.getBrand(), _applianceDto.getModel(),
					_applianceDto.getPower(), _applianceDto.isSecured());
		} else {
			electricalAppliance = new ElectricalAppliance(_applianceDto.getBrand(), _applianceDto.getModel(),
					_applianceDto.getPower(), _applianceDto.getGraduations(), _applianceDto.isSecured());
		}
		return electricalAppliance;
	}

	public List<ElectricalAppliance> toBusinessModel(List<ApplianceDto> _applianceDtos) {
		List<ElectricalAppliance> electricalAppliances = new ArrayList<ElectricalAppliance>(_applianceDtos.size());
		for (ApplianceDto applianceDto : _applianceDtos) {
			electricalAppliances.add(this.toBusinessModel(applianceDto));
		}
		return electricalAppliances;
	}

	public ApplianceDto toDto(ElectricalAppliance _electricalAppliance) {
		ApplianceDto applianceDto = new ApplianceDto(null, 0, _electricalAppliance.getBrand(),
				_electricalAppliance.getModel(), _electricalAppliance.getMaxPower(), _electricalAppliance.isGraduable(),
				_electricalAppliance.getTotalGraduations(), _electricalAppliance.isSecured());
		return applianceDto;

	}

	public List<ApplianceDto> toDto(List<ElectricalAppliance> _electricalAppliances) {
		List<ApplianceDto> applianceDtos = new ArrayList<ApplianceDto>(_electricalAppliances.size());
		for (ElectricalAppliance electricalAppliance : _electricalAppliances) {
			applianceDtos.add(this.toDto(electricalAppliance));
		}
		return applianceDtos;
	}
}
