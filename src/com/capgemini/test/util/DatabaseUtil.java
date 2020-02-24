package com.capgemini.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	static Connection connection;
	
	static{
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection myConnection() throws SQLException{
		if(connection==null)
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
	return connection;
	}
}
