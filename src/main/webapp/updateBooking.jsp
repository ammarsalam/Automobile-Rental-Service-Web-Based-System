<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" href="./content/css/rentOut.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>
<body>
<div class="background" id="bookForm">
    <div class="booking-form">
        <h2>Update Car Details</h2>
        <form action="updateBookingController" method="post">
            <!-- <label for="platNo">Car Id:</label>
            <input type="text" name="carID" id="platNo" required> -->

			<label for="booking_id">Id:</label>
            <input type="text" name="booking_id" value="<c:out value="${booking.booking_id}"/>"  readonly required><br>
            
            <label for="booking_date">Booking Date:</label>
            <input type="date" name="booking_date" value="<c:out value="${booking.booking_date}"/>"  readonly required><br>
            
            <label for="booking_date">End Date:</label>
            <input type="date" name="end_date" value="<c:out value="${booking.end_date}"/>"  readonly required><br>
            
            
            <label for="pickup_location">Pickup Location:</label>
            <input type="text" name="pickup_location" value="<c:out value="${booking.pickup_location}"/>"  required><br>
            
            <label for="drop_location">Drop Location:</label>
            <input type="text" name="drop_location" value="<c:out value="${booking.drop_location}"/>"  required><br>
            
            <label for="rr_id">User Id:</label>
            <input type="text" name="rr_id" value="<c:out value="${booking.rr_id}"/>" readonly required><br>
            
            <label for="car_id">Color:</label>
            <input type="text" name="car_id" value="<c:out value="${booking.car_id}"/>"  readonly required><br>

            <button type="submit">Update Booking Details</button>
        </form>
        <button onclick="location.href='listBookingController'">Cancel</button>
    </div>
  </div>
</body>
</html>