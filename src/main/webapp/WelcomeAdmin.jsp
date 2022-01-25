<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Admin Page</title>
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

body {
	background:
		url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjuj9UGzlBGbrDjyyRieKPdegfmnTWvJHJ3A&usqp=CAU');
	background-repeat: no-repeat;
	background-size: cover;
	height: 100vh;
	color: white;
}
</style>
</head>
<body>
	<marquee width="100%" direction="LEFT" height="100px" scrollamount="10">
		<h1 style="color: black;">WELCOME ADMIN</h1>
	</marquee>

	<div>
		<ul>
			<li><a href="product.jsp">InsertProduct</a></li>
			<li><a href="UpdateProduct.jsp">UpdateProduct</a></li>
			<li><a href="deleteProduct.jsp?prodId=0">DeleteProduct</a></li>
			<li><a href="CalculatePrice.jsp">CalculateSales</a></li>
			<li><a href="StatusChange.jsp">StatusChange</a></li>
			<li style="float: right;"><a href="User.jsp"> LogOut</a></li>
		</ul>
	</div>
</body>
</html>