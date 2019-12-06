package com.internal.wines.dao;

import static com.internal.wines.dao.Provider.DRIVER;
import static com.internal.wines.dao.Provider.PASSWORD;
import static com.internal.wines.dao.Provider.USERNAME;
import static com.internal.wines.dao.Provider.CONNECTION_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
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
