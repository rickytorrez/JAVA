<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flights</title>
</head>
	<body>
		<h2>Flights</h2>
		<table>
			<tr>
				<th>Airlines</th>
				<th>Departure City</th>
				<th>Arrival City</th>
				<th>Departure Time</th>
				
			</tr>
		</table>
		
		<c:forEach items="${flights}" var="x">
			<tr>
				<td>${x.operatingAirlines}</td>
				<td>${x.departureCity}</td>
				<td>${x.arrivalCity}</td>
				<td>${x.estimatedDepartureTime}</td>
				<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a></td>
			</tr>
			
		</c:forEach>
	</body>
</html>