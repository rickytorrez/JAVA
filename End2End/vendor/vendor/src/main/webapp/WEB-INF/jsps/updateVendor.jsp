<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<form action="updateVend" method="post">
			<pre>
				Id: <input type="text" name="id" value="${vendor.id}" readonly />
				Code: <input type="text" name="code" value="${vendor.code}" />
				Name: <input type="text" name="name" value="${vendor.name}" />
				Type: 	<select name="type">
							<option ${vendor.type == 'Regular' ? 'selected' : ''}>Regular</option>
							<option ${vendor.type == 'Contract' ? 'selected' : ''}>Contract</option>
						</select>
				Email: <input type="text" name="email" value="${vendor.email}" />
				Phone: <input type="text" name="phone" value="${vendor.phone}" />
				Address: <textarea rows="4" cols="50" name="address" >${vendor.address}</textarea>
				<input type="Submit" value="save" />
			</pre>
		</form>
	</body>
</html>