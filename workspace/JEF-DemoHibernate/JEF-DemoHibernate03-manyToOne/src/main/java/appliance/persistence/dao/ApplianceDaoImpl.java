package appliance.persistence.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import appliance.persistence.model.Appliance;
import appliance.persistence.model.Brand;

@Repository
@Transactional
public class ApplianceDaoImpl implements ApplianceDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Appliance> findAll() {
		final String hql = "select app from Appliance as app  order by app.model";
		Query query = getSession().createQuery(hql);
		List<Appliance> list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appliance> findByBrand(String _brand) {
		final String hql = "select app from Appliance as app where upper(app.brand) like upper(:brand)  order by app.model";
		Query query = getSession().createQuery(hql);
		query.setParameter("brand", _brand);
		List<Appliance> list = query.list();
		return list;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Appliance _appliance) {
		getSession().save(_appliance);
	}

	@Override
	public void save(Brand _brand) {
		getSession().save(_brand);
	}

}
