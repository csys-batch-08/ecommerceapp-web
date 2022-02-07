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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("Email");
		String password = req.getParameter("pass");
		Admin admin = new Admin(email, password);
		AdminDaoImpl admindao = new AdminDaoImpl();
		admin = admindao.validateAdmin(admin.getAdminEmail(), admin.getPassword());
		try {
		if (admin != null) {
			resp.sendRedirect("welcomeAdmin.jsp");
		} else {
			resp.sendRedirect("index.jsp");
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
