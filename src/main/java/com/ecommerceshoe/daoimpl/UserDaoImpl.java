package com.ecommerceshoe.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerceshoe.Dao.UserDao;
import com.ecommerceshoe.model.Admin;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public int inserUser(Users user) {
		ConnectionUtil conUtil = new ConnectionUtil();
		String insertQuery = "insert into  users1(Name,password,mobile_no,email_id,Address,wallet) values(?,?,?,?,?,?)";
		Connection con = conUtil.getDbconnection();
		PreparedStatement pstmt = null;
		int i = 0;
		try {

			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setLong(3, user.getMobileNo());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getAddress());
			pstmt.setDouble(6, user.getWallet());
			i = pstmt.executeUpdate();
			System.out.println(i + "Value Inserted Successfully");

		} catch (SQLException e) {
			// catch the exception and get that message
			e.printStackTrace();
			System.out.println("Value not Setted in the query");
		}
		return i;
	}

	public Users validateUser(String email, String password) {
		String validateQuery = "select user_id,Name, password,mobile_no, email_id ,Address,wallet from users1 where email_id = ? and password = ? ";
		ConnectionUtil conUtil;
		Connection con = ConnectionUtil.getDbconnection();

		PreparedStatement stmt = null;
		Users user = null;
		try {
			stmt = con.prepareStatement(validateQuery);
			stmt.setString(1,email);
			stmt.setString(2,password);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(2)+" "+rs.getLong(3));

				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5 ), rs.getString(6),
						rs.getDouble(7));
				System.out.println(user);
			}

		} catch (SQLException e) {
			// T5ODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		}
		return user;
	}

	public int findUserID(Users user) {
		String findId = "select user_id from Users1 where email_id='" + user.getEmail() + "'";
		Connection con = ConnectionUtil.getDbconnection();
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(findId);
			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}

	public Users findUser(String email) {
		String Query1 = "select  * from Users1 where email_id=? ";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		PreparedStatement stmt = null;
		Users user = null;
		try {
			stmt = con.prepareStatement(Query1);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// System.out.println(rs.getString(2)+" "+rs.getLong(3));

				user = new Users(rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6),
						rs.getDouble(7));
				System.out.println(user);
			}

		} catch (SQLException e) {
			// T5ODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		}

		return user;

	}

	public int updateuserWallet(Users user, double amount) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		String Query = "update users1 set wallet=wallet+? where email_id=?";
//		String getWalletquery="select wallet from users1 where email_id=?";
		PreparedStatement pstmt = null;
		int i = 0;
		try {
//		  pstmt = con.prepareStatement(getWalletquery);
//			pstmt.setString(1,user.getEmail());
//			System.out.println(user.getEmail());
//	       ResultSet rs=pstmt.executeQuery();
//	       double wallet=0;
//	       if(rs.next()) {
//	    	   wallet=rs.getDouble(1);
//	    	   System.out.println(wallet);
//	       } 
			System.out.println(user.getWallet());
			pstmt = con.prepareStatement(Query);
			pstmt.setDouble(1, amount);
			pstmt.setString(2, user.getEmail());
			i = pstmt.executeUpdate();
			System.out.println(i + "updated");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return i;

	}

	public int Walletupdate(double OrderPrices, Users user) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		System.out.println(OrderPrices);
		String Query = "update users1 set wallet=wallet-? where email_id=?";
		String getWalletquery = "select wallet from users1 where email_id=?";
		String commit = "commit";
		PreparedStatement pstmt = null;
		int a = 0;
		try {
			pstmt = con.prepareStatement(getWalletquery);

			pstmt.setString(1, user.getEmail());
			ResultSet rs = pstmt.executeQuery();
			double wallet = 0;
			if (rs.next()) {
				wallet = rs.getDouble(1);
			}
			pstmt = con.prepareStatement(Query);
			pstmt.setDouble(1, OrderPrices);
			pstmt.setString(2, user.getEmail());
			a = pstmt.executeUpdate();
			System.out.println(a + "updated");
			pstmt = con.prepareStatement(commit);
			a = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return a;

	}

	public Users findUserId(int id) {
		String Query1 = "select  * from Users1 where user_id= ?";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		PreparedStatement stmt = null;
		Users user = null;
		try {
			stmt = con.prepareStatement(Query1);
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				// System.out.println(rs.getString(2)+" "+rs.getLong(3));

				user = new Users(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getString(6),
						rs.getDouble(7));
				// System.out.println(user);
			}

		} catch (SQLException e) {
			// T5ODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Statement error");
		}
		// TODO Auto-generated method stub
		return user;
	}

	public boolean RefundWallet(Users user, double price) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		UserDaoImpl userdao = new UserDaoImpl();
		int userId = userdao.findUserID(user);
		String updateQuery1 = "update Users1 set wallet='" + (user.getWallet() + price) + "'where user_id='" + userId
				+ "'";
		boolean flag = false;
		try {
			Statement stmt = con.createStatement();
			flag = stmt.executeUpdate(updateQuery1) > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;

	}

}
