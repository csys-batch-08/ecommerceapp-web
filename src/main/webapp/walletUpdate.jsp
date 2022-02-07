<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>wallet update</title>
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
</style>
</head>
<body style="background-color: pink;">

	<c:if test="${recharge!=null }">
		<h1>RechargeSuccessfull</h1>
	</c:if>
	<c:remove var="recharge" scope="session" />

	<form action="UpdateWalletController">
		<div style="text-align: center">
			<h1>
				<b>WalletUpdate</b>
			</h1>
			<div>
				<ul>
					<li><a href="showPro.jsp">Home</a></li>
				</ul>
				<br> <br>
			</div>
			<label for="Amount"><strong>EnterAmount:</strong></label> <input
				type="number" name="Amount" id="amount" list="amount" autofocus
				required placeholder="Enter Amount" min="0"><br> <br>
			<div>
				<button>
					<strong>update</strong>
				</button>
				&nbsp; &nbsp; &nbsp; &nbsp;
				<button type="reset">
					<strong>Reset</strong>
				</button>
			</div>
		</div>
	</form>
</body>
</html>