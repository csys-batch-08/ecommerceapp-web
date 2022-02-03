<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<br> <br>
	</div>
	<div>
		<table id="prod">
			<tr>
				<th>UserName</th>
				<th>BrandName</th>
				<th>BrandType</th>
				<th>BrandSize</th>
				<th>color</th>
				<th>quantity</th>
				<th>price</th>

			</tr>

			<c:forEach items="${sessionScope.cart}" var="cartList">

				<tr>
					<td>${ cartList.getUser().getName() }</td>
					<td>${ cartList.getProduct().getBrandName()}</td>
					<td>${ cartList.getProduct().getBrandType()}</td>
					<td>${ cartList.getProduct().getBrandSize()}</td>
					<td>${ cartList.getProduct().getColor()}</td>
					<td>${ cartList.getQuantity() }</td>
					<td>${ cartList.getPrice() }</td>
					<td><a
						href="ordergetvalue?user=${ user}&brandname=${ cartList.getProduct().getBrandName()}&btype=${cartList.getProduct().getBrandType()}&bsize=${ cartList.getProduct().getBrandSize()}&color=${cartList.getProduct().getColor()}"><button>
								<strong>Order</strong>
							</button></a>
				</tr>

			</c:forEach>
		</table>
	</div>



</body>
</html>