<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<%@ page import="java.sql.ResultSet"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>orderProduct</title>
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
	<form action="orderProductController" method="post"
		onmouseover="check()">
		<div>

			<h1>
				<STRONG>ORDER DETAILS</STRONG>
			</h1>
			<c:if test="${proid!=null }">


				<label for="ProductID"><strong>ProductID:</strong></label>
				<input type="text" value="${proid }">
				<br>
				<br>
			</c:if>
			<label for="Quantity"><strong>Quantity:</strong></label> <input
				type="number" name="quan" id="quantity" list="quantity" required><br>
			<br> <label for="Price"><strong>Price:</strong></label> <input
				type="number" name="pri" id="Price" list="pri" required><br>
			<br>


			<div>
				<button>
					<strong>Order</strong>
				</button>
				&nbsp; &nbsp; &nbsp; &nbsp;
				<button type="reset">
					<strong>Reset</strong>
				</button>
			</div>
		</div>

	</form>
</body>
<script type="text/javascript">
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; 
var yyyy = today.getFullYear();
if(dd<10){
  dd='0'+dd
} 
if(mm<10){
  mm='0'+mm
} 

today = yyyy+'-'+mm+'-'+dd;
document.getElementById("odate").setAttribute("min", today);
</script>
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
