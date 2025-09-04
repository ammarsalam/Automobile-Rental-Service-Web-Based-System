<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><meta charset="ISO-8859-1">
		<title></title>
		<link rel="stylesheet" href="./content/css/rentOut.css" type="text/css"/>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
</head>
<body>
<div class="background" id="bookForm">
    <div class="booking-form">
        <h2>Update Admin Form</h2>
        <form action="UpdateAdminController" method="post">

			<label for="admin_id">Id:</label>
            <input type="text" name="admin_id" id="admin_id" value="<c:out value="${admin.admin_id}"/>" readonly required>
       
            <label for="admin_address">Address:</label>
            <input type="text" name="admin_address" id="admin_address" value="<c:out value="${admin.admin_address}"/>" >
           
            <label for="admin_pNum">Phone Number:</label>
            <input type="text" name="admin_pNum" id="admin_pNum" value="<c:out value="${admin.admin_pNum}"/>" >

            
            <label for="admin_title">Title:</label>
            <input type="text" name="admin_title" id="admin_title" value="<c:out value="${admin.admin_title}"/>" >

            <label for="admin_department">Department:</label>
            <input type="text" name="admin_department" id="admin_department"  value="<c:out value="${admin.admin_department}"/>" >
            
             <label for="admin_department">User Id:</label>
            <input type="text" name="user_id" id="user_id"  value="<c:out value="${admin.user_id}"/>" required readonly>
            

            <button type="submit">Update Admin Details</button>
        </form>
        <button onclick="location.href='ListAdminController'">Cancel</button>
    </div>
  </div>
</body>
</html>