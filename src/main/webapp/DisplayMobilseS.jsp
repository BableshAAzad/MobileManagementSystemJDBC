<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mobile Dashboard</title>
</head>
<link rel="stylesheet" type="text/css" href="DisplayMobilesCSS.css">
<body>
	<h1>Mobile Dashboard</h1>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("mobileList");
	%>
	<table border="1" cellspacing="0" cellpadding="5px">
		<thead>
			<tr>
				<th>MSNO</th>
				<th>MModle</th>
				<th>MPrice</th>
				<th>MBrand</th>
				<th>Update Mobile Details</th>
				<th>Delete Mobile from Record</th>
			</tr>
		</thead>
		<tbody>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td class="snoT"><%=rs.getInt("msno")%></td>
				<td class="mnameT"><%=rs.getString("mmodel")%></td>
				<td class="mpriceT"><%=rs.getString("mprice")%></td>
				<td class="mbrandT"><%=rs.getString("mbrand")%></td>
				<td><a class="updateD" href="updateMobile?msno=<%=rs.getInt("msno")%>">UPDATE</a></td>
				<td><a class="deleteD" href="deleteMobile?msno=<%=rs.getInt("msno")%>">DELETE</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br><br>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>
</body>
</html>