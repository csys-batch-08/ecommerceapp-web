<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show order</title>

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
		<h1 style="text-align: center;">My Orders</h1>
		<ul>


			<li><a href="showPro.jsp">Home</a></li>


		</ul>
		<br>
		<br>
	</div>
	<div>
		<table id="prod">
			<tr>
			
				<th>username</th>
				<th>Brandname</th>
				<th>Brandtype</th>
				<th>Brandsize</th>
				<th>color</th>
				<th>manufacturedate</th>
				<th>quantity</th>
				<th>price</th>
				<th>orderdate</th>
			</tr>
			<%
				OrderDaoImpl orderdao=new OrderDaoImpl();
			   Users user=(Users)session.getAttribute("CurrentUser");
				List<Order> OrderList=orderdao.ShowOrder(user);
				for(Order orderList1 : OrderList){
				%>

			<tr>
				<td><%=orderList1.getUser().getName() %></td>
				<td><%=orderList1.getProduct().getBrandName()%></td>
				<td><%=orderList1.getProduct().getBrandType()%></td>
				<td><%=orderList1.getProduct().getBrandSize()%></td>
				<td><%=orderList1.getProduct().getColor()%></td>
				<td><%=orderList1.getProduct().getManufactureDate()%></td>
				<td><%=orderList1.getQuantity() %></td>
				<td><%=orderList1.getPrice() %></td>
				<td><%=orderList1.getOrderDate() %></td>
                <td><a
						class="btn"
						href="Bill.jsp?orderid=<%=orderList1.getOrderId() %>&user=<%=orderList1.getUser().getName() %>&brandname=<%=orderList1.getProduct().getBrandName()%>&btype=<%=orderList1.getProduct().getBrandType()%>&bsize=<%=orderList1.getProduct().getBrandSize()%>&color=<%=orderList1.getProduct().getColor()%>&manufacturedate=<%=orderList1.getProduct().getManufactureDate()%>&quantity=<%=orderList1.getQuantity() %>&price=<%=orderList1.getPrice() %>&orderDate=<%=orderList1.getOrderDate() %>"><button>
								<strong>ViewBill</strong>
							</button></a></td>

			</tr>
			<%
				}
				%>
		</table>
	</div>

</body>
</html>