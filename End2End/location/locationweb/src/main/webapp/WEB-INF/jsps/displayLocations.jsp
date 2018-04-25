<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored ="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Locations</title>
</head>
	<body>
		<h2>Locations</h2>
		<table>
		
			<tr>
				<th>id</th>
				<th>code</th>
				<th>name</th>
				<th>type</th>
			</tr>
			
			<c:forEach items="${locations}" var="location">
			<tr>
				<td>${ location.id }</td>
				<td>${ location.code }</td>
				<td>${ location.name }</td>
				<td>${ location.type }</td>
			</tr>
			</c:forEach>
			
		</table>
	</body>
</html>