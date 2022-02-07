<%@page import="com.ecommerceshoe.model.Users"%>
<%@page import="com.ecommerceshoe.model.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerceshoe.daoimpl.OrderDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
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
}
</style>
</head>
<body style="background-color: pink;">
	
		<div>
			<h1 style="text-align: center;">Orders</h1>
			<ul>


				<li><a href="welcomeAdmin.jsp">Admin</a></li>

				<li style="float: right;"><a href="index.jsp"> LogOut</a></li>

			</ul>

			<br> <br>
		</div>
		<div>
			<table  aria-describedby="statuschange" id="prod">
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


				<c:forEach items="${requestScope.order}" var="orderList">
					<tr>
						<td>${ orderList.getOrderId() }</td>
						<td>${orderList.getUser().getName() }</td>
						<td>${orderList.getProduct().getBrandName()}</td>
						<td>${orderList.getProduct().getBrandType()}</td>
						<td>${orderList.getProduct().getBrandSize()}</td>
						<td>${orderList.getProduct().getColor()}</td>
						<td><fmt:parseDate
								value="${orderList.getProduct().getManufactureDate()}"
								pattern="yyyy-MM-dd" var="macthDate" type="date" /> <fmt:formatDate
								pattern="dd/MM/yyyy" value="${macthDate}" /></td>

						<td>${orderList.getQuantity()}</td>
						<td>${orderList.getPrice() }</td>
						<td><fmt:parseDate value="${orderList.getOrderDate()}"
								pattern="yyyy-MM-dd" var="macthDate" type="date" /> <fmt:formatDate
								pattern="dd/MM/yyyy" value="${macthDate}" /></td>

						<td>${orderList.getStatus() }</td>
						<td><c:if test="${orderList.getStatus() == 'Not Delivered'}">
								<a href="StatusChange?orderId=${ orderList.getOrderId() }">
									<button>StatusChange</button></a>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>

</body>
</html>