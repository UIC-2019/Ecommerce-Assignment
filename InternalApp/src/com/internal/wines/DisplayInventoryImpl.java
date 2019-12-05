/**
 * 
 */
package com.ims.impl;

import java.util.ArrayList;

import com.ims.utils.EmployeeBean;
import com.ims.utils.EmployeeDAO;
import com.ims.utils.VendorDAO;
import com.ims.utils.InventoryBean;
import com.ims.utils.InventoryDAO;
import com.ims.utils.VendorBean;

/**
 * @author Vartika
 *
 */
public class DisplayInventoryImpl {
	/**
	 * InventoryDAO initialized
	 */
InventoryDAO dao = new InventoryDAO();
EmployeeDAO empdao = new EmployeeDAO();
VendorDAO vendao = new VendorDAO();
	/**
	 * 
	 */
	public DisplayInventoryImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * inventoryList of InventoryBean sent to controller
	 * @return
	 */
	public ArrayList<InventoryBean> loadInventory() {
		ArrayList<InventoryBean> inventoryList = 	dao.loadInventory();
		return inventoryList;
	}
	public ArrayList<EmployeeBean> loadEmployees() {
		ArrayList<EmployeeBean> employeeList = 	empdao.loadEmployees();
		return employeeList;
	}
	public ArrayList<VendorBean> loadVendors() {
		ArrayList<VendorBean> vendorList = 	vendao.loadVendors();
		return vendorList;
	}

}
