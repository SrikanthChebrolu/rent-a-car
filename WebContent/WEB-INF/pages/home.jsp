<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RentalCar service</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="/rent-a-car/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/rent-a-car/resources/bootstrap/css/cover.css"
	rel="stylesheet">

<link href="/rent-a-car/resources/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="/rent-a-car/resources/bootstrap/css/login.css"
	rel="stylesheet">
<script type="text/javascript"
	src="/rent-a-car/resources/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/rent-a-car/resources/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="/rent-a-car/resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">
		window.onload = function getLocation() {
	
			if (${validate}==0) {
				alert("invalid password or email");
			} 
		};

		
		
	</script>

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"> <img alt="Brand"
				src="/rent-a-car/resources/images/1.jpg" width="90" height="30">
			</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">About</a></li>
				<li><a href="#">Services</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<div class="row">
		<div class="col-md-8"></div>




		<div class="row text-center">

			<div class="c0l-xs-4">


				<div class="col-xs-5">
				
						<br> <br> <br> <br>
						
				<form class="form-signin" method="POST" 
					action="/rent-a-car/login">
						<h2 class="form-signin-heading">Log in</h2>
						<label for="inputEmail" class="sr-only">Email id</label>
						 <input
							type="email" id="userid" name="userid" class="form-control"
							placeholder="Email address" required autofocus> <br>
						<label for="inputPassword" class="sr-only">Password</label>
						 <input
							type="password" id="password" name="password" class="form-control"
							placeholder="Password" required>
						<div class="checkbox">
							<label> <input type="checkbox" value="remember-me">
								Remember me
							</label>
						</div>
						<button class="btn btn-lg btn-primary btn-block" type="submit">Log
							in</button>

					</form>

				</div>

			</div>

			<div class="col-xs-2">
				<br> <br> <br> <br> <br> <br> <br>


			</div>



			<div class="col-xs-5">

				<form:form class="form-signin" method="POST" modelAttribute="user"
					action="/rent-a-car/">

					<h2 class="form-signin-heading">Sign Up</h2>
					<h5>It is free and always will be.</h5>

					<form:input type="text" class="form-control" path="user_firstname"
						placeholder="First Name" required="true"></form:input>
					<br>
					<form:input type="text" class="form-control" path="user_lastname"
						placeholder="Last Name" required="true" />
					<br>
					<form:input type="text" class="form-control" path="user_emailid"
						placeholder="E-mail id" required="true" />
					<br>
					<form:input type="text" class="form-control" path="user_password"
						placeholder="password" required="true" />
					<br>
					<form:input type="text" class="form-control"
						path="user_phonenumber" placeholder="Phone number" required="true" />
					<br>
					<form:input type="text" class="form-control" path="user_city"
						placeholder="City" required="true" />
					<br>
					<%-- <form:input type="text" class="form-control" path="user_cardno"
							placeholder="Card number"  />
						<br>
						<form:input type="text" class="form-control" path="user_cardexp"
							placeholder="Card exp date"  />
						<br> --%>

					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						up</button>

				</form:form>

			</div>



		</div>

	</div>




	</div>


</body>

</html>