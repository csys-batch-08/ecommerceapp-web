package com.ecommerceshoe.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerceshoe.Dao.CartDao;
import com.ecommerceshoe.model.Order;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.model.cart;
import com.ecommerceshoe.util.ConnectionUtil;

public class CartDaoImpl implements CartDao {

	public int insertCart(cart carts) {

		String cartQuery = "insert into Cart_details(User_id,products_id,quantity,price) values (?,?,?,?)";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbconnection();
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			pstmt = con.prepareStatement(cartQuery);
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			int userId = userdao.findUserID(carts.getUser());
			ResultSet productId = productdao.findProductId(carts.getProduct());
			if (productId.next())
				pstmt.setInt(1, userId);
			pstmt.setInt(2, productId.getInt(1));
			pstmt.setInt(3, carts.getQuantity());
			pstmt.setDouble(4, carts.getPrice());

			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			// catch the exception and get that message
			e.printStackTrace();
			System.out.println("Value not Setted in the query");
		}

		return i;

	}

	public List<cart> showCart(Users user) {
		List<cart> cartList = new ArrayList<cart>();
		String showQuery = "select * from  Cart_details  where User_id=" + user.getUserid();
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		cart carts = null;
		try {
			Statement stmt = con.createStatement();
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			ResultSet rs = stmt.executeQuery(showQuery);
			while (rs.next()) {
				Users user1 = userdao.findUserId(rs.getInt(3));
				Product product = productdao.findProduct(rs.getInt(2));
				carts = new cart(product, user, rs.getInt(4), rs.getDouble(5));
				cartList.add(carts);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cartList;
	}

}
