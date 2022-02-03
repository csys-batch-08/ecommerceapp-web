package com.ecommerceshoe.Dao;

import java.util.List;

import com.ecommerceshoe.model.Order;
import com.ecommerceshoe.model.Users;

public interface OrderDao {
	public  int insertOrder( Order orders);
	public List<Order> ShowOrder(Users user);
}
