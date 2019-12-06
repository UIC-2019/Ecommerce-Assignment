package com.internal.wines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internal.wines.bean.Employee;
import com.internal.wines.bean.Inventory;
import com.internal.wines.bean.Login;
import com.internal.wines.bean.Order;
import com.internal.wines.bean.Vendor;


public class WinesDao {
Connection con = null;
/**
 * inventoryList holds Vendor data
 */
public static ArrayList<Vendor> vendorList = null;
/**
 * orderList holds Order data
 */
public static ArrayList<Order>orderList = null;
/**
 * inventoryList holds Inventory data
 */
public static ArrayList<Inventory> inventoryList = null;
/**
 * employeeList holds Employee data
 */
public static ArrayList<Employee> employeeList = null;
	public static Login checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
		Connection con=ConnectionProvider.getCon();
		String sql = "SELECT * FROM login WHERE email = ? and password = ?"; //Insert user details into the table 'USERS'
		PreparedStatement statement = con.prepareStatement(sql); //Making use of prepared statements here to insert bunch of data
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();
		Login user = null;
		if (result.next()) {
			user = new Login();
			user.setEmail(email);
			if(result.getString(3)!=null) {
				user.setUserName(result.getString(3));
			}
		}
		return user;
	}
	public static ArrayList<Vendor>loadVendors() {
		try{
			vendorList = new ArrayList<Vendor>();
			//connection is fetched from connection provider
			Connection con=ConnectionProvider.getCon();
			//query is done database
			PreparedStatement ps=con.prepareStatement("select * from Vendor");
			ResultSet rs=ps.executeQuery();
			// code to load the result set in hash map
			Vendor bean;
			//obtained results from DB is stored as list of Vendor
			while(rs.next()) {
				 bean = new Vendor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7));
				 vendorList.add(bean);
			}
			return vendorList;
		}catch(Exception e){
			e.getStackTrace();
		}
		return vendorList;
	}
	public static ArrayList<Order>loadOrders() {
		try{
			orderList = new ArrayList<Order>();
			//connection is fetched from connection provider
			Connection con=ConnectionProvider.getCon();
			//query is done database
			PreparedStatement ps=con.prepareStatement("select * from Orders");
			ResultSet rs=ps.executeQuery();
			// code to load the result set in hash map
			Order bean;
			//obtained results from DB is stored as list of Vendor
			while(rs.next()) {
				 bean = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9));
				 orderList.add(bean);
			}
			return orderList;
		}catch(Exception e){
			e.getStackTrace();
		}
		return orderList;
	}
	public static ArrayList<Inventory>loadInventory() {
		try{
			inventoryList = new ArrayList<Inventory>();
			//connection is fetched from connection provider
			Connection con=ConnectionProvider.getCon();
			//query is done database
			PreparedStatement ps=con.prepareStatement("select * from Inventory");
			ResultSet rs=ps.executeQuery();
			// code to load the result set in hash map
			Inventory bean;
			//obtained results from DB is stored as list of Vendor
			while(rs.next()) {
				 bean = new Inventory(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5));
				 inventoryList.add(bean);
			}
			return inventoryList;
		}catch(Exception e){
			e.getStackTrace();
		}
		return inventoryList;
	}
	public static ArrayList<Employee>loadEmployee() {
		try{
			employeeList = new ArrayList<Employee>();
			//connection is fetched from connection provider
			Connection con=ConnectionProvider.getCon();
			//query is done database
			PreparedStatement ps=con.prepareStatement("select * from Employee");
			ResultSet rs=ps.executeQuery();
			// code to load the result set in hash map
			Employee bean;
			//obtained results from DB is stored as list of Vendor
			while(rs.next()) {
				 bean = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				 employeeList.add(bean);
			}
			return employeeList;
		}catch(Exception e){
			e.getStackTrace();
		}
		return employeeList;
	}
}
