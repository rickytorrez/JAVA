<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Idea dashboard</title>
	</head>
	<body>
		<a href="users/logout"><button>Log Out</button></a>
		<h3>Howdy ${user.firstname}</h3>
		<a href="/ideas/new"><button>Create an Idea</button></a>
		<a href="/ideas/userIdeas"><button>My Ideas</button></a>
		
		<h4>Ideas</h4>
		<table border=1px>
			<tr>
				<th>Idea</th>
				<th>Created By</th>
				<th>Likes</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${ideas }" var="idea">
			<tr>
				<td><a href="/ideas/${idea.id}">${idea.content}</a></td>
				<td>${ idea.getUser().firstname } ${idea.getUser().lastname }</td>
				<td>${ idea.getFaveUsers().size() }</td>
				
				
					<td>
						<form action="/ideas/${idea.id}/like" method="post">
			        		<button>Like/Unlike</button>
		           		</form>
		           	</td>
	           
				
			</tr>
			</c:forEach>
		</table>
		
	</body>
</html>