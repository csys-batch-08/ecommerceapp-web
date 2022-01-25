package com.ecommerceshoe.Dao;

import java.util.List;

import com.ecommerceshoe.model.Users;

public interface UserDao {
	public  int inserUser(Users user);
	public  Users validateUser(String email, String password);
	public int findUserID(Users user) ;
	public  Users findUser(String email);
	public Users findUserId(int id);
	public   int updateuserWallet(Users user,double amount);
	public  int Walletupdate(double OrderPrices, Users user);
	

}
