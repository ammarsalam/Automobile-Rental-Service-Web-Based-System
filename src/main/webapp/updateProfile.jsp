<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <h1>Profile <strong>Setting</strong>  <strong></strong> </h1>
	  <h4>Update Details</h4>
    </div>
  </header>

  <section class="car-form-panel">
    <div class="form-instructions">
      <h2 id="enter-details">PROFILE DETAILS</h2>
    </div>
    <div class="car-form">
      <form id="profile-form" action="updateProfileController" method="post">

        <label for="rr_id">User ID :</label>
        <input type="number" id="rr_id" name="rr_id" value="<c:out value="${user_id}"/>" readonly><br>

        <label for="user_name">User Name :</label>
        <input type="text" name="user_name" value="<c:out value="${bridge.user_name}"/>" readonly><br>

        <label for="user_password">User Password :</label>
        <input type="text" id="user_password" name="user_password" value="<c:out value="${bridge.user_password}"/>" readonly><br>
        
        <label for="user_email">E-mail :</label>
        <input type="text" id="user_email" name="user_email" value="<c:out value="${bridge.user_email}"/>" readonly><br>

        <label for="rr_address">User Address :</label>
        <input type="text" id="rr_address" name="rr_address" value="<c:out value="${bridge.rr_address}"/>" ><br>
        
        <label for="rr_pNum">Phone Number :</label>
        <input type="text" id="rr_pNum" name="rr_pNum" value="<c:out value="${bridge.rr_pNum}"/>" ><br>
        
        <label for="rr_license">License :</label>
        <input type="text" id="rr_license" name="rr_license" value="<c:out value="${bridge.rr_license}"/>" ><br>
        
        <label for="rr_experience">Experience (years):</label>
        <input type="text" id="rr_experience" name="rr_experience" step="1" value="<c:out value="${bridge.rr_experience}"/>"  ><br>

        <input type="submit" id="btn-submit" value="COMFIRM">
      </form>
      
    </div>    
    
  </section>

  <script src="./js/homePage.js"></script>
    <script>
        document.getElementById("profile-form").addEventListener("submit", function(event) {
            var confirmation = confirm("Are you sure you want to update details?");
            if (confirmation) {
                alert("Profile details have been updated");
            } else {
                event.preventDefault(); // Prevent form submission
            }
        });
    </script>

</body>

</html>