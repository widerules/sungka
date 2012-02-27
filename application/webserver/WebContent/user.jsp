<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%
	if(session.getAttribute("user")==null){
	response.sendRedirect("index.jsp");
} 
 javabeans.MainJavaBeans user = (javabeans.MainJavaBeans)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background = "Project/logo1.jpg">
	<h3>
		Welcome
		<% out.println(user.getUsername()); %>
	</h3>
	<table width="50%">
		<tr>
			<td width="50%">First Name:</td>
			<td>
				<% out.println(user.getFname()); %>
			</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>
				<% out.println(user.getLname()); %>
			</td>
		</tr>
		<tr>
			<td>Email Address:</td>
			<td>
				<% out.println(user.getEmail()); %>
			</td>
		</tr>
		<tr>
			<td><a href="MainServlet?action=logout">Logout</a></td>
		</tr>
	</table>
</body>
</html>