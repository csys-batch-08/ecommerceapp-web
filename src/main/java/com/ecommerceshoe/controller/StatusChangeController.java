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

import com.ecommerceshoe.daoimpl.OrderDaoImpl;
import com.ecommerceshoe.model.Order;

/**
 * Servlet implementation class StatusChangeController
 */
@WebServlet("/StatusChange")
public class StatusChangeController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		int orderid = Integer.parseInt(request.getParameter("orderId"));
		OrderDaoImpl orderdao = new OrderDaoImpl();
		Boolean b = orderdao.statuschange(orderid);
		List<Order> orderList = orderdao.ShowOrder();
		request.setAttribute("order", orderList);
		if (Boolean.TRUE.equals(b)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("statusChange.jsp");
			requestDispatcher.forward(request, response);

		}
	}
}
