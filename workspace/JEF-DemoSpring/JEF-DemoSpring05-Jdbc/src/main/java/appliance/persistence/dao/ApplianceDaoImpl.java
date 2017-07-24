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
import org.springframework.stereotype.Repository;

import appliance.persistence.DaoException;
import appliance.persistence.model.Appliance;

@Repository
public class ApplianceDaoImpl implements ApplianceDao {

	private static final Logger logger = LoggerFactory.getLogger(ApplianceDaoImpl.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Appliance> findAll() {
		return findByBrand(null);
	}

	@Override
	public List<Appliance> findByBrand(String _brand) {
		List<Appliance> appliances = new ArrayList<Appliance>();

		String requeteSelect = "SELECT id, brand, model, power, graduable, graduations, secured FROM appliance";
		if (_brand != null) {
			requeteSelect += " WHERE upper(brand) = upper(?)";
		}

		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			// To disable Auto-commit
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DaoException("Problem while querying", e);
		}

		try (PreparedStatement pStmt = connection.prepareStatement(requeteSelect);) {
			if (_brand != null) {
				pStmt.setString(1, _brand);
			}

			logger.info(pStmt.toString());

			resultSet = pStmt.executeQuery();

			Long id;
			String bdBrand;
			String bdModel;
			int bdPower;
			boolean bdGraduable;
			Integer bdGraduations;
			boolean bdSecured;

			while (resultSet.next()) {
				id = resultSet.getLong(1);
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

			// To commit
			connection.commit();

		} catch (SQLException e) {
			// Rollback
			try {
				connection.rollback();
			} catch (SQLException e1) {
				logger.error("exception during rollback", e);
			}
			// Throw error
			throw new DaoException("Problem while querying", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("exception closing resultSet", e);
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					logger.error("exception closing resultSet", e);
				}
			}
		}
		return appliances;

	}

	@Override
	public void save(Appliance _appliance) {

		final String requeteInsert = "INSERT INTO appliance (id, brand, model, power, graduable, graduations, secured) select count(*)+1,?,?,?,?,?,? from appliance";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement stmt = connection.prepareStatement(requeteInsert);) {

			connection.setAutoCommit(false);
			int i = 1;
			logger.info(stmt.toString());

			stmt.setString(i++, _appliance.getBrand());
			stmt.setString(i++, _appliance.getModel());
			stmt.setInt(i++, _appliance.getPower());
			stmt.setBoolean(i++, _appliance.isGraduable());
			stmt.setInt(i++, _appliance.getGraduations());
			stmt.setBoolean(i++, _appliance.isSecured());

			int modif = stmt.executeUpdate();
			connection.commit();

			logger.info("{} lines inserted", modif);
		} catch (SQLException e) {
			throw new DaoException("Problem while querying", e);
		}

	}
}
