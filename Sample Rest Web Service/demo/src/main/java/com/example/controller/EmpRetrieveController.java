package com.example.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.EmployeeRegistration;
import com.example.beans.EmployeeWrapper;

@CrossOrigin(origins= "http://localhost:8085")
@RestController
public class EmpRetrieveController {
	
	@RequestMapping(method = RequestMethod.GET, value="/employees")
	  @ResponseBody
	  public String getEmployees() {
		
		Map<String, String []> products = new HashMap<String, String[]>();
		String [] wine1 = {"$258.00", "Manufactured by Josh", "images/wine_2.png", "P101"};
		String [] wine2 = {"$158.00", "Manufactured by 14 Hands", "images/wine_3.png", "P102"};
		String [] wine3 = {"$108.00", "Manufactured by Apothic", "images/wine_1.png", "P103"};
		
		products.put("josh", wine1);
		products.put("14 Hands", wine2);
		products.put("Apothic", wine3);
		
		Object [] keySet = products.keySet().toArray();
		
		String displayTemp = "<div class=\"col-lg-4 mb-5 col-md-6\"><div class=\"wine_v_1 text-center pb-4\"><a href=\"shop-single.html?productId=#PRODUCT_ID#\" class=\"thumbnail d-block mb-4\"><img src=\"#WINE_IMG#\" alt=\"Image\" class=\"img-fluid\"></a><div><h3 class=\"heading mb-1\"><a href=\"#\">#WINE_DESC#</a></h3><span class=\"price\">$629.00</span></div><div class=\"wine-actions\"><h3 class=\"heading-2\"><a href=\"#\">Trius Cabernet France 2011</a></h3><span class=\"price d-block\">#WINE_COST#</span><div class=\"rating\"><span class=\"icon-star\"></span><span class=\"icon-star\"></span><span class=\"icon-star\"></span><span class=\"icon-star\"></span><span class=\"icon-star-o\"></span></div><a href=\"#\" class=\"btn add\"><span class=\"icon-shopping-bag mr-3\"></span> Add to Cart</a></div></div></div>";
		
		String finalDisplay = "";
		for (int i=0; i< keySet.length; i++){
			String localWine = displayTemp.replace("#WINE_COST#",(products.get(keySet[i]))[0]);
			localWine = localWine.replace("#WINE_DESC#",(products.get(keySet[i]))[1]);
			localWine = localWine.replace("#WINE_IMG#",(products.get(keySet[i]))[2]);
			localWine = localWine.replace("#PRODUCT_ID#",(products.get(keySet[i]))[3]);
			finalDisplay = localWine+finalDisplay;
		}
	  return finalDisplay;
	  
	  
	 
	  }

}
