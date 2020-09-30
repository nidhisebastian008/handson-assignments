package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.utilities.UserFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user");
		int id = Integer.parseInt(userId);
		String password = request.getParameter("pass");
		UserService service = (UserService)UserFactory.getInstance("service");
		try {
			User user = service.login(id, password);
			HttpSession session = request.getSession();
			session.setAttribute("userKey", user);
			RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
			rd.forward(request, response);
		} catch (AuthenticationException e) {	
			RequestDispatcher rd = request.getRequestDispatcher("loginfailure.jsp");
			request.setAttribute("err", e.getMessage());
			rd.forward(request, response);
		}
	}

}
