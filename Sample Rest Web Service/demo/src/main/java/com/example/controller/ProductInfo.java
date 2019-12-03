package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dao.EcommerceDao;
import com.example.beans.Product;

@CrossOrigin(origins= "http://localhost:8090")
@RestController

public class ProductInfo {
	
	@RequestMapping(method = RequestMethod.GET, value="/products")
	@ResponseBody
	
	public String getProductDetail (@RequestParam Integer productId) {
	
		String wineInfo = "<div class=\"col-lg-6\"><div class=\"owl-carousel hero-slide owl-style\"><img src=\"images/wine_1.png\" alt=\"Image\" class=\"img-fluid\"><img src=\"images/wine_2.png\" alt=\"Image\" class=\"img-fluid\"><img src=\"images/wine_3.png\" alt=\"Image\" class=\"img-fluid\"></div></div><div class=\"col-lg-5 ml-auto\"><h2 class=\"text-primary\">Wine Details</h2><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non eos inventore aspernatur voluptatibus ratione odit molestias molestiae, illum et impedit veniam modi sunt quas nam mollitia earum perferendis, dolorem. Magni.</p><div class=\"mb-5\"><div class=\"input-group mb-3\" style=\"max-width: 200px;\"><div class=\"input-group-prepend\"><button class=\"btn btn-outline-primary js-btn-minus\" type=\"button\">&minus;</button></div><input type=\"text\" class=\"form-control text-center border mr-0\" value=\"1\" placeholder=\"\" aria-label=\"Example text with button addon\" aria-describedby=\"button-addon1\"><div class=\"input-group-append\"><button class=\"btn btn-outline-primary js-btn-plus\" type=\"button\">&plus;</button></div></div></div><p><a href=\"cart.html\" class=\"buy-now btn btn-sm height-auto px-4 py-3 btn-primary\">Add To Cart</a></p></div>";
		Map<Integer,Product>productMap = EcommerceDao.loadProducts();
		if(productMap!=null && productMap.get(productId)!=null) {
			Product product = productMap.get(productId);
			if(product.getProductDescription()!=null) {
				wineInfo = wineInfo.replace("#WINE_DESC#", product.getProductDescription());
			}
			if(product.getProductName()!=null) {
				wineInfo = wineInfo.replace("#WINE_NAME#", product.getProductName());
			}
			if(product.getProductCategory()!=null) {
				wineInfo = wineInfo.replace("#WINE_CATG#", product.getProductCategory());
			}
			if(product.getProductRating()!=null) {
				wineInfo = wineInfo.replace("#WINE_RATING#", Double.toString(product.getProductRating()));
			}
			if(product.getProductUnitSalePrice()!=null) {
				wineInfo = wineInfo.replace("#WINE_SALEPRICE#", Double.toString(product.getProductUnitSalePrice()));
			}
			if(product.getProductModel()!=null) {
				wineInfo = wineInfo.replace("#WINE_SALEPRICE#", product.getProductModel());
			}
		}
		return wineInfo;
	}
		public void checkoutProcess () {
		
		EcommerceDao ec= new EcommerceDao();
		Customer cust = new Customer();
		cust.setEmailID("temp");
		cust.setAddress(null);
		cust.setFullname(null);
		cust.setCity(null);
		cust.setCreditCardNo(0);
		cust.setCreditCardType(null);
		cust.setExpDate(null);
		cust.setMobNo(0);
		cust.setCVV(0);
		cust.setZip(0);
		cust.setState(null);
		
		ec.updateCheckoutTables(cust);
		
	}
}
