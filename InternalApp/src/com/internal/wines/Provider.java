package com.ims.utils;

public interface Provider {
	String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String CONNECTION_URL = "jdbc:sqlserver://localhost;databaseName=winestoredb"; // sqlims is the name of database instance you will
																	// create on local machine.
	String USERNAME = "admin1";//create a user by the name system with super privileges
	String PASSWORD = "Test1234"; //create the password for the user as sqlserver.
}