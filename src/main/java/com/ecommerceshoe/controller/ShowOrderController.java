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
import com.ecommerceshoe.model.Users;

@WebServlet("/showorder")
public class ShowOrderController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("CurrentUser");
		OrderDaoImpl orderdao = new OrderDaoImpl();
		List<Order> OrderList = orderdao.ShowOrder(user);
		session.setAttribute("order", OrderList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("showOrder.jsp");
		requestDispatcher.forward(request, response);

	}

}
