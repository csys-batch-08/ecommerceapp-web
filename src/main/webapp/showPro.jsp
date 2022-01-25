<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowProduct</title>
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

table img, h3, a {
	padding-left: 30px;
}

table {
	padding-left: 10px;
	padding-bottom: 30px;
}

.searchbar {
	position: relative;
	top: 33px;
	left: 900px;
}
h2{
    text-align: center;
    color: red;
    font-weight: bold;}
</style>
</head>
<body style="background: threedhighlight;">
	<%
	UserDaoImpl userdao=new UserDaoImpl();
	Users user=(Users) session.getAttribute("CurrentUser");
	Users user1=userdao.validateUser(user.getEmail(),user.getPassword());
	
	Double wallet = (Double) session.getAttribute("amount");
	if (wallet != null) {
	%>
	<h4>
		Available Amount:<%=user1.getWallet()%></h4>
	<%
	}
	%>
	<%
	if (session.getAttribute("updatewallet") != null) {
	%>
	<h2>Refund Successfull!!</h2>
	<%
	session.removeAttribute("updatewallet");
	%>
	<%
	}
	%>
	<%
	String message = (String) session.getAttribute("balance");
	if (message != null) {
	%>
	<h2><%=message%></h2>
	<%
	session.removeAttribute("balance");
	%>
	<%
	}
	%>

	<div>
		<h1 style="text-align: center;">SHOE PRODUCTS</h1>
	</div>
	<div class="searchbar">
		<form action="SearchProductController">
			<label for="plan"></label> <input type="text" name="search"
				id="plan"> <input type="submit" value="search">
		</form>
	</div>
	<div>
		<ul>
             <li><a href="showorder.jsp">MyOrder</a></li>
			 <li><a href="showcartjsp.jsp">MyCart</a></li>
             <li><a href="OrderCancel.jsp?oid=0&price=0">OrderCancel</a></li>
			 <li><a href="walletupdate.jsp">RechargeWallet</a></li>
		     <li style="float: right;"><a href="User.jsp"> LogOut</a></li>

		</ul>
		<br> <br> <br> <br>
	</div>
	<div>
		<%
		ProductDaoImpl productdao = new ProductDaoImpl();
		List<Product> ProductList = productdao.showProduct();
		session.setAttribute("product", ProductList);
		for (int i = 0; i < ProductList.size(); i++) {
			Product productlist = ProductList.get(i);
		%>


		<div style="background-color:;" id="products">
			<table>
				<tr>
					<td><img src="<%=productlist.getColor()%>.jpg" alt="img"
						width=300px height=300px><br></td>
					<td>
						<h3>
							BrandName:
							<%=productlist.getBrandName()%></h3>
						<h3>
							BrandType :<%=productlist.getBrandType()%></h3>
						<h3>
							BrandSize :<%=productlist.getBrandSize()%></h3>
						<h3>
							Color :<%=productlist.getColor()%></h3>
						<h3>
							Price :<%=productlist.getPrices()%></h3>
						<h3>
							ManufactureDate :<%=productlist.getManufactureDate()%></h3> <a
						class="btn"
						href="orderpro.jsp?user=<%=user%>&brandname=<%=productlist.getBrandName()%>&btype=<%=productlist.getBrandType()%>&bsize=<%=productlist.getBrandSize()%>&color=<%=productlist.getColor()%>"><button>
								<strong>Order</strong>
							</button></a>&nbsp; &nbsp; <a class="btn"
						href="cartpro.jsp?brandname=<%=productlist.getBrandName()%>&btype=<%=productlist.getBrandType()%>&bsize=<%=productlist.getBrandSize()%>&color=<%=productlist.getColor()%>"><button>
								<strong> AddCart</strong>
							</button></a>
					</td>
				</tr>
			</table>








		</div>
		<%
				}
				%>
	</div>
</body>
</html>




