<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@
    page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>POST</title>
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
int id = Integer.parseInt(request.getParameter("id")); 

Connection con = null;
Statement stmt = null;

try {
	
	
	Class.forName("org.sqlite.JDBC");
	String url = javabeans.MainJavaBeans.url;
	con = DriverManager.getConnection(url);
	stmt = con.createStatement();
			} catch (Exception e) {
	System.out.println("Error "+e.getMessage());
}	 

try{
String sql = "SELECT CONTENT FROM POST WHERE TOPIC_ID="+id;
ResultSet set = stmt.executeQuery(sql);
String data;

while(set.next()) 
{
	data=set.getString("content");

	out.println(data);
		

}

} catch (Exception e) {
	System.out.println("Error "+e.getMessage());
}
%>
<form action="MainServlet" method="post">
	<input type="hidden" name="action" value="posting">
	<input type="hidden" name="id" value=<%=id %>>
	Create Post
	Content: <input type="text" name="content">
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