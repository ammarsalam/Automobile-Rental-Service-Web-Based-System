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
              <p>Your Payment</p>
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
      <h1>Payment <strong>Details</strong>  <strong></strong> </h1>
      <h4>Below is the Payment Details</h4>
    </div>
  </header>

  <section class="car-form-panel">
    <div class="form-instructions">
        <h2 id="user-id">PAYMENT DETAILS </h2>
      </div>
      <div class="car-form1">
        <table>
        
          <tr>
          <td><strong>Payment ID:</strong></td>
          <td><c:out value="${bridge.payment_id}"/></td>
        </tr>
        <tr>
          <td><strong>Booking_id:</strong></td>
          <td><c:out value="${bridge.booking_id}"/></td>
        </tr>
        <tr>
          <td><strong>Payment Type:</strong></td>
          <td><c:out value="${bridge.payment_type}"/></td>
        </tr>
        <tr>
          <td><strong>Total Price:</strong></td>
          <td><c:out value="${bridge.totalPrice}"/></td>
        </tr>
        <tr>
          <td><strong>No Of Days:</strong></td>
          <td><c:out value="${bridge.booking_days}"/></td>
        </tr>
        <tr>
          <td><strong>Car Brand:</strong></td>
          <td><c:out value="${bridge.car_brand}"/></td>
        </tr>
        <tr>
          <td><strong>Car Model:</strong></td>
          <td><c:out value="${bridge.car_model}"/></td>
        </tr>
        
        </table>
        <br>
        <button id="btn-submit" onclick="location.href='invoiceController?payment_id=<c:out value="${bridge.payment_id}"/>'">Invoice</button>
         <br>  <br> 
        <button id="btn-submit" onclick="location.href='ListOfPaymentRRController'">Cancel</button> 
        <br>
        
      </div>
   
  </section>

  <script src="./js/homePage.js"></script>

</body>

</html>