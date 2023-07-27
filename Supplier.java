package com.pms.entity;

public class Supplier {
	private int supplier_id;
	private String name;
	private String phone_no;
	private String email;
	private String address;
	public Supplier(int supplier_id, String name, String phone_no, String email, String address) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
		this.phone_no = phone_no;
		this.email = email;
		this.address = address;
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
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
