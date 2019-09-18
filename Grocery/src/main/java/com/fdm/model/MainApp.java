package com.fdm.model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDBconnect");
		//Grocery newGrocery = new Grocery("sada2131231", "sadsad22213");
		GroceryDao groceryDao = new GroceryDao(emf);
		//groceryDao.persist(newGrocery);
//		groceryDao.remove(5);
	List<Grocery> result = groceryDao.searchByCategory("fruit");
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			Grocery grocery = (Grocery) iterator.next();
			System.out.println(grocery.getGroceryName());
		}
		//emf.close();
	}
}