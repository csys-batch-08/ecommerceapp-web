<%@page import="com.ecommerceshoe.model.Users"%>
<%@page import="com.ecommerceshoe.model.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerceshoe.daoimpl.OrderDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StatusChange</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: red;
}

.active {
	background-color: #04AA6D;
}
#prod {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#prod td, #prod th {
	border: 1px solid #ddd;
	padding: 8px;
}

#prod tr:nth-child(even) {
	background-color: #f2f2f2;
}

#prod tr:hover {
	background-color: #ddd;
}

#prod th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}</style>
</head>
<body style="background-color: pink;">
<form action="">
	<div>
		<h1 style="text-align: center;">Orders</h1>
		<ul>


			<li><a href="WelcomeAdmin.jsp">Admin</a></li>
			
			<li style="float: right;"><a href="User.jsp"> LogOut</a></li>

		</ul>
		
		<br>
		<br>
	</div>
	<div>
		<table id="prod">
			<tr>
			   <th>OrderId</th>
				<th>UserName</th>
				<th>BrandName</th>
				<th>BrandType</th>
				<th>BrandSize</th>
				<th>color</th>
				<th>manufactureDate</th>
				<th>quantity</th>
				<th>price</th>
				<th>orderDate</th>
				<th>Status</th>
				<th>StatusChange</th>
			</tr>
			<%
				OrderDaoImpl orderdao=new OrderDaoImpl();
			
				List<Order> OrderList=orderdao.ShowOrder();
				for(Order orderList1 : OrderList){
				%>

			<tr>
				<td><%=orderList1.getOrderId() %></td>
				<td><%=orderList1.getUser().getName() %></td>
				<td><%=orderList1.getProduct().getBrandName()%></td>
				<td><%=orderList1.getProduct().getBrandType()%></td>
				<td><%=orderList1.getProduct().getBrandSize()%></td>
				<td><%=orderList1.getProduct().getColor()%></td>
				<td><%=orderList1.getProduct().getManufactureDate()%></td>			
				<td><%=orderList1.getQuantity() %></td>
				<td><%=orderList1.getPrice() %></td>
				<td><%=orderList1.getOrderDate() %></td>
				<td><%=orderList1.getStatus() %></td>
               <td> <a href="StatusChange?orderId=<%=orderList1.getOrderId() %>"> StatusChange</a>
                </td>
			</tr>
			<%
				}
				%>
		</table>
	</div>
</form>
</body>
</html>