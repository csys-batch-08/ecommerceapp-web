package com.ecommerceshoe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerceshoe.daoimpl.ProductDaoImpl;
import com.ecommerceshoe.model.Product;

/**
 * Servlet implementation class deleteProductController
 */
@WebServlet("/deleteProductController")
public class deleteProductController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productid = Integer.parseInt(request.getParameter("proid"));
		ProductDaoImpl productDao = new ProductDaoImpl();
		HttpSession session = request.getSession();
		int i2 = productDao.delete(productid);
		if (i2 != 0) {
			List<Product> productList = productDao.showProduct();
			session.setAttribute("Product", productList);
			response.sendRedirect("deleteProduct.jsp");
		} else {
			response.sendRedirect("product.jsp");
		}

	}

}
