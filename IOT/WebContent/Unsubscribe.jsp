<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%
   String uname = request.getParameter( "uname" );
   session.setAttribute("uname",uname);
%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UnSubscribe</title>
<link rel="stylesheet" type="text/css" href="css/ParkingSelection.css">
<script src="js/mqttws31.js" type="text/javascript"></script>
<script src="js/jquery-1.4.2.js" type="text/javascript"></script>
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
#main{
margin-left:20%;
} 
input:hover { color: #FF0000 }
img:hover { cursor: pointer;}

</style>  
  <script>
  function calLogout(){
		var input = confirm("Do you want to Logout ?");
		if(input == true){
			window.location="login.jsp";	
		}
		
	}
  </script>
</head>
<body background="js/p1.jpg" onload="init()">
<img src="images/log.png" onclick="calLogout()" alt="Logout" height="42" width="50" style="float: right;">
<div id="Message">
<%-- <h2>Welcome <%= session.getAttribute( "uname" ) %></h2> 
<h2>Welcome ${uname}</h2>  --%>
<h2>Welcome Admin<%-- <%= session.getAttribute( "uname" ) %> --%></h2>
</div> 
<jsp:include page="navigation.jsp" />
<br>
<div id="main">
<%-- <jsp:include page="Parkdisplay.jsp" /> --%>

  <center> <canvas id="myCanvas" width="430" height="430" style="border:1px solid #d3d3d3;"></canvas></center>
    
  <!-- <center><input type="button" onclick="init()" value="Connect"/></center> -->
  <script>
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="black";
ctx.fillRect(190, 0, 50, 380);

var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="black";
ctx.fillRect(40, 0, 350, 20);

var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="black";
ctx.fillRect(40, 120, 350, 20);

var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="black";
ctx.fillRect(40, 240, 350, 20);

var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.fillStyle="black";
ctx.fillRect(40, 360, 350, 20);

//document.getElementById("name").value = '${uname}';
   </script>
</div>

<div style="margin: auto;width: 25%;margin-top:5%;">
<form action="MQTT" method="post">
  
<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->
	<tr><th>UnPublish Parking Slot</th></tr>
	<!-- <th>Parking Slot</th></tr> -->
	<!-- Table Header -->
    
<tr>
	<td><input type="checkbox" name="unpublish" value="parkslot1" style="width: 8%;"> parkslot1</td>
</tr><!-- Table Row -->

<tr class='even'>
	<td><input type="checkbox" name="unpublish" value="parkslot2" style="width: 8%;"> parkslot2</td>
</tr><!-- Darker Table Row -->

<tr>
	<td><input type="checkbox" name="unpublish" value="parkslot3" style="width: 8%;"> parkslot3</td>
</tr><!-- Table Row -->

<tr class='even'>
	<td><input type="checkbox" name="unpublish" value="parkslot4" style="width: 8%;"> parkslot4</td>
</tr><!-- Darker Table Row -->

<tr>
	<td><input type="checkbox" name="unpublish" value="parkslot5" style="width: 8%;"> parkslot5</td>
</tr><!-- Table Row -->

<tr class='even'>
	<td><input type="checkbox" name="unpublish" value="parkslot6" style="width: 8%;"> parkslot6</td>
</tr><!-- Darker Table Row -->

</table>
 
  <button type="submit" value="Submit">Submit</button>
  <button type="reset" value="Reset">Reset</button>
<input type="hidden" id="clientname" name="user" value="prerna07dhar@gmail.com">
<input type="hidden" id="clientname" name="Admin" value="prerna07dhar@gmail.com">

</form>
</div>


</body>
<script src="js/client_park.js" type="text/javascript"></script>
</html>