package business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import business.model.Appliance;

public class ApplianceDaoImpl implements ApplianceDao {

	private static final Logger logger = LoggerFactory.getLogger(ApplianceDaoImpl.class);

	@Override
	public List<Appliance> findAll() {
		logger.debug("IN");
		return null;
	}

	@Override
	public void save(Appliance _appliance) {
		logger.debug("IN");
	}
}
