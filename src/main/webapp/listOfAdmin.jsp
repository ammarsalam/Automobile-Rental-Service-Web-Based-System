<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!Doctype HTML>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Automobile Rental Service</title>
		<link rel="stylesheet" href="./content/css/listOfAdmins.css" type="text/css"/>
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
	            <span style="font-size:30px;cursor:pointer; color: white;" class="nav"  > &#8803 Admins</span>
	            <span style="font-size:30px;cursor:pointer; color: white;" class="nav2"  >  &#8803 Admins</span>
	        </div>
		    <div class="clearfix"></div>
	    </div>

		<div class="clearfix"></div>
		
		<h2>Welcome to List Of Admins page. Below are the details about Admin's information.</h2>
		<button id="add-admin-btn" onclick="location.href='addAdminForm.html'">ADD NEW ADMIN</button>
<div class="admin-panel">
    <h2 id="Admin-details">List of Admins</h2>
    <div class="admin-table">
        <table>
            <tr>
                <th>NO</th>
                <th>ADMIN ID</th>
                <th>NAME</th>
                <th>TITLE </th>
                <th>DEPARTMENT</th>
                <th>PHONE NUMBER</th>
                <th>ADDRESS</th>
                <th>ACTIONS</th>
                
            </tr>
            <c:forEach items="${bridges}" var="bridge" varStatus="bridges">
			<tr>
				<td><c:out value="${bridges.index + 1}"/></td>
        		<td><c:out value="${bridge.admin_id}"/></td>  
            	<td><c:out value="${bridge.user_name}"/></td>    
            	<td><c:out value="${bridge.admin_title}"/></td>   
            	<td><c:out value="${bridge.admin_department}"/></td>
            	<td><c:out value="${bridge.admin_pNum}"/></td>   
            	<td><c:out value="${bridge.admin_address}"/></td>   
                <td><a class="edit-btn" href="ViewAdminController?admin_id=<c:out value="${bridge.admin_id}"/>">View</a>
                <button class="edit-btn" id="<c:out value="${bridge.admin_id}"/>" onclick="confirmation(this.id)">Delete</button>
                <a class="edit-btn" href="UpdateAdminController?admin_id=<c:out value="${bridge.admin_id}"/>">Update</a></td>
            </tr>
            <script>
	function confirmation(id){					  		 
		  console.log(id);
		  var r = confirm("Are you sure you want to delete?");
		  if (r == true) {				 		  
			  location.href = 'DeleteAdminController?admin_id=' + id;
			  alert("Admin successfully deleted");			
		  } else {				  
		      return false;	
		  }
	}
	</script>
            </c:forEach>
            <!-- More rows can be added as needed -->
        </table>
    </div>
</div>
		
		<div class="clearfix"></div>
		<br/><br/>
			
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