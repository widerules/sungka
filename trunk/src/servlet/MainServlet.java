package servlet;

import java.sql.*;
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
		
		if(session.getAttribute("user")==null){
			MainJavaBeans nuser = new MainJavaBeans();
			session.setAttribute("user", nuser);
		}
		MainJavaBeans user = (MainJavaBeans)session.getAttribute("user");
		
		if(request.getParameter("action")==null){
			response.sendRedirect("index.jsp");
		}
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("login")){
			if(user.Login(request.getParameter("username"), request.getParameter("password"))){
				response.sendRedirect("user.jsp");
			}else{
				response.sendRedirect("error.jsp");
			}
		}else if(action.equalsIgnoreCase("signup")){
			if(request.getParameter("password").equalsIgnoreCase(request.getParameter("password2"))){
				
				if(user.checkInput(request.getParameter("username"), request.getParameter("password"), request.getParameter("fname"), request.getParameter("lname"), request.getParameter("address")) )
				response.sendRedirect("success.jsp");
				else{
					response.sendRedirect("error1.jsp");
				}
			}else{
				response.sendRedirect("error.jsp");
			}
			
		}else if(action.equalsIgnoreCase("logout")){
			session.invalidate();
			response.sendRedirect("home.jsp");
		}
		
	}

}
