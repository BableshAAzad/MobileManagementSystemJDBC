<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Mobile Data</title>
<link rel="stylesheet" type="text/css" href="UpdateMobileDataCSS.css">
</head>
<body>
<section>
	<h1>Update Mobile Records</h1>
	<% ResultSet rsltSet = (ResultSet) request.getAttribute("existingMob");
	while(rsltSet.next()){
	%>
	<form action="UpdatedMobileData" method="post">
	  <input type="number" value="<%=rsltSet.getInt("msno")%>" name="msno" readonly="true" /><br><br>
      <input type="text" value="<%=rsltSet.getString("mmodel")%>" name="mmodel" placeholder="Enter Mobile Model"/><br><br>
      <input type="text" value="<%=rsltSet.getString("mprice")%>" name="mprice" placeholder="Enter Mobile Price"/><br><br>
      <input type="text" value="<%=rsltSet.getString("mbrand")%>" name="mbrand" placeholder="Enter Mobile Brand"/><br><br>
      <input type="submit" value="UPDATE"/>
    </form>
    <%}%>
<br>
<h3><a href="DisplayMobile">Back Page</a></h3>
<h3><a href="index.jsp">Home Page</a></h3>
</section>
</body>
</html>