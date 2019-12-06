package com.internal.wines.bean;

public class Inventory {
	/**
	 * vendorID
	 */
	private String inventoryID;
	/**
	 * name
	 */
	private String productID;
	/**
	 * address
	 */
	private String location;
	/**
	 * city
	 */
	private String stockqty;
	/**
	 * state
	 */
	private String vendorID;
	public Inventory(String inventoryID, String productID, String location, String stockqty, String vendorID) {
		this.inventoryID = inventoryID;
		this.productID=productID;
		this.location=location;
		this.stockqty=stockqty;
		this.vendorID=vendorID;
	}
	public String getInventoryID() {
		return inventoryID;
	}
	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStockqty() {
		return stockqty;
	}
	public void setStockqty(String stockqty) {
		this.stockqty = stockqty;
	}
	public String getVendorID() {
		return vendorID;
	}
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	
}
