package com.ecommerceshoe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerceshoe.daoimpl.ProductDaoImpl;
import com.ecommerceshoe.daoimpl.UserDaoImpl;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;

@WebServlet("/cartgetvalue")
public class CartProductGetValueController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("CurrentUser");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		String bname = request.getParameter("brandname");
		String btype = request.getParameter("btype");
		int bsize = Integer.parseInt(request.getParameter("bsize"));
		String color = request.getParameter("color");
		int userid = userDaoImpl.findUserID(user);
		user.setUserid(userid);
		ProductDaoImpl productdao = new ProductDaoImpl();
		Product product = new Product(bname, btype, bsize, color);
		int productId = productdao.findProductId(product);
		double price = productdao.findPrice(product);
		request.setAttribute("currentproduct", product);
		session.setAttribute("proid", productId);
		session.setAttribute("Price", price);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("cartPro.jsp");
		requestDispatcher.forward(request, response);

	}

}
