<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Automobile Rental Service</title>
  <link rel="stylesheet" href="./content/css/bookingDetails.css">
  <link href="https://cdn.jsdelivr.net/npm/remixicon@3.5.0/fonts/remixicon.min.css" rel="stylesheet">
  <script src="https://unpkg.com/scrollreveal@4.0.9/dist/scrollreveal.js"></script>
  
</head>

<body>


<input type="checkbox" id="bars">
  <nav class="nav-bar" id="navbar">
    <div class="content">
      <div class="logo nav__logo">
        <a href="#"><img src="content/carBackground.png" alt="logo" />
        <h1>MyCars</h1>
        </a>
      </div>

      <ul class="navigation">
        <li class="link"><a href="homePage.jsp">home</a></li>
        <li class="link"><a href="bookingCar.html">cars</a></li>
        <img src="content/setting3.png" class="user-pic" onclick="toggleMenu()">

        <div class="sub-menu-wrap" id="subMenu">
          <div class="sub-menu">
            <div div class="user-info">
              <i class="ri-profile-line"></i>
              <h2>Settings</h2>
            </div>
            <hr>

            <a href="viewProfileController" class="sub-menu-link">
              <img src="content/profile.png" alt="">
              <p>Profile</p>
              <span>></span>
            </a>
            <a href="ListOfBookingRRController" class="sub-menu-link">
              <img src="content/booking.png" alt="">
              <p>Your Booking</p>
              <span>></span>
            </a>
            <a href="ListCarRRController" class="sub-menu-link">
              <img src="content/car.png" alt="">
              <p>Your Car</p>
              <span>></span>
            </a>
            <a href="ListOfPaymentRRController" class="sub-menu-link">
              <img src="content/payment.png" alt="">
              <p>History</p>
              <span>></span>
            </a>
            <a href="logoutController" class="sub-menu-link">
              <img src="content/logout.png" alt="">
              <p>Logout</p>
              <span>></span>
            </a>
          </div>
        </div>
      
      </ul>

      <label for='bars' class="icon-bars"><i class="ri-bar-chart-2-fill"></i></label>
    </div>
  </nav>

  <header class="home" id="home">
    <div class="content">
      <h1>Fill <strong>in</strong> booking <strong>details</strong> </h1>
      <h4>You can earn more income by rent out your car</h4>
    </div>
  </header>

  <section class="car-form-panel">
    <div class="form-instructions">
        <h2 id="user-id">USER ID : <c:out value="${bridge.rr_id}"/></h2>
        <br></br>
        <h2 id="enter-details">CAR DETAILS</h2>
      </div>
      <div class="car-form1">
        <table>
        
          <tr>
            <td><strong>Car ID:</strong></td>
            <td> <c:out value="${bridge.car_id}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Type:</strong></td>
            <td> <c:out value="${bridge.car_type}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Brand:</strong></td>
            <td> <c:out value="${bridge.car_brand}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Model:</strong></td>
            <td> <c:out value="${bridge.car_model}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Color:</strong></td>
            <td> <c:out value="${bridge.car_color}"/> </td>
          </tr>
          <tr>
            <td><strong>Number of Seats:</strong></td>
            <td> <c:out value="${bridge.no_of_seats}"/> </td>
          </tr>
          <tr>
            <td><strong>Price/Day (RM):</strong></td>
            <td> <c:out value="${bridge.price_per_day}"/> </td>
          </tr>
          <tr>
            <td><strong>Car Plate:</strong></td>
            <td> <c:out value="${bridge.car_plate}"/> </td>
          </tr>
          
        </table>
  
      </div>
    <div class="form-instructions">
      <h2 id="enter-details">ENTER DETAILS FOR BOOKING</h2>
    </div>
    <div class="car-form">
      <form action="addBookingController" method="post">

        <!-- <label for="name">NAME :</label>
        <input type="text" id="name" name="name" required> -->

        <label for="bookingDate">Booking Date (You can only book a day before.):</label>
        <input type="date" id="bookingDate" name="bookingDate" readonly required>

        <label for="pickupLocation">Pickup Location:</label>
        <input type="text" id="pickupLocation" name="pickupLocation" required>

        <label for="dropLocation">Drop Location:</label>
        <input type="text" id="dropLocation" name="dropLocation" required>
        
       	<label for="booking_days">Booking Days:</label>
		<input type="number" id="booking_days" name="booking_days" min="1" step="1" required>

        <label for="rr_id">User ID:</label>
        <input type="text" id="rr_id" name="rr_id"  value="<c:out value="${bridge.rr_id}"/>" required readonly>
        
        <label for="car_id">Car ID:</label>
        <input type="text" id="car_id" name="car_id" value="<c:out value="${bridge.car_id}"/>" required readonly>

        <input type="submit" id="btn-submit" value="BOOKING">
      </form>
      
    </div>    
    
  </section>



  <script>
    // Get today's date
    var today = new Date();

    // Calculate tomorrow's date
    var tomorrow = new Date(today);
    tomorrow.setDate(today.getDate()+1);

    // Format the date as YYYY-MM-DD
    var formattedDate = tomorrow.toISOString().slice(0, 10);

    // Set the input value
    document.getElementById("bookingDate").value = formattedDate;
</script>
<script src="./js/homePage.js"></script>

</body>

</html>