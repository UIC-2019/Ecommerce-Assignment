package com.ims.utils;

public class EmployeeBean {
	
	
	private String employeeid;
	private String name;
	private String role;
	private String department;
	private String email;
	private String password;
	

	/**
	 * @return the product
	 */
	public String getEmployeeid() {
		return employeeid;
	}

	/**
	 * @param product the product to set
	 */
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
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
	public void setname(String name) {
		this.name = name;
	}

	/**
	 * @return the model
	 */
	public String getrole() {
		return role;
	}

	/**
	 * @param model the model to set
	 */
	public void setrole(String role) {
		this.role = role;
	}

	/**
	 * @return the typeCode
	 */
	public String getdepartment() {
		return department;
	}

	/**
	 * @param typeCode the typeCode to set
	 */
	public void setdepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the msrp
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the unitCost
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param unitCost the unitCost to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public EmployeeBean (String employeeid, String name, String role, String department, String email,String password) {

		this.employeeid=employeeid;
		this.name = name;
		this.role=role;
		this.department=department;
		this.email=email;
		this.password = password;
		}
	
}


