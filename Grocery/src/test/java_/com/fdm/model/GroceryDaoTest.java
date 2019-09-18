package com.fdm.model;

import static org.mockito.Mockito.*;

import javax.persistence.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

public class GroceryDaoTest {

	private EntityManagerFactory mockEntityManagerFactory;
	private EntityManager mockEntityManager;
	private EntityTransaction mockEntityTransaction;
	private GroceryDao groceryDao;
	private Grocery mockManagedGrocery;
	private TypedQuery<Grocery> mockQuery;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		mockEntityManagerFactory = mock(EntityManagerFactory.class);
		mockEntityManager = mock(EntityManager.class);
		mockEntityTransaction = mock(EntityTransaction.class);
		groceryDao = new GroceryDao(mockEntityManagerFactory);
		when(mockEntityManagerFactory.createEntityManager()).thenReturn(mockEntityManager);
		when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
		mockManagedGrocery = mock(Grocery.class);
		mockQuery = mock(TypedQuery.class);
	}

	@Test
	public void that_addGrocery_can_persist_a_grocery() {
		Grocery pojoGrocery = new Grocery();
		groceryDao.persist(pojoGrocery);
		verify(mockEntityManagerFactory, times(1)).createEntityManager();
		verify(mockEntityManager, times(1)).getTransaction();
		verify(mockEntityTransaction, times(1)).begin();
		verify(mockEntityManager, times(1)).persist(pojoGrocery);
		verify(mockEntityTransaction, times(1)).commit();
		verify(mockEntityManager, times(1)).close();
	}

	@Test
	public void that_searchByCategory_can_find_a_grocery_by_category() {
		when(mockEntityManager.createQuery(anyString(), eq(Grocery.class))).thenReturn(mockQuery);
		Grocery pojoGrocery = new Grocery("apple", "fruit");
		groceryDao.searchByCategory(pojoGrocery.getCategory());
		verify(mockEntityManagerFactory, times(1)).createEntityManager();
		verify(mockEntityManager, times(1)).createQuery(anyString(), eq(Grocery.class));
		verify(mockEntityManager, times(1)).close();
	}

	@Test
	public void that_updateGrocery_can_update_the_Grocery() {
		Grocery pojoGrocery = new Grocery("apple", "fruit");

		when(mockEntityManager.find(Grocery.class, pojoGrocery.getGroceryId())).thenReturn(mockManagedGrocery);
		groceryDao.update(pojoGrocery);

		InOrder order = inOrder(mockEntityManagerFactory, mockEntityManager, mockEntityTransaction, mockManagedGrocery);
		order.verify(mockEntityManagerFactory, times(1)).createEntityManager();
		order.verify(mockEntityManager, times(1)).getTransaction();
		order.verify(mockEntityTransaction, times(1)).begin();
		order.verify(mockEntityManager, times(1)).find(Grocery.class, pojoGrocery.getGroceryId());
		order.verify(mockManagedGrocery, times(1)).update(pojoGrocery);
		order.verify(mockEntityTransaction, times(1)).commit();
		order.verify(mockEntityManager, times(1)).close();
	}

	@Test
	public void that_remove_can_delete_the_Grocery() {
		Grocery pojoGrocery = new Grocery("apple", "fruit");

		when(mockEntityManager.find(Grocery.class, pojoGrocery.getGroceryId())).thenReturn(mockManagedGrocery);
		groceryDao.remove(pojoGrocery.getGroceryId());

		verify(mockEntityManagerFactory, times(1)).createEntityManager();
		verify(mockEntityManager, times(1)).find(Grocery.class, pojoGrocery.getGroceryId());
		verify(mockEntityManager, times(1)).getTransaction();
		verify(mockEntityTransaction, times(1)).begin();
		verify(mockEntityManager, times(1)).remove(mockManagedGrocery);
		verify(mockEntityTransaction, times(1)).commit();
		verify(mockEntityManager, times(1)).close();
	}

	@Test
	public void that_getAllUsers_can_get_all_Users() {
		when(mockEntityManager.createQuery(anyString(), eq(Grocery.class))).thenReturn(mockQuery);
		groceryDao.getAll();

		verify(mockEntityManagerFactory, times(1)).createEntityManager();
		verify(mockEntityManager, times(1)).createQuery(anyString(), eq(Grocery.class));
		verify(mockEntityManager, times(1)).close();
	}

}
