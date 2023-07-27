package com.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.pms.entity.Product;

public   class ProductDaoImpl implements ProductDao{
	Connection con=null;
	java.sql.PreparedStatement pstmt;
	public ProductDaoImpl() throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management_system","root","root");

}

	public boolean addProduct(Product pru) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
//		System.out.println("Add Product details");
		try {
			pstmt=(PreparedStatement)con.prepareStatement("insert into product values(?,?,?,?,?,?)");
			pstmt.setString(1, pru.getName());
			pstmt.setString(2, pru.getDescription());
			pstmt.setInt(3, pru.getQuantity());
			pstmt.setDouble(4, pru.getPrice());
			pstmt.setInt(5, pru.getSupplier_id());
			pstmt.setInt(6, pru.getP_id());
			int i=pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}


	@Override
	public void updateProduct(String name) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("update product set name='New' where name=?");
			pstmt.setString(1, name);
			int i=pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("Name Updated");
			}else {
				System.out.println("Name not updated");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void searchProduct() {
		// TODO Auto-generated method stub
		System.out.println("\nProduct details");
		try {
			pstmt=con.prepareStatement("select p_id,name from product");
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void sortProduct() {
		// TODO Auto-generated method stub
		System.out.println("\nSorted products by name in Ascending order");
		try {
			pstmt=con.prepareStatement("select * from product order by name asc");
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getDouble(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteProduct(int supplier_id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("delete from product where supplier_id=?");
			pstmt.setInt(1, supplier_id);
			int i=pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("deleted");
			}else {
				System.out.println("not deleted");
			}
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}

	

	
	
}