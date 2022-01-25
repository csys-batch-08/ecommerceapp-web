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
		ConnectionUtil conUtil = new ConnectionUtil();
		String insertQuery = "insert into  Product(Brand_name,Brand_type,Brand_size,color,prices,manufacture_date) values(?,?,?,?,?,?)";
		Connection con = conUtil.getDbconnection();
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, brandName);
			pstmt.setString(2, brandType);
			pstmt.setInt(3, brandSize);
			pstmt.setString(4, color);
			pstmt.setDouble(5, prices);
			pstmt.setDate(6, new java.sql.Date(manufactureDate.getTime()));

			i = pstmt.executeUpdate();
			System.out.println(i + "Value Inserted Successfully");
		} catch (SQLException e) {
			// catch the exception and get that message
			e.printStackTrace();
			System.out.println("Value not Setted in the query");
		}
		return i;
	}

	public int updated(int brandSize, double prices, int productId) {

		String updateQuery = "update Product set Brand_size=?,prices=? where products_id=? ";
		ConnectionUtil conUtil;
		Connection con = ConnectionUtil.getDbconnection();
		PreparedStatement pstmt = null;
		int i1 = 0;
		try {

			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1, brandSize);
			pstmt.setDouble(2, prices);
			pstmt.setInt(3, productId);
			i1 = pstmt.executeUpdate();
			System.out.println("updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i1;
	}

	public int delete(int productId) {

		String deleteQuery = "delete from  Product where products_id=?";
		Connection con;
		int i2 = 0;
		try {
			con = ConnectionUtil.getDbconnection();
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);

			pstmt.setInt(1, productId);
			i2 = pstmt.executeUpdate();
			System.out.println("delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i2;
	}

	public List<Product> showProduct() {
		List<Product> productsList = new ArrayList<Product>();
		String showQuery = "select * from Product";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		Product products = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			while (rs.next()) {
				products = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7));
				productsList.add(products);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsList;
	}

	public ResultSet findProductId(Product product) {
		String query = "select products_id ,prices from Product where Brand_name=? and Brand_type=? and Brand_size=? and color=? ";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		PreparedStatement pstmt = null;
		int proId = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, product.getBrandName());
			pstmt.setString(2, product.getBrandType());
			pstmt.setInt(3, product.getBrandSize());
			pstmt.setString(4, product.getColor());
			ResultSet rs = pstmt.executeQuery();
			return rs;
//			while (rs.next()) {
//				proId = rs.getInt(1);
//			}
//
		} catch (SQLException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}

	public Product findProduct(String proName, String proType, int bdSize, String colorName) {
		String Query = "select * from Product where Brand_name=? and Brand_type=? and Brand_size=? and color=? ";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		PreparedStatement pstmt = null;
		Product product = null;
		try {
			pstmt = con.prepareStatement(Query);
			pstmt.setString(1, proName);
			pstmt.setString(2, proType);
			pstmt.setInt(3, bdSize);
			pstmt.setString(4, colorName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				product = new Product(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),
						rs.getDate(7));
				System.out.println(product);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return product;
	}

	public Product findProduct(int id) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		String Query = "select * from Product where products_id='" + id + "'";
		Product product = null;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			if (rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return product;
	}

	public double findPrice(int pid) {
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		String Query1 = "select price from Product where products_id=?";
		System.out.println(pid);

		return 0;
	}

	public List<Product> filterSize(String search) {
		List<Product> SizeList = new ArrayList<Product>();

		Product product = null;
		String showQuery = "select * from Product where Brand_name like'%"+ search+"%' or Brand_type like'%"+ search+"%' or Brand_size like'%"+ search+"%' or color like'%"+ search+"%' ";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			while (rs.next()) {
				product = new Product(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),
						rs.getDate(7));
				SizeList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SizeList;
	}

	public List<Product> showProduct(int productID) {
		List<Product> productsList = new ArrayList<Product>();
		String showQuery = "select * from Product where products_id='" + productID + "'";
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbconnection();
		Product products = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			while (rs.next()) {
				products = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDouble(6), rs.getDate(7));
				productsList.add(products);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsList;

	}

}
