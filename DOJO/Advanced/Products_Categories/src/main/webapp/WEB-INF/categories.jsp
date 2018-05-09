<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>New Category</h1>
		<!-- modelAttribute refers to empty object on CategoryController line 29 -->
		<form:form action="/categories/new" method="POST" modelAttribute="category">
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input path="name"></form:input>
			</form:label>
			<input type="submit" value="Create Category" />
		</form:form>
	</body>
</html>