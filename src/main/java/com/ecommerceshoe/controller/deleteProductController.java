package com.ecommerceshoe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerceshoe.daoimpl.ProductDaoImpl;

/**
 * Servlet implementation class deleteProductController
 */
@WebServlet("/deleteProductController")
public class deleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteProductController() {
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
		int productid = Integer.parseInt(req.getParameter("proid"));
		ProductDaoImpl productdao = new ProductDaoImpl();
		int i2 = productdao.delete(productid);
		if (i2 != 0) {
			resp.sendRedirect("index.jsp");
		} else {
			resp.sendRedirect("product.jsp");
		}

	}

}
