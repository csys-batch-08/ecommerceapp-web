<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertproduct</title>
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
	background-color: #111;
}

.active {
	background-color: #04AA6D;
}

label {
	width: 130px;
	display: inline-block;
}

body {
	background-color: pink;
}
</style>
</head>
<body style="text-align: center;">
	<form action="ProductController" method="post">
		<div>
			<h1>
				<STRONG>INSERT PRODUCT DETAILS</STRONG>
			</h1>
			<div>
				<ul>


					<li><a href="WelcomeAdmin.jsp">Home</a></li>


				</ul>
				<br>
				<br>
			</div>
			<label for="BrandName"><strong>BrandName:</strong></label> <input
				type="text" name="bname" id="brandName" list="bname" autofocus
				required><br>
			<br> <label for="BrandType"><strong>BrandType:</strong></label>
			<input type="text" name="Btype" id="BrandType" list="Btype" required><br>
			<br> <label for="BrandSize"><strong>Size:</strong></label> <input
				type="number" name="bsize" id="Sizes" list="sizes" required><br>
			<br> <label for="Color"><strong>Color:</strong></label> <input
				type="text" name="col" id="COLOR" list="COL" required><br>
			<br> <label for="Price"><strong>Price:</strong></label> <input
				type="number" name="pri" id="Price" list="pri" min="0" required><br>
			<br> <label for="manufacturedate"><strong>ManufactureDate:</strong></label>
			<input type="date" name="manufacture" id="mdate" list="mdate"
				placeholder="yyyy-mm-dd" value="" required><br>
			<br>



			<div>
				<button>
					<strong>Submit</strong>
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