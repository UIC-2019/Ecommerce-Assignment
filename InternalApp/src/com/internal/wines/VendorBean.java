package com.ims.utils;

public class VendorBean {
	
	
	private String vendorid;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	

	/**
	 * @return the product
	 */
	public String getVendorid() {
		return vendorid;
	}

	/**
	 * @param product the product to set
	 */
	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}

	/**
	 * @return the productId
	 */
	public String getname() {
		return name;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the model
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param model the model to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the typeCode
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param typeCode the typeCode to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the msrp
	 */
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the unitCost
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param unitCost the unitCost to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the discountRate
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param discountRate the discountRate to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public VendorBean (String vendorid, String name, String address, String city,  String state, String zip, String phone) {
		this.vendorid = vendorid;
		this.name=name;
		this.address=address;
		this.city = city;
		this.state=state;
		this.zip=zip;
		this.phone=phone;
		}
	
}


