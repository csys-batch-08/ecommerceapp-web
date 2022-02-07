<%@page import="com.ecommerceshoe.daoimpl.OrderDaoImpl"%>
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
		<div style="text-align: left; padding-left: 120px;">

			<c:forEach items="${requestScope.order}" var="order">
				<h3>OrderId:${order.getOrderId() }</h3>
				<h3>UserName:${order.getUser().getName() }</h3>
				<h3>BrandName:${order.getProduct().getBrandName()}</h3>
				<h3>BrandType:${order.getProduct().getBrandType()}</h3>
				<h3>BrandSize:${order.getProduct().getBrandSize()}</h3>
				<h3>Color:${order.getProduct().getColor()}</h3>
				<h3>
					ManufactureDate:
					<fmt:parseDate value="${order.getProduct().getManufactureDate()}"
						pattern="yyyy-MM-dd" var="macthDate" type="date" />

					<fmt:formatDate pattern="dd/MM/yyyy" value="${macthDate}" />
				</h3>

				<h3>Quantity:${order.getQuantity() }</h3>
				<h3>Price:${order.getPrice() }</h3>
				<h3>
					OrderDate:
					<fmt:parseDate value="${order.getOrderDate()}" pattern="yyyy-MM-dd"
						var="macthDate" type="date" />

					<fmt:formatDate pattern="dd/MM/yyyy" value="${macthDate}" />
				</h3>



			</c:forEach>
		</div>
	</form>
</body>
</html>