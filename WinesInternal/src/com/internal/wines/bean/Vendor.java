package com.internal.wines.bean;

public class Vendor {
	/**
	 * vendorID
	 */
	private String vendorID;
	/**
	 * name
	 */
	private String name;
	/**
	 * address
	 */
	private String address;
	/**
	 * city
	 */
	private String city;
	/**
	 * state
	 */
	private String state;
	/**
	 * zip
	 */
	private String zip;
	/**
	 * phone
	 */
	private String phone;
	
	public Vendor(String vendorID, String name, String address, String city, String state, String zip,
			String phone) {
		this.vendorID=vendorID;
		this.address=address;
		this.name=name;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone=phone;
	}
	public String getVendorID() {
		return vendorID;
	}
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
