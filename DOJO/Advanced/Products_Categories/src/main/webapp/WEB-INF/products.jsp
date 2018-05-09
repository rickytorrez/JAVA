<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Products</title>
	</head>
	<body>
		<h1>New Product</h1>
		<!-- modelAttribute refers to empty object on ProductController line 25, this time we're using @ModelAttribute instead of Model -->
		<form:form action="/products/new" method="POST" modelAttribute="product">
			<form:label path="name">Name:
				<form:errors path="name"></form:errors>
				<form:input type="text" path="name"></form:input>
			</form:label>Description:
			<form:label path="description">
				<form:errors path="description"></form:errors>
				<form:input type="text" path="description"></form:input>
			</form:label>Price:
			<form:label path="price">
				<form:errors path="price"></form:errors>
				<form:input type="number" path="price"></form:input>
			</form:label>
			<input type="submit" value="Create Product" />
		</form:form>
		
	</body>
</html>