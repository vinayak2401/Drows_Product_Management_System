package com.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.pms.entity.Sale;


public class SaleDaoImpl implements SaleDao{
	Connection con=null;
	java.sql.PreparedStatement pstmt;
	public SaleDaoImpl() throws SQLException{
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management_system","root","root");

}

	public boolean addSale(Sale sal) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
//		System.out.println("Add Sale details");
		try {
			pstmt=(PreparedStatement)con.prepareStatement("insert into sale values(?,?,?,?,?)");
			pstmt.setInt(1, sal.getSale_id());
			pstmt.setString(2, sal.getDate());
			pstmt.setInt(3, sal.getQuantity());
			pstmt.setDouble(4, sal.getTotal_revenue());
			pstmt.setInt(5, sal.getP_id());
			
			int i=pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}

	@Override
	public void updateSale(int quantity) {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("update sale set quantity=10 where quantity=?");
			pstmt.setInt(1, quantity);
			int i=pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("quantity Updated");
			}else {
				System.out.println("quantity not updated");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void searchSale() {
		// TODO Auto-generated method stub
		System.out.println("\nSale details");
		try {
			pstmt=con.prepareStatement("select * from sale");
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getDouble(4)+" "+rs.getInt(5));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void sortSale() {
		// TODO Auto-generated method stub
		try {
			pstmt=con.prepareStatement("select * from sale order by quantity asc");
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getDouble(4)+" "+rs.getInt(5));
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
