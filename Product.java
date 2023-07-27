package com.pms.entity;

public class Product {
	private int supplier_id;
	private String name;
	private String description;

	private int quantity;
	private double price;
	private int p_id;
	public Product(String name, String description, int quantity, double price, int supplier_id, int p_id) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
		this.description = description;
		
		this.quantity = quantity;
		this.price = price;
		this.p_id=p_id;
	}
	
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	

}
