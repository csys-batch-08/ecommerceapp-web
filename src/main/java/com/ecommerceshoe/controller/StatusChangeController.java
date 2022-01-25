package com.ecommerceshoe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerceshoe.daoimpl.OrderDaoImpl;

/**
 * Servlet implementation class StatusChangeController
 */
@WebServlet("/StatusChange")
public class StatusChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public StatusChangeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 int orderid=Integer.parseInt(request.getParameter("orderId"));
		 System.out.println(orderid);
		 OrderDaoImpl orderdao=new OrderDaoImpl();
		Boolean b= orderdao.statuschange(orderid);
		if(b) {
		 response.sendRedirect("StatusChange.jsp");
		}
		}
	}

	

