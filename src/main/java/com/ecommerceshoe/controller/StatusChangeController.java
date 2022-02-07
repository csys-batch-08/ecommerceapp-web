package com.ecommerceshoe.controller;

import java.io.IOException;
import java.util.List;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int orderid = Integer.parseInt(request.getParameter("orderId"));
		OrderDaoImpl orderdao = new OrderDaoImpl();
		Boolean b = orderdao.statuschange(orderid);
		List<Order> orderList = orderdao.ShowOrder();
		session.setAttribute("order", orderList);
		if (b) {
			response.sendRedirect("statusChange.jsp");
		}
	}
}
