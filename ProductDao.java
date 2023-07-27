package com.pms.dao;

import com.pms.entity.Product;

public interface ProductDao {
	boolean addProduct(Product pru);
	void updateProduct(String name);
	void searchProduct();
	void sortProduct();
	void deleteProduct(int supplier_id);

}
