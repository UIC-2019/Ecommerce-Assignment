package com.ecommerce.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.example.beans.Product;

public class EcommerceDao {
	/**
	 * inventoryList of InventoryBean
	 */
	public static Map<Integer,Product> productMap;
	/**
	 * loading all the product details from db.
	 * @return Map with productID as KEY and product object as value
	 */
	public static Map<Integer,Product>loadProducts(){
		productMap = new HashMap<Integer,Product>();
		//connection is fetched from connection provider
		Connection con=DBConnection.getCon();
		//query is done database
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from Product");
			ResultSet rs=ps.executeQuery();
			Product product;
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductDescription(rs.getString(3));
				product.setProductRating(rs.getDouble(4));
				product.setProductCategory(rs.getString(5));
				product.setProductUnitSalePrice(rs.getDouble(6));
				productMap.put(rs.getInt(1), product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// code to load the result set in hash map
		return productMap;
	}
	
	public static void updateCheckoutTables(){
		productMap = new HashMap<Integer,Product>();
		//connection is fetched from connection provider
		Connection con=DBConnection.getCon();
		//query is done database
		PreparedStatement ps;
		try {

			String CustomerID;
			String EmailID;
			String FullName;
			String Address;
			String City;
			String State;
			int Zip;
			int MobNo;
			int CreditCardNo;
			String CreditCardType;
			String ExpDate;
			int CVV;

			String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sql);
			//Add individual field values from array of values to be inserted to Preparedstatement
			ps.setString(1, CustomerID);
			ps.setString(2, EmailID);
			ps.setString(3, FullName);
			ps.setString(4, Address);
			ps.setString(5, City);
			ps.setString(6, State);
			ps.setString(7, Zip);
			ps.setString(8, MobNo);
			ps.setString(9, CreditCardNo);
			ps.setString(10, CreditCardType);
			ps.setString(11, ExpDate);
			ps.setString(12, CVV);
			//Execute the insert query/prepated statement
			ps.executeUpdate();

			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// code to load the result set in hash map
	}
}
