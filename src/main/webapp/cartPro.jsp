<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<%@ page import="java.sql.ResultSet"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart</title>
<style>
label {
	width: 80px;
	display: inline-block;
}

body {
	background-color: grey;
}
</style>
</head>
<body style="text-align: center;">
	<form action="cartProductController" method="post"
		onmouseover="check()">

		<div>

			<h1>
				<STRONG>CART DETAILS</STRONG>
			</h1>

			<br> <label for="Quantity"><strong>Quantity:</strong></label> <input
				type="number" name="quan" id="quantity" list="quantity" required><br>
			<br> <label for="Price"><strong>Price:</strong></label> <input
				type="number" name="pri" id="Price" list="pri" required><br>
			<br>


			<div>
				<button>
					<strong>AddCart</strong>
				</button>
				&nbsp; &nbsp; &nbsp; &nbsp;
				<button type="reset">
					<strong>Reset</strong>
				</button>
			</div>
		</div>

	</form>
</body>
<script>

<c:if test="${Price!=null }">
function check(){
	var count=document.getElementById("quantity").value;
	var totalPrice=document.getElementById("Price");
	console.log(count)
	totalPrice.value=count * ${Price};
	console.log(totalPrice.value);
}
</c:if>




</script>
</html>

