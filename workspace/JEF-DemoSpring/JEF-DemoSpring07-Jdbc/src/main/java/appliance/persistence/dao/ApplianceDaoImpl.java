package appliance.persistence.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import appliance.persistence.model.Appliance;

@Repository
@Transactional
public class ApplianceDaoImpl implements ApplianceDao {

	private static final Logger logger = LoggerFactory.getLogger(ApplianceDaoImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Appliance> findAll() {
		final String requeteSelect = "SELECT id, brand, model, power, graduable, graduations, secured FROM appliance";
		logger.info(requeteSelect);

		JdbcTemplate jdbc = new JdbcTemplate(this.dataSource);
		List<Appliance> appliances = jdbc.query(requeteSelect, BeanPropertyRowMapper.newInstance(Appliance.class));

		logger.info("{} results", appliances.size());
		return appliances;
	}

	@Override
	public List<Appliance> findByBrand(String _brand) {
		if (_brand == null) {
			return this.findAll();
		}

		final String requeteSelect = "SELECT id, brand, model, power, graduable, graduations, secured FROM appliance WHERE upper(brand) = upper(?)";
		logger.info(requeteSelect);

		JdbcTemplate jdbc = new JdbcTemplate(this.dataSource);
		List<Appliance> appliances = jdbc.query(requeteSelect, BeanPropertyRowMapper.newInstance(Appliance.class),
				_brand);

		logger.info("{} results", appliances.size());
		return appliances;

	}

	@Override
	public void save(Appliance _appliance) {
		final String requeteInsert = "INSERT INTO appliance (id, brand, model, power, graduable, graduations, secured) select count(*)+1,?,?,?,?,?,? from appliance";
		logger.info(requeteInsert);

		JdbcTemplate jdbc = new JdbcTemplate(this.dataSource);
		int modif = jdbc.update(requeteInsert, _appliance.getBrand(), _appliance.getModel(), _appliance.getPower(),
				_appliance.isGraduable(), _appliance.getGraduations(), _appliance.isSecured());

		logger.info("{} lines inserted", modif);
	}
}
