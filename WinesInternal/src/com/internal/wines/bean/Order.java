package com.internal.wines.bean;

public class Order {
	/**
	 * orderID
	 */
	private String orderID;
	/**
	 * orderDate
	 */
	private String orderDate;
	/**
	 * productID
	 */
	private String productID;
	/**
	 * Quantity
	 */
	private String quantity;
	/**
	 * unitSalePrice
	 */
	private String unitSalePrice;
	/**
	 * TotalPrice
	 */
	private String totalPrice;
	/**
	 * email
	 */
	private String email;
	/**
	 * orderLink
	 */
	private String orderLink;
	/**
	 * status
	 */
	private String status;
	public Order(String orderID, String orderDate, String productID, String quantity, String unitSalePrice, String totalPrice,
			String email, String orderLink, String status) {
		this.orderID=orderID;
		this.orderDate = orderDate;
		this.productID = productID;
		this.quantity=quantity;
		this.unitSalePrice=unitSalePrice;
		this.totalPrice=totalPrice;
		this.email=email;
		this.orderLink=orderLink;
		this.status=status;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		quantity = quantity;
	}
	public String getUnitSalePrice() {
		return unitSalePrice;
	}
	public void setUnitSalePrice(String unitSalePrice) {
		this.unitSalePrice = unitSalePrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		totalPrice = totalPrice;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrderLink() {
		return orderLink;
	}
	public void setOrderLink(String orderLink) {
		this.orderLink = orderLink;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
