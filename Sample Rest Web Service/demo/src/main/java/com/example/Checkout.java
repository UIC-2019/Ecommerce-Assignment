package com.example.beans;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Checkout {
	
	private ArrayList<Item> items;
	
	private Customer customer;
	
	private String orderTotal;

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public static void main(String[] args) {
		ObjectMapper Obj = new ObjectMapper(); 
		  
        try { 
  
        	Checkout cart = new Checkout();
        	Customer customer = new Customer();
        	ArrayList<Item> arr = new ArrayList<Item>();
        	for (int i=0; i<3; i++) {
        		Item item = new Item();
        		item.setProductId("101");
        		item.setQuantity("3");
        		arr.add(item);
        	}
        	cart.setItems(arr);
        	customer.setAddress("address");
        	customer.setCcCVV("cvv");
        	customer.setCcExpiry("expiry");
        	customer.setCcNo("ccNo");
        	customer.setCity("city");
        	
        	customer.setCountry("country");
        	customer.setEmail("email");
        	customer.setFirstName("firstName");
        	customer.setLastName("lastName");
        	customer.setPhone("phone");
        	customer.setState("state");
        	customer.setZip("zip");
        	cart.setCustomer(customer);
        	
        	
        	
        	// get Oraganisation object as a json string 
            String jsonStr = Obj.writeValueAsString(cart); 
  
            // Displaying JSON String 
            System.out.println(jsonStr); 
        } 
  
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
	}

	public String getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}

}
