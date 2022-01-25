<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<form action="cartProductController" method="post"
		onmouseover="check()">

		<%!Users user; %>
		<%
UserDaoImpl userDaoImpl = new UserDaoImpl();
String bname = request.getParameter("brandname");
String btype = request.getParameter("btype");
int bsize = Integer.parseInt(request.getParameter("bsize"));
String color = request.getParameter("color");
 user=(Users)session.getAttribute("CurrentUser");
 
 Users user1 = new Users(user.getEmail());
 System.out.println(user);
 int userid=userDaoImpl.findUserID(user1);
 user.setUserid(userid);
 System.out.println(userid);
// Userrequest.getParameter("user")
 ProductDaoImpl productdao=new ProductDaoImpl();
 Product product=new Product(bname,btype,bsize,color);
 ResultSet rs= productdao.findProductId(product);
 session.setAttribute("currentproduct", product);
 if(rs.next()){
	 
 
%>


		<div>

			<h1>
				<STRONG>CART DETAILS</STRONG>
			</h1>
			<label for="ProductID"><strong>ProductId:</strong></label> <input
				type="text" value="<%=rs.getInt(1) %>"><br>
			<br> <label for="Quantity"><strong>Quantity:</strong></label> <input
				type="number" name="quan" id="quantity" list="quantity" required><br>
			<br> <label for="Price"><strong>Price:</strong></label> <input
				type="number" name="pri" id="Price" list="pri" required><br>
			<br>


			<div>
				<button>
					<strong>Addcart</strong>
				</button>
				&nbsp; &nbsp; &nbsp; &nbsp;
				<button type="reset">
					<strong>Reset</strong>
				</button>
			</div>
		</div>

	</form>
</body>
<script>

function check(){
	var count=document.getElementById("quantity").value;
	var totalPrice=document.getElementById("Price");
	console.log(count)
	totalPrice.value=count * <%=rs.getDouble(2) %>;
	console.log(totalPrice.value);
}

<%
 }%>



</script>
</html>

