<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RULES OF THE GAME</title>
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
   	<h2>RULES OF THE GAME</h2>
   	<br>
   	<h3><i>An Overview</i></h3>
	<h5>Sungka is a two player game where the players take turns picking up shells from the board and distributing them.  
	The goal is to put as many shells in your home base as possible.  
	You take turns until no more shells are available and that concludes a round.  
	You start a new round with an obvious bias determined by how well you did in the previous round.  
	The game ends when one player cannot even play a round.</h5>
	<br>
	<h4><i>The Initial Board</i></h4>
	<img src="images/board.jpg" />
	<h5>98 small (cowrie) shells,  alternatives:  beans, beads, rocks, anything you can easily fit 10 of in your hand.
	1 Sungka board, alternatives:  some way to separate 16 piles of shells from each other.
	The board consists of two rows of 7 holes, with two additional holes at the either end.  
	These two additional holes are the homes of the respective players.  
	The hole to your left will be yours home.  
	The game starts with 7 shells in each of the 14 holes in the middle. </h5>
	<br>
	<h4><i>Playing a turn</i></h4>
	<h5>When its your turn, you start by picking up any pile on your side of the board.  Once you pick it up, you start dropping one shell in each hole in a clockwise fashion.  This includes your home, but NOT your opponent’s home.  
	Once you place your last shell one of three things happens based on where it lands:

    If it lands in a normal hole and it has shells inside, then pick them all up and continue.
    If it lands in a normal hole and there are no shells, then your turn is done.
    If this happens on your side (you land on your side), and there are shells in your opponents side in the same column, you get to take all of those shells from your opponents side and place them in your home.
    
    If it lands in your home, start again from any hole on your side of your choosing.
    If you have no more shells you can play, the round is done.  The other player automatically claims all the shells on their side and will start the next round.
    Common house rule: When making a choice on which hole to start with, as soon as you touch the shells/hole you must start with that hole.
    </h5>
    <br>
    <h4><i>Playing a full game</i></h4>
	<h5>You keep playing rounds until one entire side of a board has been burned. At that point the game is over and the person with a remaining side wins. </h5>
	
   	<p><b><a href="faq.jsp">BACK</a></b></p>
	</div>
	<div class="push"></div>
	</div>
	<div class="footer">	
		<p>Created By:</p>
    	<p><a href="index.jsp">Janverski</a>
	</div>
</body>
</html>