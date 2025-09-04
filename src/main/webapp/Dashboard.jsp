<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!Doctype HTML>
<html>
	<head>
		<title>Automobile Rental Service</title>
		<link rel="stylesheet" href="./content/css/adminPage.css" type="text/css"/>
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
	            <span style="font-size:30px;cursor:pointer; color: white;" class="nav"  ><!-- ☰  &lt --> &#8803 Dashboard</span>
	            <span style="font-size:30px;cursor:pointer; color: white;" class="nav2"  > <!-- ☰ &gt --> &#8803 Dashboard</span>
	        </div>
		    <div class="clearfix"></div>
	    </div>

		<div class="clearfix"></div>
		<br/>
		
		<div class="col-div-3">
			<div class="box">
				<p><c:out value="${dashboard.noOfAdmins}"/><br/><span>Admin</span></p>
				<i class="fa fa-users box-icon"></i>
			</div>
		</div>
		<div class="col-div-3">
			<div class="box">
				<p><c:out value="${dashboard.noOfCars}"/><br/><span>Total Cars</span></p>
				<i class="fa fa-list box-icon"></i>
			</div>
		</div>
		<div class="col-div-3">
			<div class="box">
				<p><c:out value="${dashboard.noOfBookings}"/><br/><span>Total Booking</span></p>
				<i class="fa fa-shopping-bag box-icon"></i>
			</div>
		</div>
		<div class="col-div-3">
			<div class="box">
				<p><c:out value="${dashboard.noOfUsers}"/><br/><span>Total Users</span></p>
				<i class="fa fa-tasks box-icon"></i>
			</div>
		</div> 

		<div class="clearfix"></div>
		<br/><br/>

		<div class="col-div-8">
			<div class="box-8">
			    <div class="content-box">
				    <!--<p>Top Selling Projects <span>Sell All</span></p> -->
                    <p>Top 3 Owners with most car(s)</p>
				    <br/>
				    <table>
	                    <tr>
	                        <th>User ID</th>
	                        <th>User Name</th>
	                        <th>Total No Of Cars</th>
	                    </tr>
	                    <c:forEach var="dashboard" items="${dashboards}">
    					<tr>
        					<td><c:out value="${dashboard.rr_id}"/></td>
        					<td><c:out value="${dashboard.user_name}"/></td>
        					<td><c:out value="${dashboard.noTopCar}"/></td>
    					</tr>
						</c:forEach>
	                    
	                </table>
			    </div>
		    </div>
		</div>

		<div class="col-div-4">
			<div class="box-4">
			    <div class="content-box">
                    <p>Top 3 Car Models</p>
				    <br/>
				    <table>
	                    <tr>
	                        <th>Car Model</th>
	                        <th>Total Number</th>
	                    </tr>
	                    <c:forEach var="dashboard" items="${dashboardss}">
    					<tr>
        					<td><c:out value="${dashboard.car_model}"/></td>
        					<td><c:out value="${dashboard.noTopModel}"/></td>
    					</tr>
						</c:forEach>
	                    
	                </table>
			    </div>
		    </div>
		</div>
			
		<div class="clearfix"></div>
	</div>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>

	  $(".nav").click(function(){
	    $("#mySidenav").css('width','70px');
	    $("#main").css('margin-left','70px');
	    $(".logo").css('visibility', 'hidden');
	    $(".logo span").css('visibility', 'visible');
	     $(".logo span").css('margin-left', '-10px');
	     $(".icon-a").css('visibility', 'hidden');
	     $(".icons").css('visibility', 'visible');
	     $(".icons").css('margin-left', '-8px');
	      $(".nav").css('display','none');
	      $(".nav2").css('display','block');
	  });

	$(".nav2").click(function(){
	    $("#mySidenav").css('width','300px');
	    $("#main").css('margin-left','300px');
	    $(".logo").css('visibility', 'visible');
	     $(".icon-a").css('visibility', 'visible');
	     $(".icons").css('visibility', 'visible');
	     $(".nav").css('display','block');
	      $(".nav2").css('display','none');
	 });

	</script>

</body>

</html>