package com.ecommerceshoe.model;



public class InvoiceBill {
	
	private Users user;
	private Order order;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public InvoiceBill(Users user, Order order) {
		super();
		this.user = user;
		this.order = order;
	}
	public InvoiceBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InvoiceBill [user=" + user + ", order=" + order + "]";
	}
	
	
	

}
