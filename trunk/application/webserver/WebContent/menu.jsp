<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
ul#list-nav {
	padding: 0;
	list-style: none;
	width: 100%;
	text-align: center;
}

ul#list-nav li {
	display: inline;
}

ul#list-nav li a {
	text-decoration: none;
	padding: 10px 0;
	width: 100%;
	background: #0066cc;
	color: #eee;
	float: left;
}

ul#list-nav li a:hover {
	background: #ccffff;
	color: #000
}
</style>
</head>
<body bgcolor="#0066cc">
	<ul id="list-nav">
		<li><a href="content.jsp" target="content">Home</a></li>
		<li><a href="RegisterForm.jsp" target="content">Register</a></li>
		<li><a href="#">Forums</a></li>
		<li><a href="#">Rankings</a></li>
		<li><a href="#">FAQ</a></li>
		<li><a href="search.jsp" target="content">Search Account</a></li>
		<li><a href="aboutus.jsp" target="content">About Us</a></li>
		<%
			if(session.getAttribute("user")==null){%>
				<li><a href="Login.jsp" target="content">Login</a></li>
			<%}
			else{%>
				<li><a href="user.jsp" target="content">Details</a></li>
				<form action="MainServlet" method="post">
				<input type="hidden" name="action" value="logout"">
					<center>
						<input type="submit" value="Logout">
					</center>

				</form>
		<%} %>
		
	</ul>
</body>

</html>