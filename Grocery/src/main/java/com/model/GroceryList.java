package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="GroceryList")
public class GroceryList {
	@Id
	 @Column(name = "LID")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Lid;
	
	 @Column(name = "ListName")
	private String Lname;
	 
	 @Column(name = "Current")
	private boolean current;
	
	 @OneToMany(mappedBy = "grocerylist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<GroceryItem> Groceries;
	 
	 

	public int getLid() {
		return Lid;
	}

	public void setLid(int lid) {
		Lid = lid;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public List<GroceryItem> getGroceries() {
		return Groceries;
	}

	public void setGroceries(List<GroceryItem> groceries) {
		Groceries = groceries;
	}

	public GroceryList(int lid, String lname, boolean current) {
		super();
		Lid = lid;
		Lname = lname;
		this.current = current;
	}

	public GroceryList() {
		super();
	}
	 
	 
	 
}

