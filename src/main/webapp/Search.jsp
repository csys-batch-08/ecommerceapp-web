<%@page import="com.ecommerceshoe.model.Users"%>
<%@page import="com.ecommerceshoe.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search</title>
</head>
<body>
<%
Users user = (Users) session.getAttribute("CurrentUser");
List<Product> searchpro=(List<Product>)session.getAttribute("list");
for(int i=0;i<searchpro.size();i++){
	Product productlist=searchpro.get(i);

%>
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
<%} %>
</body>
</html>