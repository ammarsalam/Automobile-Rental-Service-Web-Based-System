<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Automobile Rental Service</title>
<link rel="stylesheet" href="./content/css/chooseCar.css">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@3.5.0/fonts/remixicon.min.css"
	rel="stylesheet">
<script src="https://unpkg.com/scrollreveal@4.0.9/dist/scrollreveal.js"></script>
</head>
<body>
	<input type="checkbox" id="bars">
	<nav class="nav-bar" id="navbar">
		<div class="content">
			<div class="logo nav__logo">
				<a href="#"><img src="content/carBackground.png" alt="logo" />
					<h1>MyCars</h1> </a>
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
			<label for='bars' class="icon-bars"><i
				class="ri-bar-chart-2-fill"></i></label>
		</div>
	</nav>

	<header class="home" id="home">
		<div class="content">
			<h1>
				LIST<strong> OF</strong> YOUR <strong>PAYMENT'S HISTORY</strong>
			</h1>
			<!--  <h4>Below is the car list</h4>-->
		</div>
	</header>
	<div class="admin-panel">
	<h2>
    	<a href="viewProfileController" style="color: white; text-decoration: underline;">USER ID : ${user_id}</a>
	</h2>

		<h2 id="booking-details">Payment History</h2>
		<div class="car-form">
			<table>
				<tr>
					<th>No</th>
					<th>Payment ID</th>
					<th>Booking ID</th>
					<th>Payment Type</th>
					<th>Total Price</th>
					<th>No. of Days</th>
					<th>Car Brand</th>
					<th>Car Model</th>
					<th>Actions</th>
				</tr>
				
				<c:forEach items="${bridges}" var="bridge" varStatus="bridges">
   				<tr>
        			<td> <c:out value="${bridges.index + 1}"/> </td>
        			
        			<td> <c:out value="${bridge.payment_id}"/> </td>
        			<td>
    					<a href="ListOfBookingRRController?bookingId=${bridge.booking_id}" style="color: white; text-decoration: underline;">
        					<c:out value="${bridge.booking_id}"/>
    					</a>
					</td>
        			<td> <c:out value="${bridge.payment_type}"/> </td>
        			<td> <c:out value="${bridge.totalPrice}"/> </td>
        			<td> <c:out value="${bridge.booking_days}"/> </td>
        			<td> <c:out value="${bridge.car_brand}"/> </td>
        			<td> <c:out value="${bridge.car_model}"/> </td>
            		<td>
                		<a class="choose" href="ViewPaymentController?payment_id=<c:out value="${bridge.payment_id}"/>">View</a>
                		
                	</td>
                </tr>
                 <script>
					function confirmation(id){					  		 
		  				console.log(id);
		 				var r = confirm("Are you sure you want to delete?");
		  				if (r == true) {				 		  
			  				location.href = 'deleteCarRRController?car_id=' + id;
			  				alert("Payment successfully deleted");			
		  				} else {				  
		      				return false;	
		  				}
					}
				</script>
          
				</c:forEach>
			</table>
		</div>
	</div>

	<script src="./js/homePage.js"></script>

</body>
</html>