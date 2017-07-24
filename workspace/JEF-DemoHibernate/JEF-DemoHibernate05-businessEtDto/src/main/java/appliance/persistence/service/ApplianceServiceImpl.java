package appliance.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import appliance.business.dto.ApplianceDto;
import appliance.persistence.dao.ApplianceDao;
import appliance.persistence.model.Appliance;
import appliance.persistence.transformer.ApplianceDtoTransformer;

@Service
@Transactional
public class ApplianceServiceImpl implements ApplianceService {

	@Autowired
	private ApplianceDao applianceDao;

	@Autowired
	private ApplianceDtoTransformer applianceDtoTransformer;

	@Override
	public List<ApplianceDto> loadAllAppliances() {
		// List<Appliance> appliances = applianceDao.findAll();
		// List<ApplianceDto> applianceDtos =
		// applianceDtoTransformer.toDto(appliances);
		List<ApplianceDto> applianceDtos = this.applianceDao.finAllDto();
		return applianceDtos;
	}

	@Override
	public void saveAllAppliances(List<ApplianceDto> _applianceDtos) {
		List<Appliance> appliances = applianceDtoTransformer.toPersistentModel(_applianceDtos);
		applianceDao.removeAllAppliances();
		for (Appliance appliance : appliances) {
			this.applianceDao.save(appliance);
		}
	}

}
