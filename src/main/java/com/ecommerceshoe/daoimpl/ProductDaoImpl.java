package com.ecommerceshoe.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ecommerceshoe.Dao.ProductDao;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.util.ConnectionUtil;

public class ProductDaoImpl implements ProductDao {
	public int inserproduct(String brandName, String brandType, int brandSize, String color, double prices,
			Date manufactureDate) {
		String insertQuery = "insert into  Product(Brand_name,Brand_type,Brand_size,color,prices,manufacture_date) values(?,?,?,?,?,?)";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int i = 0;
		try {
			preparedstatement = connection.prepareStatement(insertQuery);
			preparedstatement.setString(1, brandName);
			preparedstatement.setString(2, brandType);
			preparedstatement.setInt(3, brandSize);
			preparedstatement.setString(4, color);
			preparedstatement.setDouble(5, prices);
			preparedstatement.setDate(6, new java.sql.Date(manufactureDate.getTime()));

			i = preparedstatement.executeUpdate();

		} catch (SQLException e) {
	
			e.printStackTrace();
			
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return i;
	}

	public int updated(int brandSize, double prices, int productId) {
		String updateQuery = "update Product set Brand_size=?,prices=? where products_id=? ";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int i1 = 0;
		try {

			preparedstatement = connection.prepareStatement(updateQuery);
			preparedstatement.setInt(1, brandSize);
			preparedstatement.setDouble(2, prices);
			preparedstatement.setInt(3, productId);
			i1 = preparedstatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return i1;
	}

	public int delete(int productId) {
		String query = "select status from  Product where products_id=?";
		String deleteQuery = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		String status = null;
		int i2 = 0;
		ResultSet resultset = null;
		try {
			connection = ConnectionUtil.getDbconnection();
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, productId);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				status = resultset.getString("status");
			}
			if (status != null && status.equalsIgnoreCase("available")) {
				deleteQuery = "update Product set status='unavailable' where products_id=?";
			} else {
				deleteQuery = "update Product set status='available' where products_id=?";
			}
			preparedstatement = connection.prepareStatement(deleteQuery);
			preparedstatement.setInt(1, productId);
			i2 = preparedstatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		
		return i2;
	}

	public List<Product> showProduct() {
		List<Product> productsList = new ArrayList<Product>();
		String showQuery = "select products_id,Brand_name,Brand_type,Brand_size,color,prices,manufacture_date,status from Product";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Product products = null;
		try {
			preparedstatement = connection.prepareStatement(showQuery);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				products = new Product(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getInt(4), resultset.getString(5), resultset.getDouble(6), resultset.getDate(7));
				products.setStatus(resultset.getString(8));
				productsList.add(products);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return productsList;
	}

	public int findProductId(Product product) {
		String query = "select products_id  from Product where Brand_name=? and Brand_type=? and Brand_size=? and color=? ";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		int productId = 0;

		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, product.getBrandName());
			preparedstatement.setString(2, product.getBrandType());
			preparedstatement.setInt(3, product.getBrandSize());
			preparedstatement.setString(4, product.getColor());
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				productId = resultset.getInt(1);
			}

		} catch (SQLException e1) { 
			e1.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return productId;

	}

	public double findPrice(Product product) {
		String query = "select prices from Product where Brand_name=? and Brand_type=? and Brand_size=? and color=? ";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		double price = 0;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, product.getBrandName());
			preparedstatement.setString(2, product.getBrandType());
			preparedstatement.setInt(3, product.getBrandSize());
			preparedstatement.setString(4, product.getColor());
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				price = resultset.getInt(1);
			}

		} catch (SQLException e1) { 
			e1.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return price;

	}

	public Product findProduct(String proName, String proType, int bdSize, String colorName) {
		String query = "select products_id,Brand_name,Brand_type,Brand_size,color,prices,manufacture_date from Product"
				+ " where Brand_name=? and Brand_type=? and Brand_size=? and color=? ";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		Product product = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, proName);
			preparedstatement.setString(2, proType);
			preparedstatement.setInt(3, bdSize);
			preparedstatement.setString(4, colorName);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				product = new Product(resultset.getString(2), resultset.getString(3), resultset.getInt(4),
						resultset.getString(5), resultset.getDouble(6), resultset.getDate(7));

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return product;
	}

	public Product findProduct(int id) {
		Connection connection = ConnectionUtil.getDbconnection();
		String query = "select products_id,Brand_name,Brand_type,Brand_size,color,prices,manufacture_date from Product"
				+ " where products_id= ?";
		Product product = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				product = new Product(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getInt(4), resultset.getString(5), resultset.getDouble(6), resultset.getDate(7));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return product;
	}

	public List<Product> filterSize(String search) {
		List<Product> SizeList = new ArrayList<Product>();
		Product product = null;
		String showQuery = "select products_id,Brand_name,Brand_type,Brand_size,color,prices,manufacture_date,status from Product"
				+ " where Brand_name like'%"
				+ search + "%' or Brand_type like'%" + search + "%' or Brand_size like'%" + search
				+ "%' or color like'%" + search + "%' and status='available' ";
	
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(showQuery);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				product = new Product(resultset.getString(2), resultset.getString(3), resultset.getInt(4),
						resultset.getString(5), resultset.getDouble(6), resultset.getDate(7));
				product.setStatus(resultset.getString(8));
				SizeList.add(product);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return SizeList;
	}

	public List<Product> showProduct(int productID) {
		List<Product> productsList = new ArrayList<Product>();
		String showQuery = "select products_id,Brand_name,Brand_type,Brand_size,color,prices,manufacture_date from Product where products_id= ?";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		Product products = null;
		ResultSet resultset = null;
		try {
			preparedstatement = connection.prepareStatement(showQuery);
			preparedstatement.setInt(1, productID);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				products = new Product(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getInt(4), resultset.getString(5), resultset.getDouble(6), resultset.getDate(7));
				productsList.add(products);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return productsList;

	}

	public List<Product> showUserProduct() {
		List<Product> productsList = new ArrayList<Product>();
		String showQuery = "select products_id,Brand_name,Brand_type,Brand_size,color,prices,manufacture_date,status from Product "
				+ "where status='available'";
		Connection connection = ConnectionUtil.getDbconnection();
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		Product products = null;
		try {
			preparedstatement = connection.prepareStatement(showQuery);
			resultset = preparedstatement.executeQuery();
			while (resultset.next()) {
				products = new Product(resultset.getInt(1), resultset.getString(2), resultset.getString(3),
						resultset.getInt(4), resultset.getString(5), resultset.getDouble(6), resultset.getDate(7));
				products.setStatus(resultset.getString(8));
				productsList.add(products);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedstatement, resultset);
		}
		return productsList;
	}

}
