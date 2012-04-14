<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%
 javabeans.MainJavaBeans user = (javabeans.MainJavaBeans)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Janverski</title>
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
  <center>
	<br>

		<%
			if(session.getAttribute("user")!=null){%>
				<h1>Welcome <% out.println(user.getUsername()); %></h1>
			<%}%>
		
	
		<img src="images/janverski.png"><br>
		<br><b><i>"Making the world a better place"</i></b>
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
