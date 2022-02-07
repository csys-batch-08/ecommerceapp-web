package com.ecommerceshoe.model;

import java.util.Date;

public class Order {
	private int orderId;
	private Product product;
	private Users user;
	private int quantity;
	private double price;
	private Date orderDate;
	private String status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Order(Product product, Users user, int quantity, Date orderDate) {
		super();
		this.product = product;
		this.user = user;
		this.quantity = quantity;

		this.orderDate = orderDate;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Product product, double price) {
		super();
		this.product = product;
		this.price = price;
	}

	public Order(Product product2, Users user2, int int1, double double1, java.sql.Date date) {
		// TODO Auto-generated constructor stub
		this.product = product2;
		this.user = user2;
		this.quantity = int1;
		this.price = double1;
		this.orderDate = date;
	}

	public Order(Product product2, Users user2, int quantity2, double price2, Date orderDate2) {
		this.product = product2;
		this.user = user2;
		this.quantity = quantity2;
		this.price = price2;
		this.orderDate = orderDate2;
	}

	public Order(int orderId, Product product, Users user, int quantity, double price, Date orderDate, String status) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [product=" + product + ", user=" + user + ", quantity=" + quantity + ", price=" + price
				+ ", orderDate=" + orderDate + "]";
	}

}
