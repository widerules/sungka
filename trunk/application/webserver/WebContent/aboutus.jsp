<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
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
  <br>
  <center>
		<h1>ABOUT US</h1>
	</center>
	<br>
	<center>
		<h2>JANVERSKI</h2>
	</center>
	<br>
	<center>
	<img src="images/janverski.png" alt="JANVERSKI" width="350" height="270" >
	</center>
	<br>
	<br>
	<center>
		<h2>THE PROGRAMMERS</h2>
	</center>
	<br>
	<center>
		<h3>JANVER CODILAN</h3>
	</center>
	<center>
		<h3>PAUL JARED CADELINA</h3>
	</center>
	<center>
		<h3>JAY VENSON GENCIANEO</h3>
	</center>
	<center>
		<h3>CHRISTIAN MICHAEL ARIZALA</h3>
	</center>
	<br>
	<br>
  </div>
	<div class="push"></div>
  </div>
	<div class="footer">
    	<p>Created By:</p>
    	<p><a href="index.jsp">Janverski</a></p>
   </div>
</body>
</html>
