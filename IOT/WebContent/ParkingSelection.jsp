<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
   String uname = request.getAttribute( "uname" ).toString();
   session.setAttribute("uname",uname);
%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
  <script src="js/mqttws31.js" type="text/javascript"></script>
  <script src="js/jquery-1.4.2.js" type="text/javascript"></script>
  <!--script src="gauge.min.js" type="text/javascript"></script-->
  
  <script src="js/datetimepicker_css.js"></script>
  <link rel="stylesheet" type="text/css" href="css/ParkingSelection.css">
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
 float:left;
}
 input[type=button] {
    padding:5px 15px; 
    background:#ccc; 
    border:0 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
	
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

#parkingrate{
position: absolute;
margin-left: 75%;
margin-top: -34%;
}

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
<body background="js/p1.jpg">
<img src="images/log.png" onclick="calLogout()" alt="Logout" height="42" width="50" style="float: right;">
<div id="Message">
<h2>Welcome <%= session.getAttribute( "uname" ) %></h2> 
</div>
<br>
<div id="main">
<%-- <div id="frame">
   <iframe id="ParkingDisplay"
    name="ParkingDisplay"
    title="ParkingDisplay"
    width="100%"
    height="540px"
    frameborder="0"
    scrolling="no"
    marginheight="0"
    marginwidth="0"
    src="Parkdisplay.jsp">
<input type="hidden" id="name" value="${uname}" />
    
</iframe> --%>

<jsp:include page="Parkdisplay.jsp" />

</div>

<div id="parkingrate">
<img src="images/parkingrate.png" alt="RateCard">
</div>
</div>
<center>
<h3>${status}</h3>
</center>
 <form id="IOTform" action="MQTT" method="post">

<div>
    <label for='formnum'>Enter the Parking Number :<span class='required'>(required)</span></label>
    <!-- <input type='text' name="formnum" placeholder='' required id="val1"/> -->
    <input list="parking" name="formnum">
 	 <datalist id="parking">
    	<option value="parkslot1">
    	<option value="parkslot2">
    	<option value="parkslot3">
    	<option value="parkslot4">
    	<option value="parkslot5">
    	<option value="parkslot6">
  	</datalist> 
</div>

 <div>
    <label for='date'>Date:</label>
    <input type="datetime-local" name="date"  />
</div>
 
<div>
    <label for='time'>How Many hours?<span class='required'>(required)</span></label>
    <input type="number" name="time" placeholder="Number of hours 1,2,3 " required />
</div>
<div>
    <label for='Vehicle number'>Enter Vehicle number<span class='required'>(required)</span></label>
    <input type="text" name="vnumber" placeholder="MH-12 AD 1234" required />
</div>
<div>
    <button type='submit'>Submit</button>
</div>
<input type="hidden" id="clientname" name="user" value="${uname}">
<input type="hidden" id="Admin" name="Admin" value="Publish">
<br>
 <!--  <div>
  
  Enter the Parking Number : <input type="text" name="formnum" id="val1" value="">
  Date:  <input type="datetime-local" name="date">
  Time: <input type="time" name="time">
  <input type="submit" value="Submit">
  
  </div> -->
  </form> 
  
</body>
<!-- <script src="js/client_park.js" type="text/javascript"></script> -->
</html>