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
		<title>New Idea</title>
	</head>
	<body>
		<a href="users/logout"><button>Log Out</button></a>
		<h3>Any suggestions, ${user.firstname}?</h3>
		
		<form:form method="POST" action="/ideas/newIdea" modelAttribute="idea">
			<form:label path="content">Content:
				<form:input path="content"></form:input>
				<form:errors path="content"/>
			</form:label>
			<input type="submit" value="Create Idea" />
		</form:form>
	</body>
</html>