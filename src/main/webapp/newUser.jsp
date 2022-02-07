<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>NewUser</title>
<style>
label {
	width: 120px;
	display: inline-block;
}

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

button {
	width: 50%;
	margin: 3% auto;
	color: black;
	font-size: 15px;
	opacity: .7;
	background: black(255, 255, 255, 0.06);
	padding: 10px 30px;
	border: none;
	outline: none;
	border-radiurs: 20px;
	text-shadow: 2px 2px 4px rgba(255, 255, 255, 0.2);
	box-shadow: 3px 3px 5px rgba(31, 38, 135, .37);
	border-left: 1px solid rgba(255, 255, 255, .3);
	border-top: 1px solid rgba(255, 255, 255, .3)
}
</style>
</head>

<body>
	<form action="UserCreateAccountController" method="post">
		<div>
			<h1>
				<b>SIGNUP</b>
			</h1>


			<label for="NAME"><strong>Name:</strong></label> <input type="text"
				name="name" id="NAME" list="NAM" pattern="[a-zA-z0-9]{3,}" autofocus
				required><br> <br> <label for="PASSWORD"><strong>Password:</strong></label>
			<input type="password" name="pass" id="Password" list="word"
				pattern="[a-zA-Z0-9@#!.&]{8,16}" required><br> <br>
			<label for="MobileNumber"><strong>MobileNumber:</strong></label> <input
				type="tel" name="num" id="number" pattern="[6-9]{1}[0-9]{9}"
				title="Phone number with 7-9 and remaing 9 digit with 0-9" required><br>
			<br> <label for="Email"><strong>Email-id:</strong></label> <input
				type="email" name="UserEmail" id="mail" list="email" required
				placeholder="abcd22@gmail.com"
				pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br> <br>
			<label for="Address"><strong>Address: </strong></label> <input
				type="text" name="address" id="add" list="add" required><br>
			<br>


			<button>
				<strong>Submit</strong>
			</button>
			<button type="reset">
				<strong>Reset</strong>
			</button>

		</div>
	</form>
</body>
</html>