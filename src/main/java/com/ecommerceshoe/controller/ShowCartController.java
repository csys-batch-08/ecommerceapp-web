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

import com.ecommerceshoe.daoimpl.CartDaoImpl;
import com.ecommerceshoe.model.Users;
import com.ecommerceshoe.model.cart;

/**
 * Servlet implementation class ShowCartController
 */
@WebServlet("/showcart")
public class ShowCartController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		CartDaoImpl cartdao = new CartDaoImpl();
		Users user = (Users) session.getAttribute("CurrentUser");
		List<cart> cartList = cartdao.showCart(user);
		request.setAttribute("cart", cartList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("showCartJsp.jsp");
		requestDispatcher.forward(request, response);

	}

}
