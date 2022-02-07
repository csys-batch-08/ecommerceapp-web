package com.ecommerceshoe.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerceshoe.daoimpl.UserDaoImpl;
import com.ecommerceshoe.model.Users;

/**
 * Servlet implementation class UpdateWalletController
 */
@WebServlet("/UpdateWalletController")
public class UpdateWalletController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("CurrentUser");
		Double amount = Double.parseDouble(request.getParameter("Amount"));
		UserDaoImpl userdao = new UserDaoImpl();
		int n = userdao.updateuserWallet(user, amount);
		try {
		if (n != 0) {
			session.setAttribute("wallet", user.getWallet());
			session.setAttribute("recharge", 1);
			response.sendRedirect("walletUpdate.jsp");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
