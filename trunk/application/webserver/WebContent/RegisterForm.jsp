<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="container">
  <div class="header">
  <img class="logo" src="images/logo.png" />
    <ul id="list-nav">
    <li><a id="first" href="home.jsp">Home</a></li>
	<li><a href="RegisterForm.jsp">Register</a></li>
	<li><a href="forums.jsp">Forums</a></li>
	<li><a href="ranking.jsp">Rankings</a></li>
	<li><a href="faq.jsp">FAQ</a></li>
    <li><a href="search.jsp">Search</a></li>
	<li><a href="aboutus.jsp">About Us</a></li>
   <%
			if(session.getAttribute("user")==null){%>
				<li><a id="last" href="Login.jsp">Login</a></li>
			<%}
			else{%>
				<li><a id="last" href="Login.jsp">Logout</a></li>
		<%} %>
    </ul>
	</div>
    <div class="content">
    <br>
    <h3 align="center">Sign up here.</h3>
	<form action="MainServlet" method="post">
		<input type="hidden" name="action" value="signup">
		<table style="margin-left:auto;margin-right:auto;width:80%">
			<tr>
				<td width="50%" align="right">Username:</td>
				<td width="50%" align="left"><input type="text" name="username"></td>
			</tr>
			<tr>
				<td width="50%" align="right">Password:</td>
				<td width="50%" align="left"><input type="password"
					name="password"></td>
			</tr>
			<tr>
				<td width="50%" align="right">Retype Password:</td>
				<td width="50%" align="left"><input type="password"
					name="password2"></td>
			</tr>
			<tr>
				<td width="50%" align="right">Firstname:</td>
				<td width="50%" align="left"><input type="text" name="fname"></td>
			</tr>
			<tr>
				<td width="50%" align="right">Lastname:</td>
				<td width="50%" align="left"><input type="text" name="lname"></td>
			</tr>
			<tr>
				<td width="50%" align="right">Email Address:</td>
				<td width="50%" align="left"><input type="text" name="address"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="Sign Up"></td>

			</tr>
		</table>
	</form>
	<center>
		<a href="Login.jsp">back to login</a>
	</center>
	</div>
	<div class="push"></div>
	</div>
	<div class="footer">	
		<p>Created By:</p>
    	<p><a href="index.jsp">Janverski</a>
	</div>
</body>
</html>