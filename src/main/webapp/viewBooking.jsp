<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" href="./content/css/bookingPay.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
<body>


  <section class="car-form-panel">
    <div class="form-instructions">
      <h2 id="enter-details">Booking Details</h2> 
      
      <h2 id="user-id">BOOKING ID : <c:out value="${booking.booking_id}"/></h2>
      
      
    </div>
    <div class="car-form">
      <table>
        <tr>
          <td><strong>Booking Date:</strong></td>
          <td><c:out value="${booking.booking_date}"/></td>
        </tr>
        <tr>
          <td><strong>End Date:</strong></td>
          <td><c:out value="${booking.end_date}"/></td>
        </tr>
        <tr>
          <td><strong>Pickup Location:</strong></td>
          <td><c:out value="${booking.pickup_location}"/></td>
        </tr>
        <tr>
          <td><strong>Drop Location:</strong></td>
          <td><c:out value="${booking.drop_location}"/></td>
        </tr>
        <tr>
          <td><strong>User ID:</strong></td>
          <td><c:out value="${booking.rr_id}"/></td>
        </tr>
        <tr>
          <td><strong>Car ID:</strong></td>
          <td><c:out value="${booking.car_id}"/></td>
        </tr>
        
      </table>
      <button onclick="location.href='listBookingController'">Cancel</button>

    </div>

  <script src="./js/homePage.js"></script>

</body>
</html>