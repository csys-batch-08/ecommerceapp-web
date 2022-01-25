<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminPage</title>
<style>
label {
	width: 80px;
	display: inline-block;
}
</style>
</head>
<body>
	<form action="AdminController1" method="post">
		<div style="text-align: center">
			<h1>
				<b>ADMINLOGIN</b>
			</h1>
			<label for="Email"><strong>Email-id:</strong></label> <input
				type="email" name="Email" id="mail" list="email" autofocus required
				placeholder="abcd22@gmail.com"
				pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br>
			<br> <label for="PASSWORD"><strong>Password:</strong></label> <input
				type="password" name="pass" id="Password" list="word" required><br>
			<br>

			<div>
				<button>
					<strong>Login</strong>
				</button>

			</div>

		</div>
	</form>
</body>
</html>