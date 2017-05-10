package com.revature.util;

import java.sql.*;

//gabesdb.cjtggskfwx5n.us-west-2.rds.amazonaws.com

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "chinook";
		String password = "p4ssw0rd";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, username, password);
	}
}
