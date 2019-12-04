package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dao.EcommerceDao;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmpRetrieveController {
	static Object[] keySet;
	static Map<String, String[]> products;
	static {
		products = EcommerceDao.loadProducts();
		keySet = products.keySet().toArray();
 }
	@RequestMapping(method = RequestMethod.GET, value = "/employees")
	@ResponseBody
	public String getEmployees() {
	
		String displayTemp = "<div class=\"col-lg-4 mb-5 col-md-6\"><div class=\"wine_v_1 text-center pb-4\"><a href=\"shop-single.html?productId=#PRODUCT_ID#\" class=\"thumbnail d-block mb-4\"><img src=\"#WINE_IMG#\" alt=\"Image\" class=\"img-fluid\"></a><div><h3 class=\"heading mb-1\"><a href=\"#\">#WINE_NAME#</a></h3><span class=\"price\">#WINE_COST#</span></div><div class=\"wine-actions\"><h3 class=\"heading-2\"><a href=\"#\">#WINE_SHORT_DESC#</a></h3><span class=\"price d-block\">#WINE_COST#</span><div class=\"rating\"><span class=\"icon-star\"></span><span class=\"icon-star\"></span><span class=\"icon-star\"></span><span class=\"icon-star\"></span><span class=\"icon-star-o\"></span></div><a href=\"shop-single.html?productId=#PRODUCT_ID#\" class=\"btn add\"><span class=\"icon-shopping-bag mr-3\"></span> Add to Cart</a></div></div></div>";

		String finalDisplay = "";
		for (int i = 0; i < 3; i++) {
			String localWine = displayTemp.replace("#WINE_COST#", (products.get(keySet[i]))[3]);
			localWine = localWine.replace("#WINE_SHORT_DESC#", (products.get(keySet[i]))[4]);
			localWine = localWine.replace("#WINE_IMG#", (products.get(keySet[i]))[2]);
			localWine = localWine.replace("#PRODUCT_ID#", (products.get(keySet[i]))[0]);
			localWine = localWine.replace("#WINE_NAME#", (products.get(keySet[i]))[1]);
			finalDisplay = localWine + finalDisplay;
		}
		return finalDisplay;

	}

}
