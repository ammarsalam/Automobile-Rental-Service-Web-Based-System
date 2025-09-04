<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Automobile Rental Service</title>
  <link rel="stylesheet" href="./content/css/bookingPay.css">
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
      <h1> CONFIRM <strong>DETAILS <br>	</strong> BEFORE <strong>PAYMENT</strong> </h1>
      <h4>Below is the car and booking details</h4>  
    </div>
  </header>

  <section class="car-form-panel">
    <div class="form-instructions">
      <h2 id="user-id">USER ID : <c:out value="${bridge.rr_id}"/></h2>
      <h2 id="user-id">BOOKING ID : <c:out value="${bridge.booking_id}"/></h2>
      
      <br></br>
      <h2 id="enter-details">CAR DETAILS</h2>
    </div>
    <!-- car table -->
    <div class="car-form">
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
            <td><strong>Price/hour (RM):</strong></td>
            <td> <c:out value="${bridge.price_per_day}"/> </td>
          </tr>
          
      </table>

    </div>

    <!-- Booking table -->
    <div class="form-instructions">
      <h2 id="booking-details">BOOKING DETAILS</h2>
    </div>
    <div class="car-form">
      <table>
        <tr>
          <td><strong>Booking Date:</strong></td>
          <td> <c:out value="${bridge.booking_date}"/> </td>
        </tr>
        <tr>
          <td><strong>End Date:</strong></td>
          <td> <c:out value="${bridge.end_date}"/> </td>
        </tr>
        <tr>
          <td><strong>Pickup Location:</strong></td>
          <td> <c:out value="${bridge.pickup_location}"/> </td>
        </tr>
        <tr>
          <td><strong>Drop Location:</strong></td>
          <td> <c:out value="${bridge.drop_location}"/> </td>
        </tr>
        <tr>
          <td><strong>No. of Days:</strong></td>
          <td> <c:out value="${bridge.booking_days}"/> </td>
        </tr>
        <tr>
          <td><strong>Total Price:</strong></td>
          <td> RM<c:out value="${bridge.totalPrice}"/> </td>
        </tr>
        
        
      </table>

    </div>
    <button id="go-to-payment" onclick="location.href='BookingCancelController?booking_id=${bridge.booking_id}'">CANCEL</button>
 
    <button id="go-to-payment" onclick="location.href='makePaymentController'">MAKE A PAYMENT</button> <!-- makePaymentController -->
    <!-- listOfBookingRR -->

  </section>

  <!-- User ID -->
  <div class="user-info">
    <h2>User ID: <!-- Insert user ID here --></h2>
  </div>

  <!-- Form for Car Details -->

  <script src="./js/homePage.js"></script>

</body>

</html>