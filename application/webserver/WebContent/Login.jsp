<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<body background="Project/logo1.jpg">
	<form action="MainServlet" method="post">
		<input type="hidden" name="action" value="login">

		<h3 align="center">Sign in here</h3>
		<table width="30%" align="center" border="0">
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
				</form>
			</tr>
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

</body>
</html>