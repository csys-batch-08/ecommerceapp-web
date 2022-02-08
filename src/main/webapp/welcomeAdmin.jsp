<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>WelcomeAdminPage</title>
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
h1{
text-align:center;
}
</style>
</head>
<body>
	
		<h1 style="color: black;">WELCOME ADMIN</h1>
	

	<div>
		<ul>
			<li><a href="product.jsp">InsertProduct</a></li>
			<li><a href="adminupdatecontroller">UpdateProduct</a></li>
			<li><a href="deleteproductgetvalue?prodId=0">DeleteProduct</a></li>
			<li><a href="calculatePrice.jsp">CalculateSales</a></li>
			<li><a href="statuschangegetvalue">StatusChange</a></li>
			<li style="float: right;"><a href="index.jsp"> LogOut</a></li>
		</ul>
	</div>
</body>
</html>