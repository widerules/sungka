<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body background="Project/logo1.jpg">
	<h3 align="center">Sign up here.</h3>
	<form action="MainServlet" method="post">
		<input type="hidden" name="action" value="signup">
		<table width="30%" align="center" border="0">
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
</body>
</html>