package com.fdm.model;

import java.util.List;

import javax.persistence.*;

public class GroceryDao {
	protected final EntityManagerFactory emf;

	public GroceryDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void persist(Grocery pojoGrocery) {
		System.out.println("persist(" + pojoGrocery + ")");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		{
			em.persist(pojoGrocery);
		}
		transaction.commit();
		em.close();
	}

	public List<Grocery> getAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Grocery> query = em.createQuery("SELECT e FROM Grocery e", Grocery.class);
		List<Grocery> results = query.getResultList();
		em.close();
		return results;
	}

	public void update(Grocery newGrocery) {
		System.out.println("update(" + newGrocery + ")");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		{
			Grocery foundGrocery = em.find(Grocery.class, newGrocery.getGroceryId());
			foundGrocery.update(newGrocery);
		}
		transaction.commit();
		em.close();
	}

	public void remove(int groceryId) {
		System.out.println("remove(" + groceryId + ")");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Grocery foundGrocery = em.find(Grocery.class, groceryId);
		{
			em.remove(foundGrocery);
		}
		transaction.commit();
		em.close();
	}
 
//	public Grocery findByCategory(String category) {
//		System.out.println("findByCategory(" + category + ")");
//		EntityManager em = emf.createEntityManager();
//		Grocery mjoGrocery;
//		mjoGrocery = em.find(Grocery.class, category);
//		em.close();
//		return mjoGrocery;
//	}
	
	public List<Grocery> searchByCategory(String category) {
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT e FROM Grocery e where e.category LIKE '%" + category + "%'";
		System.out.println("sql = " + sql);
		TypedQuery<Grocery> query = em.createQuery(sql, Grocery.class);
		List<Grocery> results = query.getResultList();
		em.close();
		return results;
	}
}
