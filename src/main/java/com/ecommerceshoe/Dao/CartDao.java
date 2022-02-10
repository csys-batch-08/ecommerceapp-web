package com.ecommerceshoe.Dao;

import java.util.List;

import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.model.Cart;

public interface CartDao {
	public  int insertCart(Cart carts);
	public List<Cart> showCart(Users user);

}
