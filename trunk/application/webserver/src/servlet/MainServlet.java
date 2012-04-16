package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabeans.MainJavaBeans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		// Initializes session and attributes from MainJavaBeans model.
		if(session.getAttribute("user")==null){
			MainJavaBeans nuser = new MainJavaBeans();
			session.setAttribute("user", nuser);
		}
		
		MainJavaBeans user = (MainJavaBeans)session.getAttribute("user");
		
		// Redirect if parameter "action" is null.
		if(request.getParameter("action")==null){
			response.sendRedirect("index.jsp");
		}
		
		// Passes value of parameter "action" to variable action.
		String action = request.getParameter("action");
		
		// Login
		if(action.equalsIgnoreCase("login")){
			if(user.Login(request.getParameter("username"), request.getParameter("password"))){
				response.sendRedirect("user.jsp");
				
			}
			
			else{
				response.sendRedirect("error.jsp");
			}
		}
		
		// Registration
		else if(action.equalsIgnoreCase("signup")){
			
			if(request.getParameter("password").equalsIgnoreCase(request.getParameter("password2"))){
				
				if(user.checkInput(request.getParameter("username"), request.getParameter("password"), request.getParameter("fname"), request.getParameter("lname"), request.getParameter("address")) )
				response.sendRedirect("success.jsp");
				
				else{
					response.sendRedirect("error1.jsp");
				}
				
			}
			else{
				response.sendRedirect("error.jsp");
			}
			
		}
		
		// Logout
		else if(action.equalsIgnoreCase("logout")){
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
		
		// Search User
		else if(action.equalsIgnoreCase("search")){
			out.print(user.search(request.getParameter("username")));
			
		}
		
		// Add Forum Topic
		else if(action.equalsIgnoreCase("topic")){
			
			user.createTopic(request.getParameter("title"));
			response.sendRedirect("success1.jsp");
		}
		
		// Add Forum Post
		else if(action.equalsIgnoreCase("posting")){
			int id = Integer.parseInt(request.getParameter("id"));
			user.createPost(request.getParameter("content"),id);
			response.sendRedirect("success2.jsp?id="+id);
		}
		
		// Receives Registration parameters from Android Application
		else if(action.equalsIgnoreCase("signupandroid")){
			
			if(request.getParameter("password").equalsIgnoreCase(request.getParameter("password2"))){
				
				if(user.checkInput(request.getParameter("username"), request.getParameter("password"), request.getParameter("fname"), request.getParameter("lname"), request.getParameter("address")) )
				{
										
					out.print(1); // If registration is successful.
				}
				
				else{
					
					out.print(0); // If registration has errors and unsuccessful.
				}
				
			}
			else{
				
				out.print(2); // When password and retype passwords do not match.
			}
			
		}
		
		// Receives Login details from Android Application and validates it back.
		else if(action.equalsIgnoreCase("loginandroid")){
			if(user.Login(request.getParameter("username"), request.getParameter("password"))){
				out.print(1); // When username / password exists	
			}
			
			else{
				out.print(0); // When username / password does not exists
			}
		}
		
		// Receives the scores from the Android Application depending on the logged user there.
		else if(action.equalsIgnoreCase("updatescoreandroid")){
			user.updateScore(request.getParameter("username"), request.getParameter("win"), request.getParameter("loss"));
		}
		
	}

}
