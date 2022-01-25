package com.ecommerceshoe.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ecommerceshoe.Dao.OrderDao;
import com.ecommerceshoe.model.Order;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.util.ConnectionUtil;

public class OrderDaoImpl implements OrderDao {
	public int insertOrder(Order orders) {

		String orderQuery = "insert into Orders_details(User_id,products_id,Quantity,Price,order_date) values (?,?,?,?,sysdate) ";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbconnection();
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			pstmt = con.prepareStatement(orderQuery);
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			int userId = userdao.findUserID(orders.getUser());
			ResultSet productId = productdao.findProductId(orders.getProduct());
			if (productId.next())
				pstmt.setInt(1, userId);
			pstmt.setInt(2, productId.getInt(1));
			pstmt.setInt(3, orders.getQuantity());
			pstmt.setDouble(4, orders.getPrice());
			// pstmt.setDate(5, new java.sql.Date(orders.getOrderDate().getTime()));
			i = pstmt.executeUpdate();
			return i;
		} catch (SQLException e) {
			// catch the exception and get that message
			e.printStackTrace();
			System.out.println("Value not Setted in the query");
		}

		return i;

	}

	public List<Order> ShowOrder(Users user) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbconnection();
		System.out.println(user.getUserid());
		List<Order> orderList = new ArrayList<Order>();
		String Query = "select * from Orders_details where User_id='" + user.getUserid() + "'";
		Statement stmt;
		Order order = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();

			while (rs.next()) {

				Users user1 = userdao.findUserId(rs.getInt(3));
				Product product = productdao.findProduct(rs.getInt(2));
				order = new Order(rs.getInt(1), product, user1, rs.getInt(4), rs.getDouble(5), rs.getDate(6),
						rs.getString(7));
				orderList.add(order);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return orderList;
	}

	public boolean orderCancel(int order_id) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbconnection();
		String query = "update Orders_details set status='cancel' where Order_id='" + order_id + "'";
		Statement stmt;
		boolean b = false;
		try {
			stmt = con.createStatement();
			b = stmt.executeUpdate(query) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;

	}
	public ResultSet TotalAmount(Date fromDate,Date toDate) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbconnection();
		String Query="select products_id,sum(price) from  Orders_details where status='delivered' and order_date between ? and ? group BY products_id";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = con.prepareStatement (Query);
			pstmt.setDate(1, new java.sql.Date(fromDate.getTime()));
			pstmt.setDate(2, new java.sql.Date(toDate.getTime()));
			rs=pstmt.executeQuery();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
		
	}
	public List<Order> ShowOrder() {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbconnection();
		
		List<Order> orderList = new ArrayList<Order>();
		String Query = "select * from Orders_details";
		Statement stmt;
		Order order = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();

			while (rs.next()) {

				Users user1 = userdao.findUserId(rs.getInt(3));
				Product product = productdao.findProduct(rs.getInt(2));
				order = new Order(rs.getInt(1), product, user1, rs.getInt(4), rs.getDouble(5), rs.getDate(6),
						rs.getString(7));
				orderList.add(order);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return orderList;
	}
	public boolean statuschange(int order_id) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbconnection();
		String query = "update Orders_details set status='delivered' where Order_id=" + order_id;
		Statement stmt;
		boolean b = false;
		try {
			stmt = con.createStatement();
			b = stmt.executeUpdate(query) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;

	}

}
