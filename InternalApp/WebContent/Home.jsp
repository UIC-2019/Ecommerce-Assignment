<%@page import="com.ims.utils.InventoryBean"%>
<%@page import="com.ims.controller.Controller"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session = "true" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Inventory Management System</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">
<link href="css/w3.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.container-div {
	width: 100%;
	margin-right: auto;
	margin-left: auto;
}

.img {
	object-fit: cover;
}
</style>
</head>
<%
    String email = (String) session.getAttribute("email");
    if (null == email) {
    session.setAttribute("ErrorMessage", "You are not logged in. Please login to access.");
    response.sendRedirect("login.jsp");
    }
 %>
<body class=id="page-top" style="background-image: url('images/bg-01.jpg')">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<a class="navbar-brand mr-1" href="showinventory.jsp">WINE STORE</a>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Home.jsp" class="nav-link">Home</a></li>
				<li><a href="showinventory.jsp" class="nav-link">Inventory</a></li>
				<li><a href="showemployees.jsp" class="nav-link">Employees</a></li>
				<li><a href="showvendors.jsp" class="nav-link">Vendors</a></li>
				<li><a href="update.jsp" class="nav-link">Update</a></li>
				<li><a href="email.jsp" class="nav-link">Email</a></li>
				<li><a href="${pageContext.request.contextPath}/logout" class="nav-link">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="panel panel-default custom_class"> <!-- Note the new class -->
    <div class="panel-heading"><h2 style="color: white">Welcome!</h2>
</div>
	<!-- /#wrapper -->
	<footer class="sticky-footer" style="width: 100%">
		<div class="container-div my-auto">
			<table style="width: 100%; align-items: stretch;">
				<tr>
					<th
						style="align-self: inherit; align-content: flex-start; text-align: center; width: 25%"><i
						class="fa fa-linkedin" style="font-size: 24px; color: #0e76a8"></i></th>
					<th
						style="align-self: inherit; align-content: flex-start; text-align: center; width: 25%"><i
						class="fa fa-linkedin" style="font-size: 24px; color: #0e76a8"></i></th>
					<th 
						style="align-self: inherit; align-content: flex-start; text-align: center; width: 25%"><i
						class="fa fa-linkedin" style="font-size: 24px; color: #0e76a8"></i></th>
					<th
						style="align-self: inherit; align-content: flex-start; text-align: center; width: 25%"><i
						class="fa fa-linkedin" style="font-size: 24px; color: #0e76a8"></i></th>
				</tr>
				<tr>
					<td
						style="align-self: inherit; align-content: flex-start; text-align: center; width: 25%">
						 <a href="https://www.linkedin.com/in/vartika-singh-583b1150/"><!--LinkedIN link access -->Vartika</td></a>
					<td
						style="align-self: inherit; align-content: flex-start; text-align: center; width: 25%">
						<a href="https://www.linkedin.com/in/nisha-aher/"><!--LinkedIN link access -->Nisha</td></a>
					<td
						style="align-self: inherit; align-content: flex-start; text-align: center; width: 25%">
						<a href="http://www.linkedin.com/in/harshithas"><!--LinkedIN link access -->Harshitha</td>
					<td
						style="align-self: inherit; align-content: flex-start; text-align: center; width: 25%">
						<a href="https://www.linkedin.com/in/sooraj-holla-65a313179/"><!--LinkedIN link access -->Sooraj</td>
				</tr>
			</table>

			<div class="copyright text-center my-auto">
				<span>Copyright � Your Website 2019</span>
			</div>
		</div>
	</footer>

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="vendor/datatables/jquery.dataTables.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script src="js/demo/datatables-demo.js"></script>

</body>

</html>
