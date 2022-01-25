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
	private static final long serialVersionUID = 1L;

	public UserCreateAccountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String password = req.getParameter("pass");
		long mobileno = Long.parseLong(req.getParameter("num"));
		String email = req.getParameter("UserEmail");
		String address = req.getParameter("address");
		UserDaoImpl userdao = new UserDaoImpl();
		Users user = new Users(name, password, mobileno, email, address, 0.0);
		userdao.inserUser(user);
		if (user != null) {
			resp.sendRedirect("User.jsp");
			;
		} else {
			resp.sendRedirect("newUser.jsp");
		}
	}

}
