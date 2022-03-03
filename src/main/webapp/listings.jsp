<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Listings</title>
</head>
<body>
<form method= "post" action="listingServlet" onSubmit="return confirm('Do you want to order this car?') ">
<input type ="hidden" name ="id" value="${id}">
<table>
<c:forEach items="${requestScope.allCars}" var="currentCar">
<tr>
<td><input type="radio" name="carId" value="${currentCar.id}"></td>
<td><h2>${currentCar.year} ${currentCar.make} ${currentCar.model}</h2></td></tr>
<tr><td><h3>Price: ${currentCar.price}</h3></td></tr>
<tr><td colspan="3">Type: ${currentCar.type}</td></tr>
<tr><td colspan="3">Color: ${currentCar.color}</td></tr>
<tr><td colspan="3">Fuel Type: ${currentCar.fuelType}</td></tr>
<c:set var="fuelType" value="${currentCar.fuelType}"/>
<c:if test="${(fuelType != 'Electric')}">
<tr><td colspan="3">Miles Per Gallon: ${currentCar.mpg}</td></tr>
</c:if>
<c:if test="${(fuelType == 'Electric')}">
<tr><td colspan="3">Range: ${currentCar.mpg}</td></tr>
</c:if>
<tr><td colspan="3">Safety Rating: ${currentCar.safetyRating}</td></tr>
<tr><td colspan="3">Engine: ${currentCar.engine}</td></tr>
<tr><td colspan="3">Transmission: ${currentCar.transmission}</td></tr>
<tr><td colspan="3">Drivetrain: ${currentCar.drivetrain}</td></tr>
</c:forEach>
</table>
<input type = "submit" value= "Order">
</form>
</body>
</html>