package com.ecommerceshoe.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecommerceshoe.Dao.AdminDao;
import com.ecommerceshoe.model.Admin;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.util.ConnectionUtil;

public class AdminDaoImpl implements AdminDao {
	public Admin validateAdmin(String email, String password) {
		String adminQuery = "select admin_email,password from admins where admin_email =? and password=? ";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Admin admin = null;
		try {
			preparedstatement = connection.prepareStatement(adminQuery);
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, password);
			resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				admin = new Admin(resultset.getString(1), resultset.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return admin;
	}
	
}
