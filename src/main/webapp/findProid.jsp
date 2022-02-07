<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ProductId</title>
</head>
<body style="text-align: center;">
	<form action="ProductController" method="post">
		<div>
			<h1>
				<STRONG>FIND PRODUCTID</STRONG>
			</h1>
			<label for="BrandName"><strong>BrandName:</strong></label> <input
				type="text" name="bname" id="brandName" list="bname" autofocus
				required><br> <br> <label for="BrandType"><strong>BrandType:</strong></label>
			<input type="text" name="Btype" id="BrandType" list="Btype" required><br>
			<br> <label for="BrandSize"><strong>Size:</strong></label> <input
				type="number" name="bsize" id="Sizes" list="sizes" required><br>
			<br> <label for="Color"><strong>Color:</strong></label> <input
				type="text" name="col" id="COLOR" list="COL" required><br>
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