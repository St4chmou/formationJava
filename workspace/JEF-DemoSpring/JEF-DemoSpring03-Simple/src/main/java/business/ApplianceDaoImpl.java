package business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import business.model.Appliance;

@Repository
public class ApplianceDaoImpl implements ApplianceDao {

	Logger logger = LoggerFactory.getLogger(this.getClass());

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
