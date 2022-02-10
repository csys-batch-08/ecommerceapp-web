package com.ecommerceshoe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerceshoe.daoimpl.UserDaoImpl;
import com.ecommerceshoe.model.Users;

/**
 * Servlet implementation class createAccount
 */
@WebServlet("/UserCreateAccountController")
public class UserCreateAccountController extends HttpServlet {


@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String password = req.getParameter("pass");
		long mobileno = Long.parseLong(req.getParameter("num"));
		String email = req.getParameter("UserEmail");
		String address = req.getParameter("address");
		UserDaoImpl userdao = new UserDaoImpl();
		Users user = new Users(name, password, mobileno, email, address, 0.0);
		int i=userdao.inserUser(user);
		try {
		if ( i!=0) {
			resp.sendRedirect("index.jsp");
		} 
		else {
			resp.sendRedirect("newUser.jsp");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
