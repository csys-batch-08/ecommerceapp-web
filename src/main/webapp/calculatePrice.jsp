<%@page import="java.sql.ResultSet"%>
<%@page import="com.ecommerceshoe.daoimpl.OrderDaoImpl"%>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculate Price</title>
<style>
label {
	width: 80px;
	display: inline-block;
}

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
	width: 20rem;
	/* height: 28rem; */
	padding: 15px 0px;
	display: flex;
	flex-direction: column;
	background-color: activecaption;
	box-shadow: 0 8px 32px 0 rgb(31 38 135/ 37%);
	border-radius: 30px;
	border-left: 1px solid;
	border-left: 1px solid rgba(255, 255, 255, .3);
	position: absolute;
	top: 1%;
	left: 35%;
}

button {
	width: 50%;
	margin: 3% auto;
	color: black;
	font-size: 15px;
	opacity: .7;
	background: black(255, 255, 255, 0.06);
	padding: 10px 30px;
	border: none;
	outline: none;
	border-radiurs: 20px;
	text-shadow: 2px 2px 4px rgba(255, 255, 255, 0.2);
	box-shadow: 3px 3px 5px rgba(31, 38, 135, .37);
	border-left: 1px solid rgba(255, 255, 255, .3);
	border-top: 1px solid rgba(255, 255, 255, .3)
}

#prod {
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
	border-bottom-right-radius: 10px;
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
	<table id="prod">
		<tr>
			<th>ProductId</th>
			<th>TotalSales</th>
		</tr>

		<c:forEach items="${sessionScope.List}" var="list">

			<tr>
				<td>${list.get(0)}</td>
				<td>${list.get(1)}</td>
			</tr>
		</c:forEach>

	</table>
	<form action="CalculatePriceController">
		<h2>CALCULATING SALES</h2>
		<div id="date">
			<label for="fromdate">FromDate:</label> <input type="date"
				name="fromDate" id="fromdate" required><br> <br> <label
				for="todate">ToDate:</label> <input type="date" name="toDate"
				id="todate" required><br> <br>
		</div>
		<button>
			<input type="submit" value="calculate">
		</button>
	</form>
</body>
</html>