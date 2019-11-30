package com.ecommerce.dao;

import static com.ecommerce.dao.DBCredentials.CONNECTION_URL;
import static com.ecommerce.dao.DBCredentials.DRIVER;
import static com.ecommerce.dao.DBCredentials.PASSWORD;
import static com.ecommerce.dao.DBCredentials.USERNAME;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * DBConnection is obtained and returned in this class.
 */
public class DBConnection {
	static Connection con=null;
	static{
		try{
			Class.forName(DRIVER);
			con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
			}catch(SQLException | ClassNotFoundException e){
				e.printStackTrace();
			}
	}
	public static Connection getCon(){
		return con;
	}
}
