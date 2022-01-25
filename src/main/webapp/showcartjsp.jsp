<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart details</title>
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
}
</style>
</head>
<body style="background-color: pink;">

	<div>
		<h1 style="text-align: center;">MyCart</h1>
		<ul>


			<li><a href="showPro.jsp">Home</a></li>


		</ul>
		<br>
		<br>
	</div>
	<div>
		<table id="prod">
			<tr>
				<th>UserName</th>
				<th>Brandname</th>
				<th>Brandtype</th>
				<th>Brandsize</th>
				<th>color</th>
				<th>quantity</th>
				<th>price</th>

			</tr>
			<%
				CartDaoImpl cartdao=new CartDaoImpl();
			   Users user=(Users)session.getAttribute("CurrentUser");
			   List<cart> cartList=cartdao.showCart(user);
				for(cart cartList1 : cartList){
				%>

			<tr>
				<td><%=cartList1.getUser().getName() %></td>
				<td><%=cartList1.getProduct().getBrandName()%></td>
				<td><%=cartList1.getProduct().getBrandType()%></td>
				<td><%=cartList1.getProduct().getBrandSize()%></td>
				<td><%=cartList1.getProduct().getColor()%></td>
				<td><%=cartList1.getQuantity() %></td>
				<td><%=cartList1.getPrice() %></td>
				<td><a
					href="orderpro.jsp?user=<%=user %>&brandname=<%=cartList1.getProduct().getBrandName()%>&btype=<%=cartList1.getProduct().getBrandType()%>&bsize=<%=cartList1.getProduct().getBrandSize()%>&color=<%=cartList1.getProduct().getColor()%>"><button>
							<strong>Order</strong>
						</button></a>
			</tr>
			<%
				}
				%>
		</table>
	</div>



</body>
</html>