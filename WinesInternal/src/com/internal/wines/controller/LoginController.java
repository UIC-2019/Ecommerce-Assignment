package com.internal.wines.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.internal.wines.bean.Login;
import com.internal.wines.dao.WinesDao;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public LoginController() {
        super();
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String email = request.getParameter("email");
        String password = request.getParameter("password");
		
        try {
            if(null!=email && email!="" && password!=null && password!=""){
            	Login user = WinesDao.checkLogin(email, password);
            	
            	 if (user != null) {
            		 HttpSession  session=request.getSession(true);
                     session.setAttribute("email", email);
                     session.setAttribute("password", password);
                     response.sendRedirect("index.jsp"); 
                 } else {
                	 String message = "Invalid email/password";
                     request.setAttribute("message", message);
                     RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                     dispatcher.forward(request, response);
                 }
            	          
            }else{
            	 String message = "Email And/Or Password cannot be empty";
                 request.setAttribute("message", message);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                 dispatcher.forward(request, response);

            }
            } catch (SQLException | ClassNotFoundException ex) {
                throw new ServletException(ex);
            }
    }
}
