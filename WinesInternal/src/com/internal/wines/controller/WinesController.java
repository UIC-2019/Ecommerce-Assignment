package com.internal.wines.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.internal.wines.bean.Employee;
import com.internal.wines.bean.Inventory;
import com.internal.wines.bean.Order;
import com.internal.wines.bean.Vendor;
import com.internal.wines.impl.WinesImpl;



public class WinesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * vendorList holds Vendor data
	 */
	public ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
	/**
	 * orderList holds Order data
	 */
	public ArrayList<Order> orderList = new ArrayList<Order>();
	/**
	 * inventoryList holds Inventory data
	 */
	public ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
	/**
	 * employeeList holds Employee data
	 */
	public ArrayList<Employee> employeeList = new ArrayList<Employee>();
	WinesImpl impl = new WinesImpl();
	/**
	 * vendorList
	 * @return list of fetchVendors objects
	 */
	public ArrayList<Vendor>fetchVendors(){
		/**call to fetchVendors
		 * 
		 */
		vendorList = impl.fetchVendors();
		return vendorList;
	}
	/**
	 * vendorList
	 * @return list of fetchVendors objects
	 */
	public ArrayList<Order>fetchOrders(){
		/**call to fetchOrders
		 * 
		 */
		orderList = impl.fetchOrders();
		return orderList;
	}
	/**
	 * inventoryList
	 * @return list of fetchInventory objects
	 */
	public ArrayList<Inventory>fetchInventory(){
		/**call to fetchInventory
		 * 
		 */
		inventoryList = impl.fetchInventory();
		return inventoryList;
	}
	/**
	 * employeeList
	 * @return list of fetchInventory objects
	 */
	public ArrayList<Employee>fetchEmployees(){
		/**call to employeeList
		 * 
		 */
		employeeList = impl.fetchEmployees();
		return employeeList;
	}
	/**
	 * doPost
	 * request and response object set
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
