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

/**
 * Servlet implementation class OrderCancellingController
 */
@WebServlet("/ordercancelcontroller")
public class OrderCancellingController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 HttpSession session=request.getSession();
		OrderDaoImpl orderdao=new OrderDaoImpl();
	   Users user=(Users)session.getAttribute("CurrentUser");
		List<Order> OrderList=orderdao.ShowOrder(user);
		session.setAttribute("orderCancel",  OrderList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("orderCancel.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
