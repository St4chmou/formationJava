package appliance.persistence.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import appliance.business.dto.ApplianceDto;
import appliance.persistence.model.Appliance;

@Component
public class ApplianceDtoTransformer {

	public ApplianceDto toDto(Appliance _appliance) {
		ApplianceDto applianceDto = new ApplianceDto(null, 0, _appliance.getBrand(), _appliance.getModel(),
				_appliance.getPower(), _appliance.isGraduable(), _appliance.getGraduations(), _appliance.isSecured());
		return applianceDto;

	}

	public List<ApplianceDto> toDto(List<Appliance> _appliances) {
		List<ApplianceDto> applianceDtos = new ArrayList<ApplianceDto>(_appliances.size());
		for (Appliance appliance : _appliances) {
			applianceDtos.add(this.toDto(appliance));
		}
		return applianceDtos;
	}

	public Appliance toPersistentModel(ApplianceDto _applianceDto) {
		Appliance appliance = null;
		// public Appliance(String _brand, String _model, int _power, boolean
		// _graduable, Integer
		// _graduations,
		// boolean _secured) {
		appliance = new Appliance(_applianceDto.getBrand(), _applianceDto.getModel(), _applianceDto.getPower(),
				_applianceDto.isGraduable(), _applianceDto.getGraduations(), _applianceDto.isSecured());
		return appliance;
	}

	public List<Appliance> toPersistentModel(List<ApplianceDto> _applianceDtos) {
		List<Appliance> appliances = new ArrayList<Appliance>(_applianceDtos.size());
		for (ApplianceDto applianceDto : _applianceDtos) {
			appliances.add(this.toPersistentModel(applianceDto));
		}
		return appliances;
	}
}
