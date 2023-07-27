package com.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pms.entity.Supplier;


	
	public  class SupplierDaoImpl implements SupplierDao{
		Connection con=null;
		java.sql.PreparedStatement pstmt;
		public SupplierDaoImpl() throws SQLException{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management_system","root","root");

	}
	
	@Override
	public boolean addSupplier(Supplier sup) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
//		System.out.println("Add Supplier details");
		try {
			pstmt=(PreparedStatement)con.prepareStatement("insert into supplier values(?,?,?,?,?)");
			pstmt.setInt(1, sup.getSupplier_id());
			pstmt.setString(2, sup.getName());
			pstmt.setString(3, sup.getPhone_no());
			pstmt.setString(4, sup.getEmail());
			pstmt.setString(5, sup.getAddress());
			
			int i=pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}

	@Override
	public void updateSupplier(String name) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("update supplier set name='New' where name=?");
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
	public void searchSupplier() {
		// TODO Auto-generated method stub
		System.out.println("\nSupplier details");
		try {
			pstmt=con.prepareStatement("select * from supplier");
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void sortSupplier() {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("select * from supplier order by name asc");
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteSupplier(int supplier_id) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("delete from supplier where supplier_id=?");
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
