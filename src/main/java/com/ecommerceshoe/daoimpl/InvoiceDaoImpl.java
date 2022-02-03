package com.ecommerceshoe.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecommerceshoe.Dao.InvoiceDao;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.util.ConnectionUtil;

public class InvoiceDaoImpl implements InvoiceDao {
	public ResultSet showBill(Users user) {

		String showQuery = "select u.name,u.mobile_no,u.email_id,u.address,o.products_id,o.quantity,o.price,o.order_date from users1 u join Orders_details o on u.user_id=o.user_id";

		Connection connection = ConnectionUtil.getDbconnection();
		ResultSet resultset = null;
		try {
			Statement statement = connection.createStatement();
			resultset = statement.executeQuery(showQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultset;

	}
}
