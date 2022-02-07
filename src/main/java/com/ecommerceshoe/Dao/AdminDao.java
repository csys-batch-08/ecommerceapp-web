package com.ecommerceshoe.Dao;

import com.ecommerceshoe.model.Admin;

public interface AdminDao {
	public  Admin validateAdmin(String admin_email, String password);
	

}
