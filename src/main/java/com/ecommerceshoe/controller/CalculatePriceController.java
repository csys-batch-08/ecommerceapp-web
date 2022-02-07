package com.ecommerceshoe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerceshoe.daoimpl.OrderDaoImpl;

/**
 * Servlet implementation class CalculatePriceController
 */
@WebServlet("/CalculatePriceController")
public class CalculatePriceController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fromdate = sdf.parse(request.getParameter("fromDate"));
			Date todate = sdf.parse(request.getParameter("toDate"));
			HttpSession session = request.getSession();
			OrderDaoImpl orderDao = new OrderDaoImpl();
			List<Object> list = orderDao.TotalAmount(fromdate, todate);
			session.setAttribute("List", list);
			response.sendRedirect("calculatePrice.jsp");
		}
			catch(Exception e) {
				e.printStackTrace();
			}		 
	}

}
