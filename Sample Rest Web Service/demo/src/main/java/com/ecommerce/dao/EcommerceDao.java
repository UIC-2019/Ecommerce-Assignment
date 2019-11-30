package com.ecommerce.dao;

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
}
