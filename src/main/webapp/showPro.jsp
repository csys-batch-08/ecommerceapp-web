<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ecommerceshoe.daoimpl.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ecommerceshoe.model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
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

h2 {
	text-align: center;
	color: red;
	font-weight: bold;
}
h4{
color:red;
}
h5{
  text-align:center;
  color:red;
}
</style>
</head>
<body style="background: threedhighlight;">

	<c:if test="${wallet!=null }">
		<h4>Available Amount:${ wallet}</h4>
	</c:if>
	<c:if test="${name!=null }">
		<h5>Hello ${ name}</h5>
	</c:if>
	<c:if test="${updatewallet!=null }">
		<h2>Refund SuccessFull!!</h2>
	</c:if>
	<c:remove var="updatewallet" scope="session" />

	<c:if test="${ balance!=null }">
		<h2>${ balance}</h2>
	</c:if>
	<c:remove var="balance" scope="session" />


	<div>
		<h1 style="text-align: center;">SHOE PRODUCTS</h1>
	</div>
	<div class="searchbar">
		<form action="SearchProductController">
			<label for="plan"></label> <input type="text" name="search" id="plan">
			<input type="submit" value="search">
		</form>
	</div>
	<div>
		<ul>
			<li><a href="showorder">MyOrder</a></li>
			<li><a href="showcart">MyCart</a></li>
			<li><a href="ordercancelcontroller?oid=0&price=0">OrderCancel</a></li>
			<li><a href="walletUpdate.jsp">RechargeWallet</a></li>
			<li style="float: right;"><a href="index.jsp"> LogOut</a></li>

		</ul>
		<br> <br> <br> <br>
	</div>
	<div>
		

			<div style="background-color:;" id="products">
				<table>
				<c:forEach items="${sessionScope.product}" var="productlist">
				
					<tr>
						<td><img src="assets/images/${ productlist.getColor()}.jpg" alt="img"
							width=300px height=300px><br></td>
						<td>
							<h3>BrandName: ${ productlist.getBrandName()}</h3>
							<h3>BrandType :${ productlist.getBrandType()}</h3>
							<h3>BrandSize :${ productlist.getBrandSize()}</h3>
							<h3>Color :${ productlist.getColor()}</h3>
							<h3>Price :${ productlist.getPrices()}</h3>
							<h3>
								ManufactureDate:
								<fmt:parseDate value="${productlist.getManufactureDate()}"
									pattern="yyyy-MM-dd" var="macthDate" type="date" />

								<fmt:formatDate pattern="dd/MM/yyyy" value="${macthDate}" />
							</h3> <a class="btn"
							href="ordergetvalue?brandname=${ productlist.getBrandName()}&btype=${ productlist.getBrandType()}&bsize=${ productlist.getBrandSize()}&color=${ productlist.getColor()}"><button>
									<strong>Order</strong>
								</button></a>&nbsp; &nbsp; <a class="btn"
							href="cartgetvalue?brandname=${ productlist.getBrandName()}&btype=${ productlist.getBrandType()}&bsize=${ productlist.getBrandSize()}&color=${ productlist.getColor()}"><button>
									<strong> AddCart</strong>
								</button></a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
	</div>
</body>
</html>




