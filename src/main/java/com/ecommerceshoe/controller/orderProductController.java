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
import com.ecommerceshoe.daoimpl.ProductDaoImpl;
import com.ecommerceshoe.daoimpl.UserDaoImpl;
import com.ecommerceshoe.exception.ErrorFound;
import com.ecommerceshoe.model.Order;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;


@WebServlet("/orderProductController")
public class orderProductController extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("CurrentUser");
		Product product = (Product) session.getAttribute("currentproduct");
		int quantity = Integer.parseInt(req.getParameter("quan"));
		double price = Double.parseDouble(req.getParameter("pri"));
		OrderDaoImpl orderdao = new OrderDaoImpl();
		Order order = new Order(product, user, quantity, price, null);
		try {
			if (user.getWallet() > price) {
				UserDaoImpl userdao = new UserDaoImpl();

				int i = userdao.Walletupdate(price, user);
			session.setAttribute("wallet", user.getWallet());
				i = orderdao.insertOrder(order);
				if (i != 0) {
					resp.sendRedirect("showorder");
				} else {
					resp.sendRedirect("orderPro.jsp");
				}

			} else {
				throw new ErrorFound();
			}
		} catch (ErrorFound e) {
			HttpSession session1 = req.getSession();
			session1.setAttribute("balance", e.getMessage());
			resp.sendRedirect("showPro.jsp");
		}

		

	}
}
