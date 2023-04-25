package student.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import student.Dto.Admin;
import student.Dto.Student;


public class StudentDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("raju");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	public void saveStudent(Student student) {
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}
	public List<Student> getAllStudents(Admin admin){
		Query query = manager.createQuery("select s from Student s where s.admin=?1");
		query.setParameter(1, admin);
		List students = query.getResultList();
		return students;
	}
	public Student getStudent(int studentId) {
		return manager.find(Student.class, studentId);
	}
	public void updateStudent(Student student) {
		transaction.begin();
		manager.merge(student);
		transaction.commit();
	}
	public void deleteStudent(int id) {
		transaction.begin();
		manager.remove(manager.find(Student.class, id));
		transaction.commit();
	}
}
