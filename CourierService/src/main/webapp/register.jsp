<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
  background-color: white;
  width: 450px;
  border: 4px solid black;
  padding: 50px;
  margin: 100px 650px;
}
.button {
  background-color: #00008B;
  border: none;
  color: white;
  padding: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
}
.button1 {border-radius: 10px;}
</style>

<title>Register</title>
</head>
<body>
<center>
<form action="Register">
	<h1>Register</h1><br><br>
	<p style="font-size:20px">
	Name : <input type="text" name="user" style="font-size:20px" required="required"><br><br>
	City : <select name="city" required="required" style="font-size:20px">
			<option value="" style="font-size:20px">Select city</option>
			<option value="Bangalore" style="font-size:20px">Bangalore</option>
		</select><br><br>
	Mobile : <input type="tel" name="phone" style="font-size:20px" required="required"><br><br>
	Delivery Area : <select name="deliveryArea" required="required" style="font-size:20px">
			<option value="" style="font-size:20px">Select city</option>
			<option value="Bangalore" style="font-size:20px">Bangalore</option>
			<option value="Chennai" style="font-size:20px">Chennai</option>
			<option value="Delhi" style="font-size:20px">Chittoor</option>
			<option value="Mumbai" style="font-size:20px">Mumbai</option>
		</select><br><br>
	<button class="button button1">Submit</button><br><br>
	<a href="login.jsp">Login here</a><br><br>
	</p>
</form>
</center>
</body>
</html>