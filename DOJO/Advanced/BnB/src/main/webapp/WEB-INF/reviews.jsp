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
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<title>Insert title here</title>
	</head>
	<body>
		<c:if test="${user != null}">
			<a href="/listings">Home</a>
			<a href="/users/new">Logout</a>
		</c:if>
		<p>Welcome, ${user.firstname}</p>
		
		<!-- If user is a host logic, enable editing -->
		<!-- If user is a host and the list id matches the listing id, it belongs to you -->
		
		<c:if test="${user.isHost()}">								
			<c:forEach items="${user.listings}" var="list">
				<c:if test="${list.id == listing.id}">
					<p>Listing for ${listing.address }</p>
					<form:form action="/listings/${listing.id}" method="POST" modelAttribute="listing">
						<form:label path="description">Description:
							<form:errors path="description"></form:errors>
							<form:input path="description"></form:input>
						</form:label>
						<form:label path="size">Size:
							<form:errors path="size"></form:errors>
							<form:input path="size"></form:input>
						</form:label>
						<form:label path="cost">Cost:
							<form:errors path="cost"></form:errors>
							<form:input path="cost"></form:input>
						</form:label>
					</form:form>
					<input type="submit" value="Update"/>
				</c:if>
			</c:forEach>
		</c:if>
		
		<!-- If user is not a host logic, disable editing -->
		<!-- Just see property details -->
		
		<c:if test="${!user.isHost()}">
			<p>${listing.address}</p>
			<p>${listing.description}</p>
			
			<p>Email: ${listing.user.email}</p>
			<p>Name: ${listing.user.firstname} ${listing.user.lastname}</p>
			<p>Size: ${listing.size}</p>
			<p>Cost ($): ${listing.cost}</p>
		</c:if>
		
	
	
		
		<strong>Reviews: (${listing.average}/5)</strong>
		
		
		
		<c:if test="${ !user.host }">
			<a href="/listings/${listing.id}/review">Leave a Review</a>
		</c:if>
		
		<div class="reviews">
			<c:forEach items="${listing.reviews}" var="review">
				<p>${review.user.firstname}:</p>
				<p>Rating: ${review.rating}/5</p>
				<p>${review.description}</p>
			</c:forEach>
		</div>
		
	</body>
</html>