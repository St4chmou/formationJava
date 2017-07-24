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

import appliance.persistence.model.Appliance;

@Repository
@Transactional
public class ApplianceDaoImpl implements ApplianceDao {

	private Logger logger = LoggerFactory.getLogger(ApplianceDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Appliance> findAll() {
		final String hql = "select app from Appliance as app  order by app.model";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appliance> findByBrand(String _brand) {
		final String hql = "select app from Appliance as app where app.brand like" + " :brand  order by app.model";
		Query query = getSession().createQuery(hql);
		query.setParameter("brand", _brand);
		return query.list();
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

	@Override
	public void saveAllAppliances(List<Appliance> _appliances) {
		removeAllAppliances();
		for (Appliance appliance : _appliances) {
			this.save(appliance);
		}
	}

}
