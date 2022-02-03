package com.ecommerceshoe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerceshoe.daoimpl.AdminDaoImpl;
import com.ecommerceshoe.model.Admin;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginController() {
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

		String email = req.getParameter("Email");
		String password = req.getParameter("pass");
		Admin admin = new Admin(email, password);
		AdminDaoImpl admindao = new AdminDaoImpl();
		admin = admindao.validateAdmin(admin.getAdminEmail(), admin.getPassword());
		if (admin != null) {
			resp.sendRedirect("welcomeAdmin.jsp");
		} else {
			resp.sendRedirect("index.jsp");
		}
	}

}
