<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login form using HTML5 and CSS3</title>
    
    
    
    
        <link rel="stylesheet" href="css/style.css">

    <Script>
    function validate()
    {
    	var userid = document.getElementById("username").value;
    	var pass = document.getElementById("password").value;
    	var pass1 = document.getElementById("password1").value;
    	var useridformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    	if(pass === pass1){
    		if(userid.match(useridformat)){
    	 		document.getElementById("registerpark").submit();
    		}
    		else{
    			alert("User-Id should be Email-Id like abc@xyz.com format");  
    			document.loginform.loginName.value ="";
    			document.loginform.password.value ="";
    			document.loginform.password1.value ="";
    			document.loginform.loginName.focus();  
    		}
    	}
    	else {
           alert("Enter right password");   		
    	}
 } 	
    </Script>
    
    
  </head>

  <body>

    <body>
<div class="container">
	<section id="content">
		<form id ="registerpark" action= "Register" method="post">

			<h1>Registration Form</h1>
			<div>
				<input type="text" placeholder="Username" name="loginName" required="" id="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" name="password" required="" id="password" />
			</div>
			<div>
				<input type="password" placeholder="Confirm Password" required="" id="password1" />
			</div>
			<div>
				<input type="tel" placeholder="Enter Mobile Number" name="mobile" required="" id="mobilenum" />
			</div>
			<div>
				<input type="text" placeholder="Enter Address" name="address" required="" id="addr" />
			</div>
			<div>
				<input type="button" onclick="validate();" value="Register" />
			</div>
		</form><!-- form -->
		
	</section><!-- content -->
</div><!-- container -->
</body>
    
        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
