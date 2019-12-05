/**
 * 
 */
package com.ims.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ims.impl.DisplayInventoryImpl;
import com.ims.impl.EmailMenuImpl;
import com.ims.utils.EmployeeBean;
import com.ims.utils.InventoryBean;
import com.ims.utils.VendorBean;

/**
 * @author Vartika 
 * 		   This class is an interface between jsp and actual logic
 *         implementation classes. It will have methods to call implementation
 *         classes for subsequent logic operations.
 */

public class Controller extends HttpServlet {
private static final long serialVersionUID = 1L;
/**
 * inventoryList holds inventory data
 */
public ArrayList<InventoryBean> inventoryList = new ArrayList<InventoryBean>();
public ArrayList<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
public ArrayList<VendorBean> vendorList = new ArrayList<VendorBean>();
/**
 * DisplayInventoryImpl initialized
 */
public DisplayInventoryImpl display = new DisplayInventoryImpl();
/**
 * EmailMenuImpl initialized
 */
public EmailMenuImpl mail = new EmailMenuImpl();
	/**
	 * constructor
	 */
	public Controller() {
		super();
	}
	/**
	 * showInventory
	 * @return list of InventoryBean objects
	 */
	public ArrayList<InventoryBean>showInventory(){
		/**call to DisplayInventoryImpl
		 */
		inventoryList = display.loadInventory();
			return inventoryList;
	}
	
	public ArrayList<EmployeeBean>showEmployees(){
		/**call to DisplayInventoryImpl
		 */
		employeeList = display.loadEmployees();
			return employeeList;
	}
	
	public ArrayList<VendorBean>showVendors(){
		/**call to DisplayInventoryImpl
		 */
		vendorList = display.loadVendors();
			return vendorList;
	}
	/**
	 * doPost
	 * request and response object set
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//email is read from jsp 
		String senderEmail = request.getParameter("email");
    	if(senderEmail!=null) {
    		//call to EmailMenuImpl
            String status =  mail.sendEmail(senderEmail);
            /**
             * if mail is sent successfully/error message is set 
             * in request to send back the message to jsp
             */
            if (status.equalsIgnoreCase("success")) {
                String message = "Email is sent successfully";
                request.setAttribute("message", message);
                request.setAttribute("senderEmail", senderEmail);
            } else {
                String message = "Email not sent,Please retry";
                request.setAttribute("message", message);
            }
    	}
    	/**
    	 * destination page is set ,request/reponse is forwarded to that page
    	 */
         String destPage = "/email.jsp";
         request.getRequestDispatcher(destPage).forward(request, response);
    }
}
