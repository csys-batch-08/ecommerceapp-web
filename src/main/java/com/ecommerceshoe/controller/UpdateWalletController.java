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
	private static final long serialVersionUID = 1L;
   
    public UpdateWalletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("CurrentUser");
		System.out.println(user);
		Double amount=Double.parseDouble(request.getParameter("Amount"));
		System.out.println(amount);
		UserDaoImpl userdao=new UserDaoImpl();
		int n=userdao.updateuserWallet(user,amount);
		if(n!=0){
		  session.setAttribute("recharge", 1);
		  response.sendRedirect("walletupdate.jsp");
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

}
