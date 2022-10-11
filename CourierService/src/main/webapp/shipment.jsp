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

<title>Shipment Details</title>
</head>
<body>
<form action="ShipmentDetails">
<center>
	<h1>Shipment Details</h1><br><br>
	<p style="font-size:20px">
	Tracking Id : <input type="number" name="tid" required="required" style="font-size:20px"><br><br>
	<button class="button button1">Submit</button><br><br>
	<a href="dashboard.jsp">Go Back</a>
	</p>
</center>
</form>

</body>
</html>