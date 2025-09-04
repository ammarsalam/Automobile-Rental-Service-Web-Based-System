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
        <li class="link"><a href="DisplayCarController">cars</a></li>
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
      <h1>VERIFY <strong>ACCOUNT</strong> BEFORE <strong>BOOKING</strong> </h1>
      <h4>You need verify your account for confirmation</h4>
    </div>
  </header>

  <section class="car-form-panel">
    
    <div class="form-instructions">
      <h2 id="enter-details">ENTER DETAILS FOR VERIFY</h2>
    </div>
    <div class="car-form">
      <form action="ConfirmBookingController" method="post">

        <label for="user_name">User Name:</label>
        <input type="text" id="user_name" name="user_name" required>

        <label for="user_password">Password:</label>
        <input type="password" id="user_password" name="user_password" required>

        <label for="car_id">Car ID:</label>
        <input type="text" id="car_id" name="car_id" value="<c:out value="${bridge.car_id}"/>" required readonly>

        <input type="submit" id="btn-submit" value="VERIFY">
      </form>
      
    </div>    
    
  </section>

  <script src="./js/homePage.js"></script>

</body>

</html>