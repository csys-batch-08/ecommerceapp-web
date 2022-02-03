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

import com.ecommerceshoe.daoimpl.ProductDaoImpl;
import com.ecommerceshoe.daoimpl.UserDaoImpl;
import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;

@WebServlet("/showproduct")
public class ShowProductController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Users user=(Users) session.getAttribute("CurrentUser");
		Double wallet=user.getWallet();
		String name=user.getName();
		UserDaoImpl userDao=new UserDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		List<Product> ProductList = productDao.showProduct();
		session.setAttribute("wallet", wallet);
		session.setAttribute("name", name );
		session.setAttribute("product", ProductList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("showPro.jsp");
	     requestDispatcher.forward(request, response);
		
	}

	}

