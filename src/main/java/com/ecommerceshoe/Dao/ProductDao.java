package com.ecommerceshoe.Dao;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.ecommerceshoe.model.Product;

public interface ProductDao {
	public  int inserproduct(String brandName, String brandType, int brandSize, String color, double prices,
			Date manufactureDate);
	public int updated(int brandSize, double prices, int productId);
	public int delete(int productId);
	public List<Product> showProduct();
	public List<Product> showProduct(int productID);
	public  ResultSet findProductId(Product product);
	public  Product findProduct(String proName,String proType,int bdSize,String colorName);
	public Product findProduct(int id);
	public List<Product> filterSize(String search);
}
