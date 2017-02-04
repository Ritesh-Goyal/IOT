<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IOT User Booking Status</title>
<script src="js/jquery-1.4.2.js" type="text/javascript"> </script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
 h1 {
 color: #7c795d; 
 font-family: 'Trocchi', serif;
 font-size: 45px;
 font-weight: normal;
 line-height: 48px; 
}
h2 {
 color: #7c795d; 
 font-family: 'Trocchi', serif;
 /* font-size: 45px; */
 font-weight: normal;
 /* line-height: 48px; */
 float:right;
}
 input[type=button] {
    padding:5px 15px; 
    background:#ccc; 
    border:0 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
    width : 25%;
	
}
input{
padding: 10px;
width: 5%;
}
#frame {
 margin-left: auto;
 margin-right: auto;
 text-align: center;
}
#Message {
 text-align: right;
}

input:hover { color: #FF0000 }
img:hover { cursor: pointer;}

</style>

<script>
$(window).resize(function() {
	var path = $(this);
	var contW = path.width();
	if(contW >= 751){
		document.getElementsByClassName("sidebar-toggle")[0].style.left="200px";
	}else{
		document.getElementsByClassName("sidebar-toggle")[0].style.left="-200px";
	}
});
$(document).ready(function() {
	$('.dropdown').on('show.bs.dropdown', function(e){
	    $(this).find('.dropdown-menu').first().stop(true, true).slideDown(300);
	});
	$('.dropdown').on('hide.bs.dropdown', function(e){
		$(this).find('.dropdown-menu').first().stop(true, true).slideUp(300);
	});
	$("#menu-toggle").click(function(e) {
		e.preventDefault();
		var elem = document.getElementById("sidebar-wrapper");
		left = window.getComputedStyle(elem,null).getPropertyValue("left");
		if(left == "200px"){
			document.getElementsByClassName("sidebar-toggle")[0].style.left="-200px";
		}
		else if(left == "-200px"){
			document.getElementsByClassName("sidebar-toggle")[0].style.left="200px";
		}
	});
});


function calLogout(){
	var input = confirm("Do you want to Logout ?");
	if(input == true){
		window.location="login.jsp";	
	}
	
}

</script>
</head>
<body background="js/p1.jpg">

<img src="images/log.png" onclick="calLogout()" alt="Logout" height="42" width="50" style="float: right;" />
<div id="Message">
<h2>Welcome Admin<%-- <%= session.getAttribute( "uname" ) %> --%></h2>
<%-- <h2>Welcome ${uname}</h2> --%> 
</div>
<jsp:include page="navigation.jsp" />
<div id="data">
<form id="IOTformdata" name="bookdata" action="BookingData" method="post">

<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->
	<tr><th>Sr.No</th><th>User ID</th><th>Vehicle Number</th><th>Parking Slot</th><th>StartTime</th><th>End Time</th><th>Hours</th><th>Total Amount</th></tr><!-- Table Header -->
    <c:forEach items="${arr}" var="data">
<tr>
	<td><c:out value="${data.counter}" /></td>
	<td><c:out value="${data.userid}" /></td>
	<td><c:out value="${data.vehiclenumber}" /></td>
	<td><c:out value="${data.parkslot}" /></td>
	<td><c:out value="${data.starttime}" /></td>
	<td><c:out value="${data.endtime}" /></td>
	<td><c:out value="${data.hours}" /></td>
	<td><c:out value="${data.payment}" /></td>
</tr><!-- Table Row -->
	</c:forEach>
</table>
<br>
<center><input type="button" value="GetData" onclick="document.bookdata.submit();"></center>
</form>
</div>
</body>

</html>