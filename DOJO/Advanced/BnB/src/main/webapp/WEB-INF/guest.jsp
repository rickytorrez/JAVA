<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${user != null}">
			<a href="/listings">Home</a>
			<a href="/users/new">Logout</a>
		</c:if>
		
		<h2>Find your listing!</h2>
	
		<form method="GET" action="/listings/search" >
			<input type="text" name="search" />
			<input type="submit" value="Search" />
		</form>
	
		<table>
			<tr>
				<th>Address</th>
				<th>Size</th>
				<th>Cost</th>
				<th>Details</th>
			</tr>
			
			<c:forEach items="${ listings }" var="listing">
				<tr>
					<td>${listing.address }</td>
					<td>${listing.size }</td>
					<td>${listing.cost }</td>
					<td><a href="/listings/${listing.id}">See More</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>