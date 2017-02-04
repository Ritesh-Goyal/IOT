<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
  <script src="js/mqttws31.js" type="text/javascript"></script>
  <script src="js/jquery-1.4.2.js" type="text/javascript"></script>
  <!--script src="gauge.min.js" type="text/javascript"></script-->
  <script src="js/client_park.js" type="text/javascript"></script>
 
  <style>
 h1 {
 color: #7c795d; 
 font-family: 'Trocchi', serif;
 font-size: 45px;
 font-weight: normal;
 line-height: 48px;
 
 
}
 input[type=button] {
    padding:5px 15px; 
    background:#ccc; 
    border:0 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
	
} 
input:hover { color: #FF0000 }
  </style>  
  </head>
  <body background="js/p1.jpg" onload="init()">
  <h1><center>Smart Car Parking System</center></h1>
  <table>
   <tr><td></td></tr>
   <tr><td><p><label id="status"></p></td></tr>
  <center> <canvas id="myCanvas" width="430" height="430" style="border:1px solid #d3d3d3;"></canvas></center>
  </table>
  
  <!-- <center><input type="button" onclick="init()" value="Connect"/></center> -->
   <center>
   <iframe id="ParkingSelection"
    name="ParkingSelection"
    title="ParkingSelection"
    width="400"
    height="350"
    frameborder="0"
    scrolling="no"
    marginheight="0"
    marginwidth="0"
    src="ParkingSelection.jsp">
<input type="hidden" id="name" value="${uname}" />
    
</iframe>
   </center>
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
 
 </body>
</html>