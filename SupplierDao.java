package com.pms.dao;

import com.pms.entity.Supplier;

public interface SupplierDao {
	boolean addSupplier(Supplier sup);
	void updateSupplier(String name);
	void searchSupplier();
	void sortSupplier();
	void deleteSupplier(int supplier_id);
}
