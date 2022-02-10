package com.ecommerceshoe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerceshoe.daoimpl.ProductDaoImpl;
import com.ecommerceshoe.model.Product;

/**
 * Servlet implementation class SearchProductController
 */
@WebServlet("/SearchProductController")
public class SearchProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String search = request.getParameter("search");
		ProductDaoImpl productdao = new ProductDaoImpl();
		List<Product> listproduct = productdao.filterSize(search);
		HttpSession session = request.getSession();
		session.setAttribute("list", listproduct);
		try {
		response.sendRedirect("searchingcontroller");
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
