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
	private static final long serialVersionUID = 1L;
       
    
    public CalculatePriceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
		    
			Date fromdate =sdf.parse(request.getParameter("fromDate"));
			Date todate = sdf.parse(request.getParameter("toDate"));
			HttpSession session = request.getSession();
			OrderDaoImpl orderDao=new OrderDaoImpl();
		List<Object> list=orderDao.TotalAmount(fromdate, todate);
		session.setAttribute("List", list);
			response.sendRedirect("calculatePrice.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
}
