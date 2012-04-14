<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@
    page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forums</title>
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
    <%
	Connection con = null;
	Statement stmt = null;
	
	try {
		
		
		Class.forName("org.sqlite.JDBC");
		String url = "jdbc:sqlite:C:\\Users\\Toshiba\\workspace\\arizala\\SUNGKA2\\WebContent\\sungka.db";
		con = DriverManager.getConnection(url);
		stmt = con.createStatement();
				} catch (Exception e) {
		System.out.println("Error "+e.getMessage());
	}	 
	
	int data;
	String data2;
	String url;
	
	try{
	String sql = "SELECT ID, TITLE FROM TOPIC";
	ResultSet set = stmt.executeQuery(sql);
	
	
	while(set.next()) 
	{
		data=set.getInt("id");
		data2=set.getString("title");
		url="post.jsp?id="+ data;

	
		
		out.println("<a href='"+url+"'>"+data2+"</a>");
			
	
	}
	
	} catch (Exception e) {
		System.out.println("Error "+e.getMessage());
	}	 
	%>
	<form action="MainServlet" method="post">
	<input type="hidden" name="action" value="topic">
	Create Topic
	Title: <input type="text" name="title">
	<input type="submit" value="Submit">
	</form>
	</div>
	<div class="push"></div>
	</div>
	<div class="footer">	
		<p>Created By:</p>
    	<p><a href="index.jsp">Janverski</a>
	</div>
</body>
</html>