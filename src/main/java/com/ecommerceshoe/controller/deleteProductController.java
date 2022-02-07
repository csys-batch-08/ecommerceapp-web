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

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productid = Integer.parseInt(req.getParameter("proid"));
		ProductDaoImpl productDao = new ProductDaoImpl();
		HttpSession session = req.getSession();
		int i2 = productDao.delete(productid);
		if (i2 != 0) {
			List<Product> productList = productDao.showProduct();
			session.setAttribute("Product", productList);
			resp.sendRedirect("deleteProduct.jsp");
		} else {
			resp.sendRedirect("product.jsp");
		}

	}

}
