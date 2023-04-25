package student.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import student.Dto.Admin;

public class AdminDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("raju");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void AdminSignUp(Admin admin) {
		transaction.begin();
		manager.persist(admin);
		transaction.commit();
	}

	public Admin AdminLogin(String email, String password) {
		try {
			Query query = manager.createQuery("select a from Admin a where a.adminEmail=?1 and a.adminPassword=?2");
			query.setParameter(1, email);
			query.setParameter(2, password);

			Admin admin = (Admin) query.getSingleResult();
			return admin;
		} catch (Exception e) {
			return null;
		}
	}

	public void updateAdmin(Admin admin) {
		transaction.begin();
		manager.merge(admin);
		transaction.commit();
	}

}
