<%@ page session = "true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script> 
function validate()
{ 
	 var email = document.form.email.value;
	 var password = document.form.password.value;
 if (email==null || email=="")
{ 
alert("Email can't be blank"); 
return false; 
}
else if(password.length<6)
{ 
alert("Password must be at least 6 characters long."); 
return false; 
} 
} 
</script> 
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">			
				<div class="login100-form-title" style="background-image: url(images/bg-01.jpg);">
				<%
				 String errorMessage = (String) session.getAttribute("ErrorMessage");
				    if (session.getAttribute("ErrorMessage")!=null && (String) session.getAttribute("ErrorMessage")!="") {%>
				    <h5 style="color: red; text-align: center;"><% out.print(errorMessage); %></h5>				    	    
				    <%} %> 					
					<span class="login100-form-title-1">
						WINE STORE
					</span>
				</div>
				<form class="login100-form validate-form" action="${pageContext.request.contextPath}/LoginServlet" method="post" name='form' onsubmit="return validate()">
					<div class="wrap-input100 validate-input m-b-26" data-validate="Email is required">
						<span class="label-input100">Email:</span>
						<input class="input100" type="text" name="email" placeholder="Enter Email">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">Password:</span>
						<input class="input100" type="password" name="password" placeholder="Enter password">
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn">
						<input class="login100-form-btn" type="submit" value="Login"></input>
					</div> 
					
				</form>
			</div>
		</div>
	</div>
	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<script src="js/main.js"></script>

</body>
</html>