package com.ims.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Vartika 
*/
public class EmployeeDAO {
	/**
	 * filetoMail
	 */
	private static File filetoMail;

	public static ArrayList<EmployeeBean> employeeList;
	
	public static ArrayList<EmployeeBean> loadEmployees(){
		try{
			employeeList = new ArrayList<EmployeeBean>();
			//connection is fetched from connection provider
			Connection con=ConnectionProvider.getCon();
			//query is done database
			PreparedStatement ps=con.prepareStatement("select * from Employees");
			ResultSet rs=ps.executeQuery();
			// code to load the result set in hash map
			EmployeeBean bean;
			//obtained results from DB is stored as list of InventoryBean
			while(rs.next()) {
				 bean = new EmployeeBean(rs.getString(2), rs.getString(1), rs.getString(3), 
					rs.getString(4), rs.getString(5), rs.getString(6));
				 employeeList.add(bean);
			}
			return employeeList;
		}catch(Exception e){
			e.getStackTrace();
		}
		return employeeList;
	}
	/**
	 * loadToFile
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void loadToFile() throws SQLException, IOException {
		//connection is fetched from connection provider
		Connection con=ConnectionProvider.getCon();
		//query is done database
		PreparedStatement ps=con.prepareStatement("select * from Employees");
		ResultSet rs=ps.executeQuery();
		FileWriter fstream = null;
		try {
			//Clean it before writing
			FileWriter fw = new FileWriter("FileToMail.txt");
			PrintWriter pw = new PrintWriter(fw);
			pw.write("");
			pw.flush();
			pw.close();
			//fetch the file
			filetoMail = new File("FileToMail.txt");
			fstream = new FileWriter(filetoMail);
			BufferedWriter out = new BufferedWriter(fstream);
			//start writing into file
			while (rs.next()) {
			        out.write(rs.getString(1).concat(Constants.recordDelimiter));
			        out.write(rs.getString(2) .concat(Constants.recordDelimiter));
			        out.write(rs.getString(3) .concat(Constants.recordDelimiter));
			        out.write(rs.getString(4) .concat(Constants.recordDelimiter));
			        out.write(rs.getString(5) .concat(Constants.recordDelimiter));
			        out.write(rs.getString(6) .concat(Constants.recordDelimiter));
			        out.newLine();
			}
			//close buffer writter
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public EmployeeDAO() {
		// TODO Auto-generated constructor stub
	}

}
