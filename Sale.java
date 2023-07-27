package com.pms.entity;

public class Sale {
	private int sale_id;
	private String date;
	private int p_id;
	private int quantity;
	private double total_revenue;
	public Sale(int sale_id, String date, int quantity, double total_revenue, int p_id) {
		super();
		this.sale_id = sale_id;
		this.date = date;
		this.p_id = p_id;
		this.quantity = quantity;
		this.total_revenue = total_revenue;
	}
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal_revenue() {
		return total_revenue;
	}
	public void setTotal_revenue(double total_revenue) {
		this.total_revenue = total_revenue;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	

}
