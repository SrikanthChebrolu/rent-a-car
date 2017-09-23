<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation Page</title>
<link href="/rent-a-car/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/rent-a-car/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
<script type="text/javascript" src="/rent-a-car/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/rent-a-car/resources/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/rent-a-car">Home</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
       
        <li><a href="#">Location Search</a></li>
       </ul>
       </div>
       </div>
       </nav>
<br>


<div class="container">

<div class="row">

<div class="col-md-8 col-md-offset-2">
 

<div class="row">
<div class="panel panel-default">
<div class="panel-heading">
    <h2 class="panel-title">Car Details</h2>
  </div>
  <div class="panel-body">
   <div class="row">
  <div class="col-md-6">
    <a href="/rent-a-car/" class="thumbnail">
      <img src="${cardetails.car_imageurl}" alt="...">
    </a>
  </div>
</div>
  <ul class="list-group">
    <li class="list-group-item">Car Name:${cardetails.car_name}</li>
    <li class="list-group-item">Car Type:${cardetails.car_type}</li>
    <li class="list-group-item">Manufacturing Year:${cardetails.car_year}</li>
    <li class="list-group-item">Total Price: ${n.car_price}</li>
    <li class="list-group-item">Pick-up Date:${booking.from_date}&emsp;&emsp;&emsp;Return Date:${booking.to_date}</li>
  </ul>

 
</div>
</div>
</div>


</div>
</div>
</div>



<div class="container">
<div class="row">
<div class="col-md-8 col-md-offset-2">



<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">Enter Details</h3>
  </div>
  <div class="panel-body">
 

<div class="input-group">
  <span class="input-group-addon" id="sizing-addon2">First Name</span>
 <input type="text" class="form-control"  value="${customerdetails.user_firstname }" required="true" placeholder="Enter First Name" aria-describedby="sizing-addon2"></input>
</div>
<br>

 
<div class="input-group">
  <span class="input-group-addon" id="sizing-addon2">Last Name</span>
  <input type="text" class="form-control"   required="true" placeholder="Enter Last Name" aria-describedby="sizing-addon2"  value="${customerdetails.user_lastname }"></input>
</div>
<br>
<div class="input-group">
  <span class="input-group-addon" id="sizing-addon2">Email-id</span>
  <input type="email" class="form-control"  placeholder="Enter Email" aria-describedby="sizing-addon2"  value="${customerdetails.user_emailid }"></input>
</div>
<br>

<div class="input-group">
  <span class="input-group-addon" id="sizing-addon2">Phone number</span>
<input type="text" class="form-control"  required="true" placeholder="Enter Phone Number" aria-describedby="sizing-addon2" value="${customerdetails.user_phonenumber }"></input>
</div>
<br>



<div class="input-group">
<span class="input-group-addon" id="sizing-addon2">Card Number</span>
<input type="text" class="form-control"   required="true" placeholder="Enter Card Number" aria-describedby="sizing-addon2" value="${customerdetails.user_cardno }" ></input>
</div>
<br>



<div class="input-group">
<span class="input-group-addon" id="sizing-addon2">Card Expiry</span>
<input type="text" class="form-control"   required="true" placeholder="Enter Card Number" aria-describedby="sizing-addon2" value ="${customerdetails.user_cardexp }"></input>
</div>
<br>

<form method="POST" action="/rent-a-car/reservation">

<input  type="hidden" class="form-control" id="car_id" name="car_id" value="${cardetails.car_id}"/> 
<input type="text" type="hidden" class="form-control" id="user_id" name="user_id" value="${customerdetails.user_id}"/> 
<input type="text" type="hidden" class="form-control" id="from_date" name="from_date" value="${from_date}"/> 
<input type="text" type="hidden" class="form-control" id="to_date" name="to_date" value="${to_date}"/> 

 <button type="submit" class="btn btn-danger pull-right">Rent the Car</button>
<form>
   
  </div>
</div>
</div>
</div>
</div>

</body>
</html>



