<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>IOT Parking System Login Form</title>
    
    
    
    
        <link rel="stylesheet" href="css/style.css">

    <Script>
    function validate()
    {
    	var userid = document.getElementById("username").value;
    	var pass = document.getElementById("password").value;
    	var useridformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
    	if(userid != "" && pass != ""){
    		if(userid.match(useridformat)){
    	 		document.getElementById("testpark").submit();
    		}
    		else{
    			alert("User-Id should be Email-Id like abc@xyz.com format");  
    			document.loginform.loginName.value ="";
    			document.loginform.password.value ="";
    			document.loginform.loginName.focus();  
    		}
    	}
    	else{
    		alert("Userid and password should not be blank");
    	}
    	/* if(userid =="Prarna" && pass =="Dhar")
    	{
    		document.getElementById("testpark").submit();
    	}
    	else
    		alert("Wrong Username and Password"); */
    }
    </Script>
    
    
  </head>

  <body>

    <body>
<div class="container">
	<section id="content">
		<form name="loginform" id ="testpark" action="login" method="post">

			<h1>Login Form</h1>
			<div>
				<input type="text" placeholder="Username" name="loginName" required="" id="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" name="password" required="" id="password" />
			</div>
			<div>
				<input type="button" onclick="validate();" value="Log in" />
				<!-- <a href="#">Lost your password?</a>-->
				<input type="button" onclick="window.location.href='register.jsp'" value="Register" style="float: right;"/>
				<!--<a href="register.jsp">Register</a> -->
			</div>
		</form><!-- form -->
		<h4>${message}</h4>
	</section><!-- content -->
</div><!-- container -->
</body>
    

</html>
