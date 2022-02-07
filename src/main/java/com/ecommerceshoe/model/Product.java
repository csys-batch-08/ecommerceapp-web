package com.ecommerceshoe.model;

import java.util.Date;

public class Product {
	private int productId;
	private String brandName;
	private String brandType;
	private int brandSize;
	private String color;
	private double prices;
	private Date manufactureDate;
	private String status;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public int getBrandSize() {
		return brandSize;
	}

	public void setBrandSize(int brandSize) {
		this.brandSize = brandSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrices() {
		return prices;
	}

	public void setPrices(double prices) {
		this.prices = prices;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product(String brandName, String brandType, int brandSize, String color, double prices,
			Date manufactureDate) {
		super();

		this.brandName = brandName;
		this.brandType = brandType;
		this.brandSize = brandSize;
		this.color = color;
		this.prices = prices;
		this.manufactureDate = manufactureDate;

	}

	public Product(int int1, String string, String string2, int int2, String string3, double double1,
			java.sql.Date date) {
		this.productId = int1;
		this.brandName = string;
		this.brandType = string2;
		this.brandSize = int2;
		this.color = string3;
		this.prices = double1;
		this.manufactureDate = date;

	}

	public Product(String string4, String string5, int int5, String string6) {
		this.brandName = string4;
		this.brandType = string5;
		this.brandSize = int5;
		this.color = string6;
	}

	@Override
	public String toString() {
		return "Product [brandName=" + brandName + ", brandType=" + brandType + ", brandSize=" + brandSize + ", color="
				+ color + ", prices=" + prices + ", manufactureDate=" + manufactureDate + "]";
	}

}
