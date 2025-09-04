<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" href="content/css/rentOuts.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>
<body>
<div class="background" id="bookForm">
    <div class="booking-form">
    <br><br>
        <h2>Update Car Details</h2>
         
        <form action="EditCarRRController" method="post">

			<label for="car_id">Id:</label>
            <input type="text" name="car_id" value="<c:out value="${car.car_id}"/>"  readonly required><br>
            
            <label for="car_plate">Plate Number:</label>
            <input type="text" name="car_plate" value="<c:out value="${car.car_plate}"/>" readonly required><br>
       
            <label for="car_brand">Brand:</label>
            <input type="text" name="car_brand" value="<c:out value="${car.car_brand}"/>" readonly required><br>
            
            <label for="car_model">Model:</label>
            <input type="text" name="car_model" value="<c:out value="${car.car_model}"/>" readonly required><br>
            
            <label for="car_type">Type:</label>
            <input type="text" name="car_type" value="<c:out value="${car.car_type}"/>" readonly required><br>
            
            <label for="car_color">Color:</label>
            <input type="text" name="car_color" value="<c:out value="${car.car_color}"/>" required><br>
            
            <label for="no_of_seats">No. Of Seats:</label>
            <input type="number" name="no_of_seats" value="<c:out value="${car.no_of_seats}"/>" readonly required><br>
            
            <label for="price_per_day">Price/Day:</label>
            <input type="text" name="price_per_day" value="<c:out value="${car.price_per_day}"/>" required><br>
            
            <label for="availability">Car Availability:</label>
            <input type="text" name="availability" value="<c:out value="${car.availability}"/>" readonly required><br>
            
            <label for="ownerBusy">Owner Availability:</label>
<select id="ownerBusy" name="ownerBusy">
    <c:choose>
        <c:when test="${car.ownerBusy == 'false'}">
            <option value="false" selected>Available</option>
            <option value="true">Unavailable</option>
        </c:when>
        <c:when test="${car.ownerBusy == 'true'}">
            <option value="false">Available</option>
            <option value="true" selected>Unavailable</option>
        </c:when>
        <c:otherwise>
            <option value="false">Available</option>
            <option value="true">Unavailable</option>
        </c:otherwise>
    </c:choose>
</select><br>
<br>
             
            <label for="rr_id">User Id:</label>
            <input type="text" name="rr_id" value="<c:out value="${car.rr_id}"/>"  readonly><br>           

            <button type="submit">Update Car</button>
        </form>
        <button onclick="location.href='ListCarRRController'">Cancel</button>
       
    </div>
  </div>
</body>
</html> 



