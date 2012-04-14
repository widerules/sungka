<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
    <li><a id="last" href="Login.jsp">Login</a></li>
    </ul>
	</div>
    <div class="content">
    <img class="login" src="images/login.png" />
    <form action="MainServlet" method="post">
		<input type="hidden" name="action" value="login">

		<h3 align="center">Sign in here</h3>
		<table style="margin-left:auto;margin-right:auto">
			<tr>
				<td width="30%" align="right">Username:</td>
				<td width="70%" align="left"><input type="text" name="username"></td>
			</tr>
			<tr>
				<td width="30%" align="right">Password:</td>
				<td width="70%" align="left"><input type="password"
					name="password"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					value="Log in"></td>
			</tr>
		</form>
			<tr>
				<td align="center" colspan="2">
				
				<form action="RegisterForm.jsp" method="Link">
					<center>
						<input type="submit" value="Click Here to Register">
					</center>

				</form>
				
					</td>
				</tr>
					
		</table>	
	</div>
	<div class="push"></div>
	</div>
	<div class="footer">	
		<p>Created By:</p>
    	<p><a href="index.jsp">Janverski</a>
	</div>
</body>
</html>