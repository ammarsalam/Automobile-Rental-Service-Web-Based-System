<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" href="./content/css/bookingPay.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
<body>


  <section class="car-form-panel">
    <div class="form-instructions">
      <h2 id="enter-details">Admin Details</h2> 
      
      <h2 id="user-id">ADMIN ID : <c:out value="${bridge.admin_id}"/></h2>
      
      
    </div>
    <div class="car-form">
      <table>
        <tr>
          <td><strong>Name:</strong></td>
          <td><c:out value="${bridge.user_name}"/></td>
        </tr>
        <tr>
          <td><strong>Address:</strong></td>
          <td><c:out value="${bridge.admin_address}"/></td>
        </tr>
        <tr>
          <td><strong>Phone Number:</strong></td>
          <td><c:out value="${bridge.admin_pNum}"/></td>
        </tr>
        <tr>
          <td><strong>Email:</strong></td>
          <td><c:out value="${bridge.user_email}"/></td>
        </tr>
        <tr>
          <td><strong>Title:</strong></td>
          <td><c:out value="${bridge.admin_title}"/></td>
        </tr>
        <tr>
          <td><strong>Department:</strong></td>
          <td><c:out value="${bridge.admin_department}"/></td>
        </tr>
        
      </table>
      <button onclick="location.href='ListAdminController'">Cancel</button>

    </div>


  <!-- Form for Car Details -->

  <script src="./js/homePage.js"></script>

</body>
</html>
<!-- Author: FES -->