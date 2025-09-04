<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
	<head>
		<title>Automobile Rental Service</title>
		<link rel="stylesheet" href="./content/css/listOfBooking.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
<body>
		
	<div id="mySidenav" class="sidenav">
		<p class="logo"><span>My</span>Cars</p>
	    <a href="DashboardController" class="icon-a"><i class="fa fa-dashboard icons"></i>   Dashboard</a>
	    <a href="ListAdminController"class="icon-a"><i class="fa fa-users icons"></i>   Add Admin</a>
	    <a href="listCarController"class="icon-a"><i class="fa fa-list icons"></i>   List Of Cars</a>
	    <a href="listBookingController"class="icon-a"><i class="fa fa-shopping-bag icons"></i>   List Of Bookings</a>
	    <a href="loginAdmin.html"class="icon-a"><i class="fa fa-user icons"></i>   LogOut</a>
    </div>

	<div id="main">

		<div class="head">
			<div class="col-div-6">
	            <span style="font-size:30px;cursor:pointer; color: white;" class="nav"  > &#8803 Bookings</span>
	            <span style="font-size:30px;cursor:pointer; color: white;" class="nav2"  >  &#8803 Bookings</span>
	        </div>
		    <div class="clearfix"></div>
	    </div>

		<div class="clearfix"></div>
		
		<h2>Welcome to List Of Bookings page. Below are the details about renter's booking.</h2>
		
        <div class="admin-panel">
            <h2 id="booking-details">List of Bookings</h2>
            <div class="car-form">
                <table>
                    <tr>
                        <th>No</th>
                        <th>Booking Id</th>
                        <th>Booking Date</th>
                        <th>End Date</th>
                        <th>Pickup Location</th>
                        <th>Drop Location</th>
                        <th>User ID</th>
                        <th>Car ID</th>
                        <th>Actions</th>
                    </tr>
                  <c:forEach items="${bookings}" var="booking" varStatus="bookings">
			<tr>
				<td><c:out value="${bookings.index + 1}"/></td>
        		<td><c:out value="${booking.booking_id}"/></td>
            	<td><c:out value="${booking.booking_date}"/></td>
            	<td><c:out value="${booking.end_date}"/></td>
            	<td><c:out value="${booking.pickup_location}"/></td>    
            	<td><c:out value="${booking.drop_location}"/></td>   
            	<td><c:out value="${booking.rr_id}"/></td>
            	<td><c:out value="${booking.car_id}"/></td>    
                <td><a class="edit-btn" href="viewBookingController?booking_id=<c:out value="${booking.booking_id}"/>">View</a>
                <button class="edit-btn" id="<c:out value="${booking.booking_id}"/>" onclick="confirmation(this.id)">Delete</button>
                <a class="edit-btn" href="updateBookingController?booking_id=<c:out value="${booking.booking_id}"/>">Edit</a></td>
            </tr>
            <script>
            	function confirmation(id){					  		 
      		  		console.log(id);
      		  		var r = confirm("Are you sure you want to delete?");
      		  		if (r == true) {				 		  
      			  		location.href = 'deleteBookingController?booking_id=' + id;
      			  		alert("Booking successfully deleted");			
      		  		} else {				  
      		      		return false;	
      		  		}
      			}
      		</script>
            </c:forEach>
                </table>
            </div>
        </div>

		<div class="clearfix"></div>
		<br/><br/>

		<div class="clearfix"></div>
	</div>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>

	  
		$(".nav").click(function() {
			$("#mySidenav").css('width', '70px');
			$("#main").css('margin-left', '70px');
			$(".logo").css('visibility', 'hidden');
			$(".logo span").css('visibility', 'visible');
			$(".logo span").css('margin-left', '-10px');
			$(".icon-a").css('visibility', 'hidden');
			$(".icons").css('visibility', 'visible');
			$(".icons").css('margin-left', '-8px');
			$(".nav").css('display', 'none');
			$(".nav2").css('display', 'block');
		});

		$(".nav2").click(function() {
			$("#mySidenav").css('width', '300px');
			$("#main").css('margin-left', '300px');
			$(".logo").css('visibility', 'visible');
			$(".icon-a").css('visibility', 'visible');
			$(".icons").css('visibility', 'visible');
			$(".nav").css('display', 'block');
			$(".nav2").css('display', 'none');
		});
	</script>

</body>
</html>