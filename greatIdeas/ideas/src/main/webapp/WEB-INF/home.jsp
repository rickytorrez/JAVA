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
<title>Log In</title>
</head>
	<body>
		<c:forEach items="${errors}" var="err">
	   		<p>${err.defaultMessage}</p>
	    </c:forEach>
		<h1>Log In</h1>
	    <form:form method="POST" action="/users/new" modelAttribute="user">
		<p>
            <form:label path="firstname">First Name:</form:label>
            <form:input path="firstname"/>
        </p>
      	<p>
            <form:label path="lastname">Last Name:</form:label>
            <form:input path="lastname"/>
        </p>
       	<p>
            <form:label path="email">E-mail:</form:label>
            <form:input path="email"/>
        </p>
        <p>
            <form:label path="username">Username:</form:label>
            <form:input path="username"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="confirm">Password Confirmation:</form:label>
            <form:password path="confirm"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
		
		<h1>Register</h1>
		<form action="/users/login" method="post">
			<p>
			 	<label>Email
			 	<input type="text" required name="email"/>
			 	</label>		
			</p>
			<p>
			<label>Password	
				<input type="password" required name="password"/>
			</label>		
			</p>
				<input type="submit" class="btn btn-default" value="Login"/>
		</form> 
			<c:if test="${error != null}">
				<p>${ error }</p>
			</c:if>
	</body>
</html>