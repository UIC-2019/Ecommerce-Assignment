package com.ims.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ims.bean.RegisterBean;
import com.ims.dao.LoginDao;

public class LoginServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        LoginDao userDao = new LoginDao();
         
		/*
		 * try { RegisterBean user = userDao.checkLogin(email, password); String
		 * destPage = "login.jsp";
		 * 
		 * if (user != null) { HttpSession session = request.getSession();
		 * session.setAttribute("user", user); destPage = "Home.jsp"; } else { String
		 * message = "Invalid email/password"; request.setAttribute("message", message);
		 * }
		 * 
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
		 * dispatcher.forward(request, response);
		 * 
		 * } catch (SQLException | ClassNotFoundException ex) { throw new
		 * ServletException(ex); }
		 */
        try {
            if(null!=email && email!="" && password!=null && password!=""){
            	RegisterBean user = userDao.checkLogin(email, password);
            	
            	 if (user != null) {
            		 HttpSession  session=request.getSession(true);
                     session.setAttribute("email", email);
                     session.setAttribute("password", password);
                     response.sendRedirect("Home.jsp"); 
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

