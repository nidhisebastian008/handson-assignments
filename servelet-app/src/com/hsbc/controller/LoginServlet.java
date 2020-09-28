package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		System.out.println("doGet is called");
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><p>");
		pw.print("Login Servlet GET method");
		pw.print("</p></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("doPost is called");
		PrintWriter pw = response.getWriter();
		
		
		 pw = response.getWriter();
		// getParameter takes name of the parameter & returns the value in string format
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		pw.print("<html><body><p>");
		// this is manually verifying the username & password which is done in the model layer
		if(username.equals("nidhi") && password.equals("nidhi123")) {
			pw.print("Hello "+username+", you have logged in");
			
			RequestDispatcher rd= request.getRequestDispatcher("success.html");
			rd.forward(request, response);
		} else {
			pw.print("<html><body><p style='color:red'>");
			pw.print("Sorry invalid credentials Login again");
			pw.print("</p></body></html>");
			RequestDispatcher rd= request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		pw.print("</p></body></html>");

		
		doGet(request, response);
	}

}
