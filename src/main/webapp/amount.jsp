<%@page import="java.sql.ResultSet"%>
<%@page import="com.ecommerceshoe.daoimpl.OrderDaoImpl"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TotalAmount Of Sales</title>
<style>
body {
	background: threedface;
	text-align: center;
}

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
	border-bottom-right-radius: 20px;
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
	text-align: center;
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
	<h1>CALCULATING SALES</h1>
	<div>
		<ul>


			<li><a href="welcomeAdmin.jsp">Admin</a></li>

			<li style="float: right;"><a href="index.jsp"> LogOut</a></li>

		</ul>
		<br> <br> <br> <br>
	</div>
	<table id="prod">
		<tr>


			<th>ProductId</th>
			<th>TotalSales</th>
		</tr>

	</table>
</body>
</html>