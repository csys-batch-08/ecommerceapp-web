<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<br> <br>
	</div>
	<div>

		<table id="prod">
			<tr>

				<th>userName</th>
				<th>BrandName</th>
				<th>BrandType</th>
				<th>BrandSize</th>
				<th>color</th>
				<th>manufactureDate</th>
				<th>quantity</th>
				<th>price</th>
				<th>orderDate</th>
			</tr>
			<c:forEach items="${sessionScope.order}" var="OrderList">

				<tr>
					<td>${ OrderList.getUser().getName() }</td>
					<td>${ OrderList.getProduct().getBrandName()}</td>
					<td>${ OrderList.getProduct().getBrandType()}</td>
					<td>${ OrderList.getProduct().getBrandSize()}</td>
					<td>${ OrderList.getProduct().getColor()}</td>
					<td><fmt:parseDate value="${ OrderList.getProduct().getManufactureDate()}"
							pattern="yyyy-MM-dd" var="macthDate" type="date" /> <fmt:formatDate
							pattern="dd/MM/yyyy" value="${macthDate}" /></td>
					<td>${ OrderList.getQuantity() }</td>
					<td>${ OrderList.getPrice() }</td>
					<td><fmt:parseDate value="${ OrderList.getOrderDate()}"
							pattern="yyyy-MM-dd" var="macthDate" type="date" /> <fmt:formatDate
							pattern="dd/MM/yyyy" value="${macthDate}" /></td>


					<td><a class="btn"
						href="billcontroller?orderid=${ OrderList.getOrderId() }&user=${ OrderList.getUser().getName()}&brandname=${ OrderList.getProduct().getBrandName()}&btype=${ OrderList.getProduct().getBrandType()}&bsize=${ OrderList.getProduct().getBrandSize()}&color=${ OrderList.getProduct().getColor()}&manufacturedate=${ OrderList.getProduct().getManufactureDate()}&quantity=${ OrderList.getQuantity() }&price=${ OrderList.getPrice() }&orderDate=${ OrderList.getOrderDate() }"><button>
								<strong>ViewBill</strong>
							</button></a></td>

				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>