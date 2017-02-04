<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%
   String uname = request.getParameter( "uname" );//getAttribute( "uname" ).toString();
   session.setAttribute("uname",uname);
%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IOT Admin Panel</title>
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
#data{
 width:800px;
 margin:0 auto;
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
function callsubmit(){
	document.bookdata.submit();
}

</script>
</head>
<body background="js/p1.jpg">
<div>
<img src="images/log.png" onclick="calLogout()" alt="Logout" height="42" width="50" style="float: right;">
</div>
<div id="Message">
<h2>Welcome Admin<%-- <%= session.getAttribute( "uname" ) %> --%></h2> 
</div>
<jsp:include page="navigation.jsp" />

<div id="data">
<form id="IOTformdata" name="bookdata" action="GetUserInfo" method="post">

<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->
	<tr>
		<th>Sr.No</th>
		<th>User ID</th>
		<th>Mobile Number</th>
		<th>Email-ID</th>
		<th>Address</th>
	</tr><!-- Table Header -->
    
    <c:forEach items="${arr}" var="data">
<tr>
	<td><c:out value="${data.counter}" /></td>
	<td><c:out value="${data.userid}" /></td>
	<td><c:out value="${data.mobile}" /></td>
	<td><c:out value="${data.email}" /></td>
	<td><c:out value="${data.address}" /></td>
</tr><!-- Table Row -->
	</c:forEach>
</table>
<center><input type="button" value="GetData" onclick="document.bookdata.submit();"></center>
</form>
</div>
</body>
</html>