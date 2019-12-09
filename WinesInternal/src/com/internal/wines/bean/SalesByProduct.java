package com.internal.wines.bean;

public class SalesByProduct {
	
	
	private String productId;
	
	private Integer quantitySold;
	
	private String productName;
	
	private String percentageOfTotalSale;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(Integer quantitySold) {
		this.quantitySold = quantitySold;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPercentageOfTotalSale() {
		return percentageOfTotalSale;
	}

	public void setPercentageOfTotalSale(String percentageOfTotalSale) {
		this.percentageOfTotalSale = percentageOfTotalSale;
	}

}
