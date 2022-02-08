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
		String orderQuery = "insert into Orders_details(User_id,products_id,Quantity,Price,order_date)"
				+ " values (?,?,?,?,sysdate) ";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		int i = 0;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(orderQuery);
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			int userId = userdao.findUserID(orders.getUser());
			int productId = productdao.findProductId(orders.getProduct());
			preparedstatement.setInt(1, userId);
			preparedstatement.setInt(2, productId);
			preparedstatement.setInt(3, orders.getQuantity());
			preparedstatement.setDouble(4, orders.getPrice());
			i = preparedstatement.executeUpdate();
			return i;
		} catch (SQLException e) {
			// catch the exception and get that message
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return i;
	}

	public List<Order> ShowOrder(Users user) {
		Connection connection = ConnectionUtil.getDbconnection();
		List<Order> orderList = new ArrayList<>();
		String query = "select Order_id,products_id,User_id, Quantity,Price,order_date,Status from Orders_details "
				+ "where User_id= ?";
		PreparedStatement preparedstatement = null;
		Order order = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, user.getUserid());
			resultset = preparedstatement.executeQuery();
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			while (resultset.next()) {
				Users user1 = userdao.findUserId(resultset.getInt(3));
				Product product = productdao.findProduct(resultset.getInt(2));
				order = new Order(resultset.getInt(1), product, user1, resultset.getInt(4), resultset.getDouble(5),
						resultset.getDate(6), resultset.getString(7));
				orderList.add(order);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return orderList;
	}

	public boolean orderCancel(int order_id) {
		
		Connection connection = ConnectionUtil.getDbconnection();
		String query = "update Orders_details set status='cancel' where Order_id=?";
		PreparedStatement preparedstatement = null;
		boolean b = false;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, order_id);
			b = preparedstatement.executeUpdate() > 0;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return b;
	}

	public List<Object> TotalAmount(Date fromDate, Date toDate) {
		Connection connection = ConnectionUtil.getDbconnection();
		String query = "select products_id,sum(price) as price from  Orders_details where status='delivered' and order_date between ? and ? group BY products_id";
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		List<Object> list = null;
		List<Object> listObject = null;
		Order order = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setDate(1, new java.sql.Date(fromDate.getTime()));
			preparedstatement.setDate(2, new java.sql.Date(toDate.getTime()));
			list = new ArrayList<>();
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				listObject = new ArrayList<>();
				listObject.add(resultset.getInt("products_id"));
				listObject.add(resultset.getDouble("price"));
				list.add(listObject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return list;
	}

	public List<Order> ShowOrder() {
		Connection connection = ConnectionUtil.getDbconnection();
		List<Order> orderList = new ArrayList<Order>();
		String query = "select  Order_id,products_id,User_id, Quantity,Price,order_date,Status from Orders_details";
		PreparedStatement preparedstatement = null;
		Order order = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			while (resultset.next()) {
				Users user1 = userdao.findUserId(resultset.getInt(3));
				Product product = productdao.findProduct(resultset.getInt(2));
				order = new Order(resultset.getInt(1), product, user1, resultset.getInt(4), resultset.getDouble(5),
						resultset.getDate(6), resultset.getString(7));
				orderList.add(order);
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return orderList;
	}

	public boolean statuschange(int order_id) {
		Connection connection = ConnectionUtil.getDbconnection();
		String query = "update Orders_details set status='delivered' where Order_id=? ";
		PreparedStatement preparedstatement=null;
		ResultSet resultset = null;
		boolean b = false;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, order_id);
			b = preparedstatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return b;
	}

	public List<Order> ShowBill(Users user) {
		Connection connection =ConnectionUtil.getDbconnection();
		List<Order> orderList = new ArrayList<>();
		String query = "select  Order_id,products_id,User_id, Quantity,Price,order_date,Status from Orders_details where user_id=?  order by Order_id desc fetch first 1 row only";
		PreparedStatement preparedstatement = null;
		Order order = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, user.getUserid());
			resultset = preparedstatement.executeQuery();
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			while (resultset.next()) {
				Users user1 = userdao.findUserId(resultset.getInt(3));
				Product product = productdao.findProduct(resultset.getInt(2));
				order = new Order(resultset.getInt(1), product, user1, resultset.getInt(4), resultset.getDouble(5),
						resultset.getDate(6), resultset.getString(7));
				orderList.add(order);
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return orderList;
	}

}
