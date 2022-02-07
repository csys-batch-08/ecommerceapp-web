<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>UserLogin</title>
<link rel="stylesheet" type="text/css" href="assets/css/index.css">

</head>
<body>


	<c:if test="${invalid!=null }">
		<h2>${invalid}</h2>
	</c:if>
	<c:remove var="invalid" scope="session" />
	<form action="User" method="post">
		<div style="text-align: center">
			<marquee width="100%" direction="LEFT" height="100px"
				scrollamount="10">
				<h1 style="color: black;">SHOEPRODUCTS</h1>
			</marquee>

			<h1>
				<b>LOGIN</b>
			</h1>
			<label for="Email"><strong>Email-Id:</strong></label> <input
				type="email" name="UserEmail" id="mail" list="email" autofocus
				required placeholder="abcd22@gmail.com"
				pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br> <br>
			<label for="PASSWORD"><strong>Password:</strong></label> <input
				type="password" name="Userpass" id="Password" list="word"
				pattern="[a-zA-Z0-9@#!.&]{8,16}" required><br> <br>

			<div>
				<button>
					<strong>Login</strong>
				</button>
				<a href="newUser.jsp"> createaccount?</a>
			</div>

		</div>
	</form>
</body>
<script>



</script>
</html>