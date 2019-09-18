package com.fdm.model;

import javax.persistence.*;


@Entity
public class Grocery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int groceryId;
	String groceryName;
	String category;

	public Grocery() {

	}

	public Grocery(int groceryId, String groceryName, String category) {
		super();
		this.groceryId = groceryId;
		this.groceryName = groceryName;
		this.category = category;
	}

	public Grocery(String groceryName, String category) {
		super();
		this.groceryName = groceryName;
		this.category = category;
	}

	public int getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(int groceryId) {
		this.groceryId = groceryId;
	}

	public String getGroceryName() {
		return groceryName;
	}

	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void update(Grocery newGrocery) {
		this.category = newGrocery.category;
		this.groceryName = newGrocery.groceryName;
		
	}

}