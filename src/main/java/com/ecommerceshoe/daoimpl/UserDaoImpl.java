package com.ecommerceshoe.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ecommerceshoe.Dao.UserDao;
import com.ecommerceshoe.model.Admin;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public int inserUser(Users user) {
		ConnectionUtil conUtil = new ConnectionUtil();
		String insertQuery = "insert into  users1(Name,password,mobile_no,email_id,Address,wallet) values(?,?,?,?,?,?)";
		Connection connection = conUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int i = 0;
		try {

			preparedstatement = connection.prepareStatement(insertQuery);
			preparedstatement.setString(1, user.getName());
			preparedstatement.setString(2, user.getPassword());
			preparedstatement.setLong(3, user.getMobileNo());
			preparedstatement.setString(4, user.getEmail());
			preparedstatement.setString(5, user.getAddress());
			preparedstatement.setDouble(6, user.getWallet());
			i = preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// catch the exception and get that message
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return i;
	}

	public Users validateUser(String email, String password) {
		String validateQuery = "select user_id,Name, password,mobile_no, email_id ,Address,wallet from users1 where email_id = ? and password = ? ";
		ConnectionUtil conUtil;
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		Users user = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(validateQuery);
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, password);
			resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				user = new Users(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getLong(4), resultset.getString(5), resultset.getString(6), resultset.getDouble(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return user;
	}

	public int findUserID(Users user) {
		String findId = "select user_id from Users1 where email_id=?";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int id = 0;
		try {
			preparedstatement = connection.prepareStatement(findId);
			preparedstatement.setString(1, user.getEmail());
			resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				id = resultset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return id;
	}

	public Users findUser(String email) {
		String Query1 = "select  user_id,Name, password,mobile_no, email_id ,Address,wallet from Users1 where email_id= ?";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		Users user = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(Query1);
			preparedstatement.setString(1, email);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				user = new Users(resultset.getString(2), resultset.getString(3), resultset.getLong(4),
						resultset.getString(5), resultset.getString(6), resultset.getDouble(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return user;
	}

	public int updateuserWallet(Users user, double amount) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection connection = ConnectionUtil.getDbconnection();
		String query = "update users1 set wallet=wallet+? where email_id=?";
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int i = 0;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setDouble(1, amount);
			preparedstatement.setString(2, user.getEmail());
			i = preparedstatement.executeUpdate();
			user.setWallet(user.getWallet() + amount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return i;
	}

	public int Walletupdate(double OrderPrices, Users user) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection connection = ConnectionUtil.getDbconnection();
		String query = "update users1 set wallet=wallet-? where email_id=?";
		String getWalletquery = "select wallet from users1 where email_id=?";
		String commit = "commit";
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int a = 0;
		try {
			preparedstatement = connection.prepareStatement(getWalletquery);
			preparedstatement.setString(1, user.getEmail());
			resultset = preparedstatement.executeQuery();
			double wallet = 0;
			if (resultset.next()) {
				wallet = resultset.getDouble(1);
			}
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setDouble(1, OrderPrices);
			preparedstatement.setString(2, user.getEmail());
			a = preparedstatement.executeUpdate();
			user.setWallet(user.getWallet() - OrderPrices);
			preparedstatement = connection.prepareStatement(commit);
			a = preparedstatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return a;
	}

	public Users findUserId(int id) {
		String query1 = "select  user_id,Name, password,mobile_no, email_id ,Address,wallet from Users1 where user_id= ? ";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		Users user = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(query1);
			preparedstatement.setInt(1, id);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				user = new Users(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getLong(4), resultset.getString(5), resultset.getString(6), resultset.getDouble(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return user;
	}

	public boolean RefundWallet(Users user, double price) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection connection = ConnectionUtil.getDbconnection();
		UserDaoImpl userdao = new UserDaoImpl();
		int userId = userdao.findUserID(user);
		String updateQuery1 = "update Users1 set wallet=? where user_id=?";
		boolean flag = false;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(updateQuery1);
			preparedstatement.setDouble(1, user.getWallet() + price);
			preparedstatement.setInt(2, userId);
			flag = preparedstatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return flag;
	}

}
