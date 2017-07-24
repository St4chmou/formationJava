package appliance.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import appliance.persistence.DaoException;
import appliance.persistence.model.Appliance;

@Repository
@Transactional
public class ApplianceDaoImpl implements ApplianceDao {

	private static final Logger logger = LoggerFactory.getLogger(ApplianceDaoImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Appliance> findAll() throws SQLException {
		return findByBrand(null);
	}

	@Override
	public List<Appliance> findByBrand(String _brand) {
		String requeteSelect = "SELECT id, brand, model, power, graduable, graduations, secured FROM appliance";
		if (_brand != null) {
			requeteSelect += " WHERE upper(brand) = upper(?)";
		}

		// Pas besoin de fermer la connexion (merci DataSourceUtils)
		Connection connection = getConnection();

		try (PreparedStatement stmt = connection.prepareStatement(requeteSelect);) {

			if (_brand != null) {
				stmt.setString(1, _brand);
			}

			logger.info(stmt.toString());

			ResultSet resultSet = stmt.executeQuery();

			Long id;
			String bdBrand;
			String bdModel;
			int bdPower;
			boolean bdGraduable;
			Integer bdGraduations;
			boolean bdSecured;

			List<Appliance> appliances = new ArrayList<Appliance>();
			while (resultSet.next()) {
				id = resultSet.getLong("id");
				bdBrand = resultSet.getString(2);
				bdModel = resultSet.getString(3);
				bdPower = resultSet.getInt(4);
				bdGraduable = resultSet.getBoolean(5);
				bdGraduations = resultSet.getInt(6);
				bdSecured = resultSet.getBoolean(7);

				Appliance app = new Appliance(bdBrand, bdModel, bdPower, bdGraduable, bdGraduations, bdSecured);
				app.setId(id);
				appliances.add(app);
			}
			logger.info("{} results", appliances.size());

			return appliances;
		} catch (SQLException e) {
			throw new DaoException("Problem while querying", e);
		}

	}

	public Connection getConnection() {
		return DataSourceUtils.getConnection(dataSource);
	}

	@Override
	public void save(Appliance _appliance) {
		final String requeteInsert = "INSERT INTO appliance (id, brand, model, power, graduable, graduations, secured) select count(*)+1,?,?,?,?,?,? from appliance";

		// Pas besoin de fermer la connexion (merci DataSourceUtils)
		Connection connection = getConnection();

		try (PreparedStatement stmt = connection.prepareStatement(requeteInsert);) {

			logger.info(stmt.toString());

			int i = 1;
			stmt.setString(i++, _appliance.getBrand());
			stmt.setString(i++, _appliance.getModel());
			stmt.setInt(i++, _appliance.getPower());
			stmt.setBoolean(i++, _appliance.isGraduable());
			stmt.setInt(i++, _appliance.getGraduations());
			stmt.setBoolean(i++, _appliance.isSecured());

			int modif = stmt.executeUpdate();

			logger.info("{} lines inserted", modif);
		} catch (SQLException e) {
			throw new DaoException("Problem while querying", e);
		}
	}
}
