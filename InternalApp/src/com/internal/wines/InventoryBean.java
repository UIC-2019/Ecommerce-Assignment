package com.ims.utils;

public class InventoryBean implements java.io.Serializable { 
	

	private String inventoryid;
	private String productid;
	private String location;
	private Double stockqty;
	private Double unitprice;
	private String vendorid;

	/**
	 * @return the product
	 */
	public String getInventoryid() {
		return inventoryid;
	}

	/**
	 * @param product the product to set
	 */
	public void setInventoryid(String inventoryid) {
		this.inventoryid = inventoryid;
	}

	/**
	 * @return the productId
	 */
	public String getProductid() {
		return productid;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductid(String productid) {
		this.productid = productid;
	}

	/**
	 * @return the model
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param model the model to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the typeCode
	 */
	public String getVendorid() {
		return vendorid;
	}

	/**
	 * @param typeCode the typeCode to set
	 */
	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	/**
	 * @return the msrp
	 */
	public Double getStockqty() {
		return stockqty;
	}

	public void setStockqty(Double stockqty) {
		this.stockqty = stockqty;
	}

	/**
	 * @return the unitCost
	 */
	public Double getUnitprice() {
		return unitprice;
	}

	/**
	 * @param unitCost the unitCost to set
	 */
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public InventoryBean (String inventoryid, String productid, String location, Double stockqty, Double unitprice,String vendorid) {

		this.inventoryid=inventoryid;
		this.productid = productid;
		this.location=location;
		this.stockqty=stockqty;
		this.unitprice=unitprice;
		this.vendorid = vendorid;
		}
	
}

