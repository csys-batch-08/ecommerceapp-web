<%@page import="com.ecommerceshoe.daoimpl.OrderDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
<style>


body {
	height: 100vh;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: pink;
}

form {
	text-align: center;
	width: 25rem;
	/* height: 28rem; */
	padding: 45px 0px;
	display: flex;

	flex-direction: column;
	background-color: activecaption;
	box-shadow: 0 8px 32px 0 rgb(31 38 135/ 37%);
	border-radius: 30px;
	border-left: 1px solid;
	border-left: 1px solid rgba(255, 255, 255, .3);
}

</style>
</head>
<body>

<form>
<div>
		<h1 style="text-align: center;">ORDERBILL</h1>
	</div>
<div>

<%int orderId=Integer.parseInt(request.getParameter("orderid")); %>
		
			<%
				OrderDaoImpl orderdao=new OrderDaoImpl();
			   Users user=(Users)session.getAttribute("CurrentUser");
				List<Order> OrderList=orderdao.ShowOrder(user);
				for(Order orderList1 : OrderList){
					if(orderList1.getOrderId()==orderId){
				%>
				<div style="text-align: left;padding-left: 120px;">
                 <h3> OrderId:<%=orderList1.getOrderId() %></h3>
				  <h3>UserName:<%=orderList1.getUser().getName() %></h3>
				<h3>BrandName:<%=orderList1.getProduct().getBrandName()%></h3>
				 <h3>BrandType:<%=orderList1.getProduct().getBrandType()%></h3>
				 <h3>BrandSize:<%=orderList1.getProduct().getBrandSize()%></h3>
				 <h3>Color:<%=orderList1.getProduct().getColor()%></h3>
				<h3>Manufacturedate:<%=orderList1.getProduct().getManufactureDate()%></h3>
				<h3>Quantity:<%=orderList1.getQuantity() %></h3>
				<h3>Price:<%=orderList1.getPrice() %></h3>
				<h3>OrderDate:<%=orderList1.getOrderDate() %></h3>            
             </div>
			
		<%
					}}
				%>
	</div>
	</form>
</body>
</html>