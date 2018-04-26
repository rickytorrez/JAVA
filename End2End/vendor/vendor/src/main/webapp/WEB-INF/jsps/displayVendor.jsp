<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored = "false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Vendor</title>
</head>
	<body>
		<table border="1px">
			<tr>
				<th>Id</th>
				<th>Code</th>
				<th>Name</th>
				<th>Type</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${vendors}" var="vendor">
				<tr>
					<td>${ vendor.id }</td>
					<td>${ vendor.code }</td>
					<td>${ vendor.name }</td>
					<td>${ vendor.type }</td>
					<td>${ vendor.email }</td>
					<td>${ vendor.phone }</td>
					<td>${ vendor.address }</td>
					<td>
						<a href="deleteVendor?id=${vendor.id}">Delete</a>
						<a href="showVendor?id=${vendor.id}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="showCreate">Dashboard</a>
	</body>
</html>