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
        <h2>Update Booking Details</h2>
        
        <form action="updateBookingRRController" method="post">

			<label for="booking_id">Booking Id:</label>
            <input type="text" name="booking_id" value="<c:out value="${booking.booking_id}"/>"  readonly><br>
            
            <label for="booking_date">Booking Date:</label>
            <input type="date" name="booking_date" value="<c:out value="${booking.booking_date}"/>"  readonly><br>
            
            <label for="end_date">End Date:</label>
            <input type="date" name="end_date" value="<c:out value="${booking.end_date}"/>"  readonly><br>
            
            
            <label for="pickup_location">Pickup Location:</label>
            <input type="text" name="pickup_location" value="<c:out value="${booking.pickup_location}"/>"  ><br>
            
            <label for="drop_location">Drop Location:</label>
            <input type="text" name="drop_location" value="<c:out value="${booking.drop_location}"/>"  ><br>
            
            <label for="booking_days">No. of Days:</label>
            <input type="text" name="booking_days" value="<c:out value="${booking.booking_days}"/>"  readonly><br>
            
            <label for="total_price">Total Price:</label>
            <input type="text" name="total_price" value="<c:out value="${booking.total_price}"/>"  readonly><br>
			
            
            <label for="rr_id">User Id:</label>
            <input type="text" name="rr_id" value="<c:out value="${booking.rr_id}"/>" readonly ><br>
            
            <label for="car_id">Car Id:</label>
            <input type="text" name="car_id" value="<c:out value="${booking.car_id}"/>"  readonly><br>

			
            <button type="submit">Update Booking</button>
            
        </form>
        <button onclick="location.href='ListOfBookingRRController'">Cancel</button>
       
    </div>
  </div>
</body>
</html>