//RegisterDao.java
package com.ims.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ims.bean.RegisterBean;
import com.ims.utils.ConnectionProvider;

public class RegisterDao {
	public String registerUser(RegisterBean registerBean)
	{
		String FullName = registerBean.getFullName();
		String email = registerBean.getEmail();
		String password = registerBean.getPassword();
		PreparedStatement preparedStatement = null;
		try
		{
			Connection con=ConnectionProvider.getCon();
			String query = "insert into Users(EmailId,Password,FullName) values (?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, FullName);
			int i= preparedStatement.executeUpdate();
			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}
}