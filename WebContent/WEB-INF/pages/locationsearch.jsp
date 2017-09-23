<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="ngMap">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Location Search</title>


<link rel="stylesheet"
	href="/rent-a-car/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/rent-a-car/resources/bootstrap/css/bootstrap-theme.min.css">
<link href="/rent-a-car/resources/css/carousel.css" rel="stylesheet">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>




<script type="text/javascript"
	src="/rent-a-car/resources/bootstrap/js/bootstrap.min.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=weather,visualization,panoramio"></script>
<script src="http://code.angularjs.org/1.2.25/angular.js"></script>
<script
	src="https://rawgit.com/allenhwkim/angularjs-google-maps/master/build/scripts/ng-map.js"></script>

<script>
	$(function() {
		/*  $( "#to_date" ).datepicker(); */
		$("#fromdate").datepicker({

			minDate : 0,
			maxDate : "+60D",
			numberOfMonths : 2,
			 dateFormat: 'yy-mm-dd' ,
			onSelect : function(selected) {
				$("#todate").datepicker("option", "minDate", selected)
			}
		});

		$("#todate").datepicker({
			minDate : 0,
			maxDate : "+60D",
			numberOfMonths : 2,
			 dateFormat: 'yy-mm-dd' ,
			onSelect : function(selected) {
				$("#fromdate").datepicker("option", "maxDate", selected)
			}
		});
		
	});
	
	function showDate(link) {
		//alert(	window.location="/rent-a-car/reservation?car_id=AA315&user_id="+link+"from_date="+$("#fromdate").val()+"&to_date="+$("#todate").val());
		window.location="/rent-a-car/reservation?car_id=AA315&user_id="+link+"from_date="+$("#fromdate").val()+"&to_date="+$("#todate").val();
		
	};
	/* 	$(document).ready(function() {
	
	
	
	 }); */
</script>



</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Rent-a-Car</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li><a href="/locationsearch">Location Search</a></li>
			</ul>



		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>



	<div class="container">

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<form method="POST" action="/rent-a-car/search">
					<div class="input-group">
						<input type="text" class="form-control" id="qry" name="qry"
							placeholder="Search for..."> <span
							class="input-group-btn">
						<input type="hidden" value="${user_id }" id="user_id" name="user_id"/>
							<button class="btn btn-default" type="submit">Search</button>

						</span>


					</div>
					<div class="panel-body">
						<div class="caption">
							<h4>From Date: &emsp; &emsp; &emsp; &emsp;To Date:</h4>
						</div>
						<input type="text" required="true" name="fromdate" id="fromdate" /> &emsp;<input
							type="text" name="todate" required="true" id="todate">

					</div>
					<!-- /input-group -->

				</form>
				<!-- <button class="btn btn-default" onclick="showDate()">pos</button>
				<p id="demo"></p> -->
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-md-2"></div>
		</div>

		<br>
		<div class="row">

			<div class="col-md-6">


				<map center="current-location" zoom="12">
					<info-window position="current-location" visible="true">
					<span>You are here</span> </info-window>
					 <marker position="59.327383, 18.06747" on-click="toggleBounce()" animation="DROP" draggable="true"></marker>
      
					<c:forEach items="${locations}" var="loc">
					<!-- <script type="text/javascript">alert("${loc.lat}");</script> -->
						<marker position="${loc.lat},${loc.longitudinal} "
							 zoom="12" animation="DROP" draggable="true"></marker>
					</c:forEach>
					<!-- ngRepeat: pos in positions -->
				</map>

				<!-- 	<map center="-25.363882,131.044922" zoom="4">
					<marker position="-25.363882,131.044922" title="Hello World!"></marker>
				</map> -->
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-md-4">
				<div class="panel-body">
					<c:forEach items="${locations}" var="loc">
						<div class="row">
							<div class="col-md-2">
								<a class="thumbnail">
									<img src="/rent-a-car/resources/images/locaimage.png" alt="...">
								</a>
							</div>
							<div class="col-md-10">

								<div class="caption">
									<h3>
									<button class="btn btn-default" onclick="showDate('${user_id}')">${loc.location_name}</button>
									<%-- 	--%>
									</h3>

								</div>
							</div>
						</div>
					</c:forEach>

				</div>


			</div>
		</div>
	</div>
	<script type="text/javascript">
		window.onload = function getLocation() {
			var x = document.getElementById("demo");
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(showPosition);

			} else {
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		};

		function showPosition(position) {
			//alert(position.coords.latitude);
			x.innerHTML = "Latitude: " + position.coords.latitude
					+ "<br>Longitude: " + position.coords.longitude;

		};
		
	
		
	</script>
</body>
</html>