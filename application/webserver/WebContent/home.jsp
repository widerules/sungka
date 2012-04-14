<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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
    <h1>WELCOME TO OUR WEBSITE</h1>
	<h2>THE GAME OF SUNGKA</h2>
	<img src="images/sungka.png" alt="SUNGKA" />
	<br>
	<h4>Sungka (pronounced SOONG-kah) is a game played on a solid
		wooden block with two rows of seven circular holes and two large holes
		at both ends called "head". The game begins with 49 game pieces
		(shells, marbles, pebbles or seeds) equally distributed to alternate
		holes - seven pieces in every other hole - except "heads" which remain
		empty. Sungka requires two players. Each player controls the seven
		holes on his side of the board and owns the "head" to his right. The
		goal is to accumulate as many pieces in your own "head". The first
		player removes all pieces from the hole on the extreme left of on his
		side. He then distributes them anti-clockwise --- one in each hole to
		the right of that hole --- omitting an opponent's "head" but not a
		player's own "head". If the last piece falls into an occupied hole
		then all the pieces are removed from that hole, and are distributed in
		the same way (to the right of that hole) in another round. This
		player's (current) turn ends when the last piece falls into an empty
		hole on the opponent's side.</h4>
		<br>
	</div>
	<div class="push"></div>
	</div>
	<div class="footer">	
		<p>Created By:</p>
    	<p><a href="index.jsp">Janverski</a>
	</div>
</body>
</html>
