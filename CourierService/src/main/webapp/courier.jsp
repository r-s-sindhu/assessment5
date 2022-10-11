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

<title>Courier</title>
</head>
<body>
<form action="Courier">
<center>
	<h1>Courier</h1><br><br>
	<p style="font-size:20px">
	Weight(in gms) : <input type="number" name="weight" required="required" Style="font-size:20px"><br><br>
	<button class="button button1">Submit</button><br><br>
	<a href="dashboard.jsp">Go Back</a>
	</p>
</center>
</form>
</body>
</html>