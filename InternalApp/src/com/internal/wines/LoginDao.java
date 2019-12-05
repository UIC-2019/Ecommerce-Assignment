//LoginDao.java
package com.ims.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ims.bean.RegisterBean;
import com.ims.utils.ConnectionProvider;

public class LoginDao {
	
	Connection con = null;
	
	public RegisterBean checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
		Connection con=ConnectionProvider.getCon();
		String sql = "SELECT * FROM Employees WHERE Email = ? and Password = ?"; //Insert user details into the table 'USERS'
		PreparedStatement statement = con.prepareStatement(sql); //Making use of prepared statements here to insert bunch of data
		statement.setString(1, email);
		statement.setString(2, password);
		
		ResultSet result = statement.executeQuery();

		RegisterBean user = null;

		if (result.next()) {
			user = new RegisterBean();
			user.setEmail(email);
		}
		return user;
	}
}