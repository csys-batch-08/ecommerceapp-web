<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>UserLogin</title>
<style>
label {
	width: 80px;
	display: inline-block;
}

.imgg {
	
}

#invalhead {
	font-size: 50px;
	color: red;
}

body {
	background:
		url('https://images.unsplash.com/photo-1514385295299-4f4327e50847?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDA5fHxwdW1hJTIwc25lYWtlcnN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60');
	background-repeat: no-repeat;
	background-size: cover;
	height: 100vh;
	color: white;
}
h3{
    text-align: center;
    color: red;
    font-weight: bold;}
</style>
</head>
<body>
  <%String error=(String)session.getAttribute("invalid");
  if(error!=null)
  { %>
  <h3><%=error %></h3>
  <%session.removeAttribute("invalid"); %>
  <%} %>
	
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
				pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br>
			<br> <label for="PASSWORD"><strong>Password:</strong></label> <input
				type="password" name="Userpass" id="Password" list="word"
				pattern="[a-zA-Z0-9@#!.&]{8,16}" required><br>
			<br>

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