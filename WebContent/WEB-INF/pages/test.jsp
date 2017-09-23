<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script language="JavaScript" src="http://www.geoplugin.net/javascript.gp" type="text/javascript"></script>

  </head>
<body>
<script>
    $(function() {
        $( "#datepicker" ).datepicker();
    });
    <script type="text/javascript">
    jQuery(document).ready(function($) {
        alert("Your location is: " + geoplugin_countryName() + ", " + geoplugin_region() + ", " + geoplugin_city());
     
        var country = geoplugin_countryName();
        $("#country").append("<option value='1' selected>"+country+"</option>");
     
        var zone = geoplugin_region();
        $("#zone").append("<option value='1' selected>"+zone+"</option>");
     
        var district = geoplugin_city();
        $("#district").append("<option value='1' selected>"+district+"</option>");
    });
    </script>
   
    <div class="demo">
    <p>Date: <input type="text" id="datepicker"></p>
    <label for="country">Country</label>
<select id="country" name="country" >
      <option value="" selected></option>
</select><br />
<label for="zone">Region</label>
<select id="zone" name="zone" >
      <option value="" selected></option>
</select><br />
<label for="district">City</label>
<select id="district" name="district" >
      <option value="" selected></option>
</select>
    </div><!-- End demo -->
</body>
</html>