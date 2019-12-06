package com.internal.wines.impl;

import java.util.ArrayList;

import com.internal.wines.bean.Employee;
import com.internal.wines.bean.Inventory;
import com.internal.wines.bean.Order;
import com.internal.wines.bean.Vendor;
import com.internal.wines.dao.WinesDao;

public class WinesImpl {
	/**
	 * WinesDao initialized
	 */
	WinesDao dao = new WinesDao();
	/**
	 * vendorList holds vendorList data
	 */
	public ArrayList<Vendor>fetchVendors(){
		ArrayList<Vendor> vendorList = 	dao.loadVendors();
		return vendorList;
	}
	/**
	 * vendorList holds Order data
	 */
	public ArrayList<Order>fetchOrders(){
		ArrayList<Order> orderList = 	dao.loadOrders();
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
		ArrayList<Inventory> inventoryList = dao.loadInventory();
		return inventoryList;
	}
	/**
	 * employeeList
	 * @return list of fetchEmployees objects
	 */
	public ArrayList<Employee>fetchEmployees(){
		/**call to employeeList
		 * 
		 */
		ArrayList<Employee>employeeList = dao.loadEmployee();
		return employeeList;
	}
}
