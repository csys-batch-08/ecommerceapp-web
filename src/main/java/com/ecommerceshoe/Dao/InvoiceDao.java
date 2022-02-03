package com.ecommerceshoe.Dao;

import java.sql.ResultSet;

import com.ecommerceshoe.model.Users;

public interface InvoiceDao {
	public ResultSet showBill(Users user);

}
