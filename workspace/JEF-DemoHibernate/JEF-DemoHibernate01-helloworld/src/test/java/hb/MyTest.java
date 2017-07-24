package hb;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe de test avec une classe simple et une méthode MAIN.
 * 
 * C'est pénible à écrire et à lire :(
 *
 */
public class MyTest {

	private static final Logger LOG = LoggerFactory.getLogger(MyTest.class);

	private static SessionFactory sessionFactory;

	public static void createCountry(Country _country) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(_country);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public static Country findCountry(Long _idCountry) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Country country = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("select c from Country c where c.id = :idCountry");
			query.setParameter("idCountry", _idCountry);
			country = (Country) query.uniqueResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		return country;
	}

	@SuppressWarnings("unchecked")
	public static List<Country> findCountryByNameLike(String _country) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<Country> list = null;
		try {
			tx = session.beginTransaction();

			Query query = session.createQuery("select c from Country c where c.name like :countryName");
			query.setParameter("countryName", _country);
			list = query.list();

			// idem but an anti-pattern enabling parameter injection
			String sql = "select c from Country c where c.name like" + "'%" + _country + "%'";
			Query query2 = session.createQuery(sql);
			list = query2.list();

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		return list;
	}

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate-minibase.cfg.xml");

		// for Hibernate 4.3.x
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		// for hibernate 4.2.x
		// configuration.setProperty("hibernate.show_sql", "true");
		// sessionFactory = configuration.buildSessionFactory();

		LOG.info("Test start");
		try {
			Country country = new Country("France");
			createCountry(country);

			Country country2 = findCountry(country.getId());

			country2.setName("Italie");
			updateCountry(country2);

		} catch (Exception e) {
			LOG.error("Error occurs :", e);
		} finally {
			sessionFactory.close();
		}
		LOG.info("Test end");
	}

	public static void updateCountry(Country _country) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(_country);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
