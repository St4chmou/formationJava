package appliance.persistence.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import appliance.business.dto.ApplianceDto;
import appliance.persistence.model.Appliance;

@Repository
@Transactional
public class ApplianceDaoImpl implements ApplianceDao {

	private Logger logger = LoggerFactory.getLogger(ApplianceDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<ApplianceDto> finAllDto() {
		final String hql = "select new appliance.business.dto.ApplianceDto(id, version, brand, model, power, graduable, graduations, secured)" //
				+ " from Appliance"//
				+ " order by model";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Appliance> findAll() {
		Query query = getSession().createQuery("select app from Appliance as app  order by app.model");
		List<Appliance> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appliance> findByBrand(String _brand) {
		Query query = getSession()
				.createQuery("select app from Appliance as app where app.brand like :brand  order by app.model");
		query.setParameter("brand", _brand);

		List<Appliance> list = query.list();
		return list;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void removeAllAppliances() {
		// this is a bulk delete, the logs won't show which occurences are
		// deleted.
		int i = getSession().createQuery("delete from Appliance").executeUpdate();
		logger.debug("Number of occurences deleted from DB : " + i);
	}

	@Override
	public void save(Appliance _appliance) {
		getSession().save(_appliance);
	}

}
