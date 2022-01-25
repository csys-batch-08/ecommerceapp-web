package com.ecommerceshoe.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerceshoe.daoimpl.ProductDaoImpl;

/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProductController() {
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

		int brandSize = Integer.parseInt(req.getParameter("bsize"));
		double price = Double.parseDouble(req.getParameter("pri"));
		int productid = Integer.parseInt(req.getParameter("proid"));
		ProductDaoImpl productdao = new ProductDaoImpl();
		int i1 = productdao.updated(brandSize, price, productid);
		if (i1 != 0) {
			resp.sendRedirect("User.jsp");
		} else {
			resp.sendRedirect("product.jsp");
		}
	}
}
