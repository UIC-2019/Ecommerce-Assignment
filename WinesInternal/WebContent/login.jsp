<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Wines N Things</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
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

<body class="bg-dark">

  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Wines & Things Login</div>
      <%
				 String errorMessage = (String) session.getAttribute("ErrorMessage");
				    if (session.getAttribute("ErrorMessage")!=null && (String) session.getAttribute("ErrorMessage")!="") {%>
				    <h5 style="color: red; text-align: center;"><% out.print(errorMessage); %></h5>				    	    
				    <%} %> 
      <div class="card-body">
        <form action="${pageContext.request.contextPath}/LoginController" method="post" name='form' onsubmit="return validate()">
          <div class="form-group">
            <div class="form-label-group">
              <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Email address" required="required" autofocus="autofocus">
              <label for="inputEmail">Email address</label>
            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="password" id="inputPassword" class="form-control" name ="password" placeholder="Password" required="required">
              <label for="inputPassword">Password</label>
            </div>
          </div>
          <input class="login100-form-btn" type="submit" value="Login"></input>
        </form>
        <div class="text-center">
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>
