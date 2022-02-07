package com.ecommerceshoe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerceshoe.daoimpl.CartDaoImpl;
import com.ecommerceshoe.daoimpl.UserDaoImpl;
import com.ecommerceshoe.model.cart;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;

/**
 * Servlet implementation class cartProductController
 */
@WebServlet("/cartProductController")
public class cartProductController extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("CurrentUser");
		Product product = (Product) session.getAttribute("currentproduct");
		int quantity = Integer.parseInt(req.getParameter("quan"));
		double price = Double.parseDouble(req.getParameter("pri"));
		CartDaoImpl cartdao = new CartDaoImpl();
		cart cart = new cart(product, user, quantity, price);
		UserDaoImpl userdao = new UserDaoImpl();
		int i = cartdao.insertCart(cart);
		if (i != 0) {
			resp.sendRedirect("showCartJsp.jsp");
		} else {
			resp.sendRedirect("cartPro.jsp");
		}

	}

}
