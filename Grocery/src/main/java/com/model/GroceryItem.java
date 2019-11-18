package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="GroceryItem")
public class GroceryItem {
	@Id
	 @Column(name = "IID")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)	
private int IId;
	
	 @Column(name = "ItemName")
private String Iname;
	 
	 public int getIId() {
		return IId;
	}

	public void setIId(int iId) {
		IId = iId;
	}

	public String getIname() {
		return Iname;
	}

	public void setIname(String iname) {
		Iname = iname;
	}

	public String getIType() {
		return IType;
	}

	public void setIType(String iType) {
		IType = iType;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public GroceryList getGrocerylist() {
		return grocerylist;
	}

	public void setGrocerylist(GroceryList grocerylist) {
		this.grocerylist = grocerylist;
	}

	@Column(name = "ItemType")
private String IType;
	 
	 @Column(name = "Price")
private String price;
	 
	 @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		@JoinColumn(name="Shoppinglist")
		private GroceryList grocerylist;

	public GroceryItem(int iId, String iname, String iType, String price) {
		super();
		IId = iId;
		Iname = iname;
		IType = iType;
		this.price = price;
	}

	public GroceryItem() {
		super();
	}
	 
	 
	 

}
