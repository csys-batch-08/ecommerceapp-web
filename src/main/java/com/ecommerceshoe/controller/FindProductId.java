//package com.ecommerceshoe.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.ecommerceshoe.daoimpl.ProductDaoImpl;
//import com.ecommerceshoe.model.Product;
//
///**
// * Servlet implementation class FindProductId
// */
//@WebServlet("/findProid")
//public class FindProductId extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//   
//    public FindProductId() {
//        super();
//        // TODO Auto-generated constructor stub
//    } 
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws S  ervletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//@Override
//protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	// TODO Auto-generated method stub
//	String brandName=req.getParameter("bname");
//	String brandType=req.getParameter("Btype");
//	int brandSize=Integer.parseInt(req.getParameter("bsize"));
//	String color=req.getParameter("col");
//	ProductDaoImpl productdao=new ProductDaoImpl();
//	//Product product=new Product(brandName,brandType,brandSize,color,0.0,null);
//	int proid=productdao.findProductId(product);
//	 if(proid!=0) {
//			resp.sendRedirect("User.jsp");;
//		}
//		else {
//			resp.sendRedirect("newUser.jsp");
//		}
//}
//
//}
