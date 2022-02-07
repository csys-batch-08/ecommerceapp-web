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
 * Servlet implementation class StatusChangeGetValueController
 */
@WebServlet("/statuschangegetvalue")
public class StatusChangeGetValueController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrderDaoImpl orderdao = new OrderDaoImpl();
		List<Order> orderList = orderdao.ShowOrder();
		request.setAttribute("order", orderList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("statusChange.jsp");
		requestDispatcher.forward(request, response);
	}
}
