<%@page import="com.ecommerceshoe.model.Users"%>
<%@page import="com.ecommerceshoe.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>search</title>
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
</style>
</head>
<body style="background: threedhighlight;">
<div>
<h1 style="text-align: center;">Searched Product</h1>
<ul>


			<li><a href="showPro.jsp">Home</a></li>


		</ul>
		</div>
	<table  aria-describedby="search">
		<c:forEach items="${requestScope.search}" var="searchpro">
			<tr>


				<th><img src="assets/images/${ searchpro.getColor()}.jpg" alt="img"
					width=300px height=300px><br></th>
				<th>
					<h3>BrandName: ${ searchpro.getBrandName()}</h3>
					<h3>BrandType :${ searchpro.getBrandType()}</h3>
					<h3>BrandSize :${ searchpro.getBrandSize()}</h3>
					<h3>Color :${ searchpro.getColor()}</h3>
					<h3>Price :${ searchpro.getPrices()}</h3>
					<h3>
						ManufactureDate:
						<fmt:parseDate value="${searchpro.getManufactureDate()}"
							pattern="yyyy-MM-dd" var="macthDate" type="date" />

						<fmt:formatDate pattern="dd/MM/yyyy" value="${macthDate}" />
					</h3> <a class="btn"
					href="ordergetvalue?user=${ user}&brandname=${ searchpro.getBrandName()}&btype=${ searchpro.getBrandType()}&bsize=${ searchpro.getBrandSize()}&color=${ searchpro.getColor()}"><button>
							<strong>Order</strong>
						</button></a>&nbsp; &nbsp; <a class="btn"
					href="cartgetvalue?brandname=${ searchpro.getBrandName()}&btype=${ searchpro.getBrandType()}&bsize=${ searchpro.getBrandSize()}&color=${ searchpro.getColor()}"><button>
							<strong> AddCart</strong>
						</button></a>
				</th>

			</tr>
		</c:forEach>
	</table>

</body>
</html>