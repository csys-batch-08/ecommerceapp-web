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

/**
 * Servlet implementation class orderProductController
 */
@WebServlet("/orderProductController")
public class orderProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public orderProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("CurrentUser");

		System.out.println(user);
		Product product = (Product) session.getAttribute("currentproduct");
		System.out.println(product);
//		 String brandName=req.getParameter("brandname");
//		 String brandType=req.getParameter("btype");
//		 int brandSize=Integer.parseInt(req.getParameter("bsize"));
//		 String color=req.getParameter("color");
		int quantity = Integer.parseInt(req.getParameter("quan"));
		System.out.println(quantity);
		double price = Double.parseDouble(req.getParameter("pri"));
		System.out.println(price);

//		UserDaoImpl userdao=new UserDaoImpl();
//		int userId=userdao.findUserID(user);
//		ProductDaoImpl productdao=new ProductDaoImpl();
//		productdao.findProductId(product1);

		// try {

		// System.out.println(orderDate);
		OrderDaoImpl orderdao = new OrderDaoImpl();
		Order order = new Order(product, user, quantity, price, null);
		try {
			if (user.getWallet() > price) {
				UserDaoImpl userdao = new UserDaoImpl();

				int i = userdao.Walletupdate(price, user);
			
				i = orderdao.insertOrder(order);
				if (i != 0) {
					resp.sendRedirect("showorder.jsp");
				} else {
					resp.sendRedirect("orderpro.jsp");
				}

			} else {
				throw new ErrorFound();
			}
		} catch (ErrorFound e) {
			HttpSession session1 = req.getSession();
			session1.setAttribute("balance", e.getMessage());
			resp.sendRedirect("showPro.jsp");
		}

		// }
		// catch (ParseException e) {

		// e.printStackTrace();

		// }

	}
}
