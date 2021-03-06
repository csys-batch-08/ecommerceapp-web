package com.ecommerceshoe.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ecommerceshoe.Dao.CartDao;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.model.Cart;
import com.ecommerceshoe.util.ConnectionUtil;

public class CartDaoImpl implements CartDao {
	public int insertCart(Cart carts) {
		String cartQuery = "insert into Cart_details(User_id,products_id,quantity,price) values (?,?,?,?)";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		int i = 0;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(cartQuery);
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			int userId = userdao.findUserID(carts.getUser());
			int productId = productdao.findProductId(carts.getProduct());
			preparedstatement.setInt(1, userId);
			preparedstatement.setInt(2, productId);
			preparedstatement.setInt(3, carts.getQuantity());
			preparedstatement.setDouble(4, carts.getPrice());
			i = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return i;
	}

	public List<Cart> showCart(Users user) {
		List<Cart> cartList = new ArrayList<>();
		String showQuery = "select Cartitems_id,products_id,User_id,quantity,price from  Cart_details  where User_id=? ";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		Cart carts = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(showQuery);
			preparedstatement.setInt(1, user.getUserid());
			UserDaoImpl userdao = new UserDaoImpl();
			ProductDaoImpl productdao = new ProductDaoImpl();
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				Users users = userdao.findUserId(resultset.getInt(3));
				Product product = productdao.findProduct(resultset.getInt(2));
				carts = new Cart(product, user, resultset.getInt(4), resultset.getDouble(5));
				cartList.add(carts);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return cartList;
	}

}
