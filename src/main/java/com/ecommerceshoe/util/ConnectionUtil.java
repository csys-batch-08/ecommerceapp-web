package com.ecommerceshoe.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
	public static  Connection getDbconnection() {
		Connection con = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return con;

	}
	public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultset
			) {
		try {
			if (resultset != null) {
				resultset.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
			if (connection != null) {
				connection.close();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
