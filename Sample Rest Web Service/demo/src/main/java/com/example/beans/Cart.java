package com.example.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.GsonBuilderUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Cart {

	private ArrayList<Item> items;

	public ArrayList<Item> getItem() {
		return items;
	}

	public void setItem(ArrayList<Item> items) {
		this.items = items;
	}
	
	public static void main(String[] args) {
		ObjectMapper Obj = new ObjectMapper(); 
		  
        try { 
  
        	Cart cart = new Cart();
        	ArrayList<Item> arr = new ArrayList<Item>();
        	for (int i=0; i<3; i++) {
        		Item item = new Item();
        		item.setProductId("101");
        		item.setQuantity("3");
        		arr.add(item);
        	}
        	cart.setItem(arr);
        	
        	
        	// get Oraganisation object as a json string 
            String jsonStr = Obj.writeValueAsString(cart); 
  
            // Displaying JSON String 
            System.out.println(jsonStr); 
        } 
  
        catch (IOException e) { 
            e.printStackTrace(); 
        } 
	}
	
}
