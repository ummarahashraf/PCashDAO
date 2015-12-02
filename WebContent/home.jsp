<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  
<title>welcome</title>
  <!-- Bootstrap Core CSS -->
    <link href="../landingPage/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../landingPage/css/landing-page.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../landingPage/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

</head>
<body style="background-image:url(landingPage/img/banner-bg.jpg)">

<h3>Welcome user</h3>
<%
System.out.println("JSP HERE");


%>

  
<!---->

	

<div class="container">
	<div class="well">
		<table class="table table-striped">
				<thead>
					<tr>
						<th>Sr No.</th>
						<th>Description</th>
					
						<th>Amount</th>
						
						<th>Type</th>
					
						<th>Date</th>
					</tr>
				</thead>
					<tbody>
						
				 <c:forEach items="${showAll}" var="tm">
                <tr>
                    <td><c:out value="${tm.transID}" /></td>
                    <td><c:out value="${tm.descr}" /></td>
                    <td><c:out value="${tm.type}" /></td>
                    <td><c:out value="${tm.amount}" /></td>
                    <td><c:out value="${tm.date}" /></td>
                    </tr>
            </c:forEach>
							 
							 
					</tbody>
		</table>
		 <!-- 3 -->

		</div>
	</div>
	<!-- 4 -->
<!--  -->



 <!--** Navigation ** -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a  href="#home"><h3>Home</h3></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="query.html">Insert Query</a>
                    </li>
                    <li>
                        <a href="logout.jsp">Logout</a>
                    </li>
                    <li>
                        <a href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

 <!-- ****** -->


    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="list-inline">
                        <li>
                            <a href="#welcome.jsp">Home</a>
                        </li>
                        
                        <li class="footer-menu-divider">&sdot;</li>
                        <li>
                            <a href="index.html">logout</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li>
                            <a href="#contact">Contact</a>
                        </li>
                    </ul>
                    <p class="copyright text-muted small">Copyright &copy;</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="../landingPage/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../landingPage/js/bootstrap.min.js"></script>


</body>
</html>