
<%@page import="com.internal.wines.bean.Employee"%>
<%@page import="com.internal.wines.controller.WinesController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<script type="text/javascript">
$(document).ready(function() {
    $('#dataTable').DataTable();
} );
</script>
  <title>Wines & Things - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">

</head>
<%
    String email = (String) session.getAttribute("email");
    if (null == email) {
    session.setAttribute("ErrorMessage", "You are not logged in. Please login to access.");
    response.sendRedirect("login.jsp");
    }
 %>
<body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index.jsp">Wines & Things - Dashboard</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
      <i class="fas fa-bars"></i>
    </button>


    <!-- Navbar -->
    <ul class="navbar-nav ml-auto ml-md-0">
      <li class="nav-item dropdown no-arrow mx-1">
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item dropdown no-arrow mx-1">
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item dropdown no-arrow">
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          <a class="dropdown-item" href="#">Settings</a>
          <a class="dropdown-item" href="#">Activity Log</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
        </div>
      </li>
      <li><a href="${pageContext.request.contextPath}/logout" class="nav-link">Logout</a></li>
    </ul>

  </nav>
  <div id="wrapper">

   <ul class="sidebar navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="index.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Home</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="order.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Orders</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="inventory.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Inventory</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="vendor.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Vendors</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="employee.jsp">
          <i class="fas fa-fw fa-table"></i>
          <span>Employees</span></a>
      </li>
    </ul>

    <div id="content-wrapper">

      <div class="container-fluid">

        <!-- Breadcrumbs-->
        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="#">Dashboard</a>
          </li>
          <li class="breadcrumb-item active">Table</li>
        </ol>

        <!-- DataTables Example -->
        <div class="card mb-3">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Employee Information</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>EmployeeID</th>
                    <th>Name</th>
                    <th>Role</th>
                    <th>Department</th>
                  </tr>
                </thead>
               <tbody>
               <%
               WinesController con = new WinesController();
               ArrayList<Employee> empList = con.fetchEmployees();
		  request.setAttribute("empList",empList);
               %>
               <c:forEach var="listItems" items="${empList}">        
       		 <tr><td><c:out value="${listItems.employeeID}" /></td>
            <td><c:out value="${listItems.name}" /></td>
            <td><c:out value="${listItems.role}" /></td>
            <td><c:out value="${listItems.department}" /></td>
             </tr> 
    		</c:forEach> 
              </table>
            </div>
          </div>
        </div>

      </div>
      <!-- /.container-fluid -->

      <!-- Sticky Footer -->
      <footer class="sticky-footer">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright © Your Website 2019</span>
          </div>
        </div>
      </footer>

    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- /#wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
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
