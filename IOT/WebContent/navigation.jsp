<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
/*  side bar CSS */
#sidebar-wrapper {
  top: 52px;
  left: -200px;
  width: 200px;
  background-color:#9ECEDB; /* #5677fc; */
  color: white;
  position: fixed;
  height: 100%;
  z-index: 1;
}
.sidebar-nav {
  position: absolute;
  top: 0;
  margin: 0;
  padding: 0;
  width: 200px;
  list-style: none;
}
.sidebar-nav li {
  text-indent: 20px;
  line-height: 50px;
}
.sidebar-nav li a {
  color: white;
  display: block;
  text-decoration: none;
}
.sidebar-nav li a:hover {
  background: rgba(255,255,255,0.25);
  color: #7c795d;
  text-decoration: none;
}
.sidebar-nav li a:active, .sidebar-nav li a:focus {
  text-decoration: none;
}
#sidebar-wrapper.sidebar-toggle {
  transition: all 0.3s ease-out;
  margin-left: -200px;
}
@media (min-width: 768px) {
  #sidebar-wrapper.sidebar-toggle {
    transition: 0s;
    left: 200px;
  }
}


</style>

<script>
/* $(window).resize(function() {
	var path = $(this);
	var contW = path.width();
	if(contW >= 751){
		document.getElementsByClassName("sidebar-toggle")[0].style.left="200px";
	}else{
		document.getElementsByClassName("sidebar-toggle")[0].style.left="-200px";
	}
}); */
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
</script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="container">

		<div id="sidebar-wrapper" class="sidebar-toggle">
			<ul class="sidebar-nav">
		    
		        <li>
		      		<a href="listusers.jsp">Enrolled Users</a>
		    	</li>
		       	<li>
		      		<a href="bookingstatus.jsp">Park Booking Status</a>		      		
		    	</li>
		    	<li>
		      		<a href="publish.jsp">Book Parking</a>		      		
		    	</li>
		    	<li>
		      		<a href="Unsubscribe.jsp">UnPark Vehicle</a>
		    	</li>
		  	</ul>
		</div>
  	</div>
</nav>
</body>
</html>