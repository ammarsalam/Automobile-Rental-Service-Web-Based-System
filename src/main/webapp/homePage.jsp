<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Automobile Rental Service</title>
  <link rel="stylesheet" href="./content/css/homePage.css">
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
        <li class="link"><a href="#home">home</a></li>
        <li class="link"><a href="#about">about us</a></li>
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
      <h1>The <strong>best</strong> way to <strong>plan your next</strong> journey </h1>
      <h4>Explore the various of cars that you need to rent</h4>
      <h4>Welcome, <c:out value="${sessionScope.user_name}"/></h4>
      <button class="btn-explore" onclick="location.href='DisplayCarController'">Book your car now <i class="ri-arrow-right-line"></i> 
      </button>
      <button class="btn-explore" onclick="location.href='rentOutCarController'">Rent out your car <i class="ri-arrow-right-line"></i> 
      </button>
    </div>
  </header>

  <section class="about" id="about">
    <div class="content">
      <div class="items">

        <div class="image">
          <img src="content/carBackground.png" alt="" srcset="">
        </div>
        <div class="item">
          <div class="item-content">
            <h2 class="about-title">
              About Us
            </h2>
            <div class="about-desc">
              <p>
                We are the platform that gives users the opportunity to provide car rental services and can rent cars.
              </p>
              <p>
                If you have any problem, you can contact us!!!
              </p>
            </div>
          </div>

          <div class="item-data">
            <div class="col">
              <h1>2</h1>
              <span>Years Experience</span>
            </div>
            <div class="col">
              <h1>10+</h1>
              <span>Renter</span>
            </div>
            <div class="col">
              <h1>20+</h1>
              <span>Renting</span>
            </div>
          </div>

          <div class="item-contact">
            <h4>Contact Info</h4>
            <ul class="contact_info">
              <li>
                <p>
                  Experience the magic of a rejuvenated ride as we serve you with the best experience
                </p>
              </li> <br>
              <li>
                <p>Phone: <span>+0196127321</span></p>
              </li>
              <li>
                <p>Email: <span>mycarsofficial@gmail.com</span></p>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </section>

  <footer class="footer">

    <div class="content">
      <h4>MyCars</h4>
      <div class="social">
        <span>
          <a href="#f"><i class="ri-facebook-fill"></i></a>
        </span>
        <span>
          <a href="#f"><i class="ri-instagram-fill"></i></a>
        </span>
        <span>
          <a href="#f"><i class="ri-twitter-fill"></i></a>
        </span>
        <span>
          <a href="#f"><i class="ri-linkedin-fill"></i></a>
        </span>
        <span>
          <a href="#f"><i class="ri-youtube-fill"></i></a>
        </span>
      </div>
      <p>
        <i class="ri-double-quotes-l"></i>
        The automobile rental service system is designed to cater to two different types of users: administrators and regular users, 
        comprising both renters and rentees. With a well-designed interface, individuals can effortlessly engage with the platform to 
        either list their vehicles for rent or find suitable cars for their own needs. The system aims to provide a convenient and 
        efficient solution for both parties involved in the automobile rental process.
        <i class="ri-double-quotes-r"></i>

      </p>
      <p>Renters can conveniently upload details of their vehicles, including specifications and availability, facilitating flawless 
        transactions for potential customers. On the other hand, rentees can easily browse through the available options. 
      </p>
      <ul class="navigation">
        <li class="link"><a href="#home">home</a></li>
        <li class="link"><a href="#about">about us</a></li>
      </ul>
    </div>
    <div class="rights">
      Copyrights &#169 <a href="http://" target="_blank" rel="noopener noreferrer">MyCars</a>. all rights reserved
    </div>
  </footer>
  <script src="./js/homePage.js"></script>

</body>

</html>