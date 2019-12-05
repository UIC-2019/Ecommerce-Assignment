package com.ecommerce.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.beans.Checkout;
import com.example.beans.Customer;
import com.example.beans.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public static void updateCheckoutTables(Checkout cart) throws SQLException{

		//update the customer table
		
		
		ObjectMapper Obj = new ObjectMapper();

		try {
			System.out.println(Obj.writeValueAsString(cart));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Customer cust = cart.getCustomer();
		
		Connection con=DBConnection.getCon();
		
		//double TotalOrderRevenue = 
		int TotalOrderQty = 0;
		PreparedStatement ps;

			String insertCustSql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) Select * from Customer cust2"
					+"	WHERE NOT EXISTS (SELECT * FROM Customer WHERE (Customer.firstName=cust2.firstName and Customer.lastName=cust2.lastName"
					+"  and Customer.address=cust2.address and Customer.email=cust2.email and Customer.ccNo=cust2.ccNo))";
			

			
			

			ps = con.prepareStatement(insertCustSql);
	
			ps.setString(1, cust.getFirstName());
			ps.setString(2, cust.getLastName());
			ps.setString(3, cust.getAddress());
			ps.setString(4, cust.getCity());
			ps.setString(5, cust.getState());
			ps.setString(6, cust.getCountry());
			
			ps.setString(7, cust.getZip());
			
			ps.setString(8, cust.getEmail());
			
			
			ps.setString(9, cust.getPhone());
			ps.setString(10, cust.getCcNo());
			ps.setString(11, cust.getCcExpiry());
			ps.setString(12, cust.getCcCVV());
			

			try {
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			//update the Order table
		Statement statement = con.createStatement();
		ResultSet resultSet, rs1=null;
		
		String OrderID="",price="", stockqty = "";

		String Sql = "select Top 1 OrderID from Orders Order by OrderID desc";
		resultSet = statement.executeQuery(Sql);
		while (resultSet.next())
		{
			
		OrderID = String.valueOf(Integer.parseInt((resultSet.getString(1)))+1);
		
		}
		
		ArrayList<Item> items = cart.getItems();
        String localDate = LocalDate.now().toString();

	      	
	      for (Item i: items) { 		      
	    	  String productID = i.getProductId();
	    	  int qty= Integer.parseInt(i.getQuantity());
	    	  
	    	  Sql = "select UnitSalePrice from Product where ProductID="+productID;
	    	  resultSet = statement.executeQuery(Sql);
	    	  while(resultSet.next())
	    	  {
	    		
	    		  price = resultSet.getString(1).substring(1);
	    	  }
	    	  
	  		double UnitSalePrice = Double.parseDouble(price);
	  		double TotalPrice = qty*UnitSalePrice;
	  		
	  		//TotalOrderRevenue = TotalOrderRevenue + TotalPrice;
	  		TotalOrderQty = TotalOrderQty + qty;
	  		
	  		
		
		String insertOrderSql = "INSERT INTO Orders VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		ps = con.prepareStatement(insertOrderSql);
		
		ps.setString(1, OrderID);
		ps.setString(2, localDate);
		ps.setString(3, productID);
		ps.setString(4, String.valueOf(qty));
		ps.setString(5, resultSet.getString(1));
		ps.setString(6, "$"+String.valueOf(TotalPrice));
		ps.setString(7, cust.getEmail());
		ps.setString(8, "link");
		ps.setString(9, "Order Placed");
		
		

		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      
	      //update Inventory table
	      
		Sql = "select stockqty from Inventory Order where productid = "+productID;
		
		
		rs1 = statement.executeQuery(Sql);
		while(rs1.next())
		{
			stockqty = String.valueOf(Integer.parseInt((resultSet.getString(1)))-qty);
		}
		
		
		
		String query = "update Inventory set qty = "+ stockqty +" where ProductID =" + productID ;
	      PreparedStatement preparedStmt = con.prepareStatement(query);

	      
	      preparedStmt.executeUpdate();
	      
	      
	      }
	      
	      //insert data into Sales table
	      
	      String insertSalesSql = "INSERT INTO Sales VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

			ps = con.prepareStatement(insertSalesSql);
			
			
			ps.setString(1, OrderID);
			ps.setString(2, String.valueOf(TotalOrderQty));
			ps.setString(3, localDate);
			ps.setString(4, cart.getOrderTotal());

			
			ps.executeUpdate();
		
	}




}
