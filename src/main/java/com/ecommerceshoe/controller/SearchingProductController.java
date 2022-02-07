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

import com.ecommerceshoe.model.Product;
import com.ecommerceshoe.model.Users;

/**
 * Servlet implementation class SearchingProductController
 */
@WebServlet("/searchingcontroller")
public class SearchingProductController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("CurrentUser");
		List<Product> searchpro = (List<Product>) session.getAttribute("list");
		session.setAttribute("search", searchpro);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
		requestDispatcher.forward(request, response);

	}

}
