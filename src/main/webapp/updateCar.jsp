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
<br><br><br>
<div class="background" id="bookForm">
    <div class="booking-form">
        <h2>Update Car Details</h2>
        <form action="updateCarController" method="post">

			<label for="car_id">Id:</label>
            <input type="text" name="car_id" value="<c:out value="${car.car_id}"/>"  readonly><br>
            
            <label for="car_plate">Plat No:</label>
            <input type="text" name="car_plate" value="<c:out value="${car.car_plate}"/>"  ><br>
       
            <label for="car_brand">Brand:</label>
            <input type="text" name="car_brand" value="<c:out value="${car.car_brand}"/>"  ><br>
            
            <label for="car_model">Model:</label>
            <input type="text" name="car_model" value="<c:out value="${car.car_model}"/>"  ><br>
            
            <label for="car_type">Type:</label>
            <input type="text" name="car_type" value="<c:out value="${car.car_type}"/>"  ><br>
            
            <label for="car_color">Color:</label>
            <input type="text" name="car_color" value="<c:out value="${car.car_color}"/>"  ><br>
            
            <label for="no_of_seats">No. Of Seats:</label>
            <input type="number" name="no_of_seats" value="<c:out value="${car.no_of_seats}"/>"  ><br>
            
            <label for="price_per_day">Price/Day:</label>
            <input type="text" name="price_per_day" value="<c:out value="${car.price_per_day}"/>"  ><br>
            
            <label for="availability">Availability:</label>
            <input type="text" name="availability" value="<c:out value="${car.availability}"/>"  readonly><br>
            
            <!-- <label for="ownerBusy">Owner Busy:</label>  -->
            <input type="hidden" name="ownerBusy" value="<c:out value="${car.ownerBusy}"/>" readonly >
            
            <label for="user_id">User Id:</label>
            <input type="text" name="rr_id" value="<c:out value="${car.rr_id}"/>"  readonly><br>
            
            

            <button type="submit">Update Car Details</button>
        </form>
        <button onclick="location.href='listCarController'">Cancel</button>
    </div>
  </div>	
</body>
</html>