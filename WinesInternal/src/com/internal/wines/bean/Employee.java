package com.internal.wines.bean;

public class Employee {
	/**
	 * vendorID
	 */
	private String employeeID;
	/**
	 * name
	 */
	private String name;
	/**
	 * address
	 */
	private String role;
	/**
	 * city
	 */
	private String department;
	public Employee(String employeeID, String name, String role, String department) {
		this.employeeID=employeeID;
		this.name=name;
		this.role=role;
		this.department=department;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		employeeID = employeeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		role = role;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		department = department;
	}
}
