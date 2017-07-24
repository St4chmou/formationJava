package appliance.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import appliance.persistence.DaoException;
import appliance.persistence.model.Appliance;

@Repository
public class ApplianceDaoImpl implements ApplianceDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Appliance> findAll() {
		return findByBrand(null);
	}

	@Override
	public List<Appliance> findByBrand(String _brand) {
		List<Appliance> appliances = new ArrayList<Appliance>();

		// to protect ourselves from SQL injection ...
		PreparedStatement pStmt = null;
		ResultSet resultSet = null;
		Connection connection = null;

		String requeteSelect = "SELECT id, brand, model, power, graduable, graduations, secured FROM appliance";
		if (_brand != null) {
			requeteSelect += " WHERE upper(brand) = upper(?)";
		}

		try {
			connection = getConnection();

			// To disable Auto-commit
			connection.setAutoCommit(false);

			pStmt = connection.prepareStatement(requeteSelect);
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
				int i = 0;
				id = resultSet.getLong(++i);
				bdBrand = resultSet.getString(++i);
				bdModel = resultSet.getString(++i);
				bdPower = resultSet.getInt(++i);
				bdGraduable = resultSet.getBoolean(++i);
				bdGraduations = resultSet.getInt(++i);
				bdSecured = resultSet.getBoolean(++i);

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
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					logger.error("exception closing resultSet", e);
				}
			}
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (SQLException e) {
					logger.error("exception closing PreparedStatement", e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("exception closing Connection", e);
				}
			}
		}
		return appliances;
	}

	private Connection getConnection() {
		Connection connection = null;
		try {
			String sPseudoUrlPostgresql = "jdbc:postgresql://localhost:5432/minibase";
			connection = DriverManager.getConnection(sPseudoUrlPostgresql, "minibase", "minibase");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	@Override
	public void save(Appliance _appliance) {

		Connection connection = null;
		PreparedStatement stmt = null;

		final String requeteInsert = "INSERT INTO appliance (id, brand, model, power, graduable, graduations, secured) select count(*)+1,?,?,?,?,?,? from appliance";

		try {
			connection = getConnection();

			// To disable Auto-commit
			connection.setAutoCommit(false);

			int i = 1;
			stmt = connection.prepareStatement(requeteInsert);
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
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
					logger.error("", e2);
				}
			}
			throw new DaoException("Problem while querying", e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e3) {
					logger.error("", e3);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					logger.error("exception closing Connection", e);
				}
			}
		}
	}
}
