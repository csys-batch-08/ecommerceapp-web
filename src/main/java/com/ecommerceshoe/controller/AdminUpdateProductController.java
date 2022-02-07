package com.ecommerceshoe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerceshoe.daoimpl.ProductDaoImpl;
import com.ecommerceshoe.model.Product;

/**
 * Servlet implementation class AdminUpdateProductController
 */
@WebServlet("/adminupdatecontroller")
public class AdminUpdateProductController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ProductDaoImpl productdao = new ProductDaoImpl();
		List<Product> ProductList = productdao.showProduct();
		session.setAttribute("Product", ProductList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("updateProduct.jsp");
		requestDispatcher.forward(request, response);

	}

}
