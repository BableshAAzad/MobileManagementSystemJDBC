<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Mobile page</title>
<link rel="stylesheet" type="text/css" href="UpdateMobileDataCSS.css">
</head>
<body>
<section>
<h1>Add New Mobile in Stack</h1>
<form action="addMobile" method="post">
  <input type="text" name="mmodel" placeholder="Enter Mobile Model"/><br><br>
  <input type="text" name="mprice" placeholder="Enter Mobile Price"/><br><br>
  <input type="text" name="mbrand" placeholder="Enter Mobile Brand"/><br><br>
  <input type="submit" value="ADD"/>
</form>
<br><br>
<h2><a href="index.jsp">Home Page</a></h2>
</section>
</body>
</html>