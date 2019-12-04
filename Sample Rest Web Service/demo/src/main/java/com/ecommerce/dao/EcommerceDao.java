package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EcommerceDao {
	/**
	 * inventoryList of InventoryBean
	 */
	public static Map<String,String[]> productMap;
	/**
	 * loading all the product details from db.
	 * @return Map with productID as KEY and product object as value
	 */
	public static Map<String,String[]>loadProducts(){
		try {
		productMap = new HashMap<String,String[]>();
		//connection is fetched from connection provider
		Connection con=DBConnection.getCon();
		//query is done database
		 PreparedStatement	ps = con.prepareStatement("select * from Product");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String id  = rs.getString(1);
				String name  = rs.getString(2);
				String saleprice = rs.getString(3);
				String shortDescp = rs.getString(4);
				String longDescp = rs.getString(5);
				String image = rs.getString(6);
				String[] productArr = {id,name,image,saleprice,shortDescp,longDescp};
				productMap.put(rs.getString(1), productArr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// code to load the result set in hash map
		return productMap;
	}
}
