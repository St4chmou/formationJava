package appliance.persistence.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import appliance.persistence.model.Appliance;

@Repository
@Transactional
public class ApplianceDaoImpl implements ApplianceDao {

	@Autowired
	private SessionFactory sessionFactory;

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
		final String hql = "select app from Appliance as app"//
				+ " where upper(app.brand) like upper(:brand)"//
				+ " order by app.model";

		Query query = getSession().createQuery(hql);
		query.setParameter("brand", _brand);
		List<Appliance> list = query.list();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Appliance> findByBrandCriteria(String _brand) {
		Criteria criteria = getSession().createCriteria(Appliance.class);
		criteria.add(Restrictions.ilike("brand", _brand));
		List<Appliance> list = criteria.list();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Appliance> findByBrandNativeSql(String _brand) {
		final String sql = "select * from APPLIANCE app where app.brand ilike :brand";
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		sqlQuery.addEntity(Appliance.class);
		sqlQuery.setParameter("brand", _brand);
		List<Appliance> list = sqlQuery.list();
		return list;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Appliance _appliance) {
		getSession().save(_appliance);
	}
}
