<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status change Product</title>
<style>
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
</style>
</head>
<body>

<c:set var="proId" value="${param.proId}" />
<c:set var="bName" value="${param.bName}" />
<c:set var="bType" value="${param.bType}" />
<c:set var="bSize" value="${param.bSize}" />
<c:set var="color" value="${param.color}" />
<c:set var="prices" value="${param.prices}" />

<h3>productId:${proId}</h3>
<h3>brandName:${bName}</h3>
<h3>brandType:${bType}</h3>
<h3>brandSize:${bSize}</h3>
<h3>color:${color}</h3>
<h3>prices:${prices}</h3>
<h2>Do You Want To UpdateProduct?</h2>
<a href="deleteProductController?proid=${proId}"><button>yes</button></a>
<a href="deleteProduct.jsp">no</a>

</body>
</html>