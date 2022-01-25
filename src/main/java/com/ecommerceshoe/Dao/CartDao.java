package com.ecommerceshoe.Dao;

import java.util.List;

import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.model.cart;

public interface CartDao {
	public  int insertCart(cart carts);
	public List<cart> showCart(Users user);

}
