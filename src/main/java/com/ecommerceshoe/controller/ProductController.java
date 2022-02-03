package com.ecommerceshoe.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerceshoe.daoimpl.ProductDaoImpl;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductController() {
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
	
		String brandName = req.getParameter("bname");
		String brandType = req.getParameter("Btype");
		int brandSize = Integer.parseInt(req.getParameter("bsize"));
		String color = req.getParameter("col");
		double price = Double.parseDouble(req.getParameter("pri"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		try {
			Date manufacturedate = sdf.parse(req.getParameter("manufacture"));

			ProductDaoImpl productdao = new ProductDaoImpl();

			int i = productdao.inserproduct(brandName, brandType, brandSize, color, price, manufacturedate);

			if (i != 0) {
				resp.sendRedirect("index.jsp");
			} else {
				resp.sendRedirect("product.jsp");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
