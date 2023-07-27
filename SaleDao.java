package com.pms.dao;

import com.pms.entity.Sale;

public interface SaleDao {
	boolean addSale(Sale sal);
	void updateSale(int quantity);
	void searchSale();
	void sortSale();

}
