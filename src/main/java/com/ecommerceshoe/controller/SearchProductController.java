package com.ecommerceshoe.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SearchProductController
 */
@WebServlet("/SearchProductController")
public class SearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String search=request.getParameter("search");
		ProductDaoImpl productdao=new ProductDaoImpl();
		 List<Product> listproduct=productdao.filterSize(search);
//		 List<Product> list=new ArrayList<Product>();
//		 for(int i=0;i<listproduct.size();i++) {
//			Product product= listproduct.get(i);
//		
//		if(product.getBrandName().equalsIgnoreCase(search)) {
//			list.add(product);
//		}
//		else if(product.getBrandType().equalsIgnoreCase(search)) {
//			list.add(product);
//			
//		}
//		else if(String.valueOf(product.getBrandSize()).equalsIgnoreCase(search)) {
//			list.add(product);
//		}
//		else if(product.getColor().equalsIgnoreCase(search)) {
//			list.add(product);
//		}
//		for(int j=0;j<list.size();j++) {
//			Product product1=list.get(j);
//		}
//		 }
		 HttpSession session=request.getSession();
		 session.setAttribute("list", listproduct);
		 response.sendRedirect("Search.jsp");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
