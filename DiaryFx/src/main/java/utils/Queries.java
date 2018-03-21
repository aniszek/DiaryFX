package utils;

/**
 * Created by anisz
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.BaseModel;
import model.Event;
import model.Person;

public class Queries {

	static EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();

	public static <T extends BaseModel> T findById(Class<T> cls, Integer id) {
		EntityTransaction t = em.getTransaction();
		T findById3Result = em.find(cls, id);
		return findById3Result;
	}

	public static <T extends BaseModel> List<T> queryForAll(Class<T> cls) {
		TypedQuery<T> queryForAll = em.createQuery("select x from " + cls.getSimpleName() + " x", cls);
		EntityTransaction t = em.getTransaction();
		t.begin();
		List<T> queryForAllResult = queryForAll.getResultList();
		t.commit();
		return queryForAllResult;
	}

	public static <T extends BaseModel> void delete(Class<T> cls) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query deleteQuery = em.createQuery("delete from " + cls.getSimpleName() + " x", cls);
		t.commit();
	}

	public static <T extends BaseModel> void deleteById(Class<T> cls, Integer id) {
		EntityTransaction t = em.getTransaction();
		T findByIdResult = em.find(cls, id);
		t.begin();
		em.remove(findByIdResult);
		t.commit();
	}
	
	public static <T> void create(T o) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(o);
		t.commit();
		em.refresh(o);
	}
	
	public static <T> void update(T o) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(o);
		t.commit();
		em.refresh(o);
	}
}
