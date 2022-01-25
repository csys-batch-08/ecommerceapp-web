package com.ecommerceshoe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerceshoe.daoimpl.OrderDaoImpl;
import com.ecommerceshoe.daoimpl.UserDaoImpl;
import com.ecommerceshoe.model.Users;

/**
 * Servlet implementation class OrderCancelController
 */
@WebServlet("/ordercancelserv")
public class OrderCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderCancelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		Users user = (Users) session.getAttribute("CurrentUser");
		OrderDaoImpl orderdao = new OrderDaoImpl();

		int orderid1 = Integer.parseInt(request.getParameter("oid"));
		orderdao.orderCancel(orderid1);
		double price = Double.parseDouble(request.getParameter("price"));
		UserDaoImpl userDao = new UserDaoImpl();
		int n = userDao.updateuserWallet(user, price);
		if (n > 0) {
			session.setAttribute("updatewallet", true);
			response.sendRedirect("showPro.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
