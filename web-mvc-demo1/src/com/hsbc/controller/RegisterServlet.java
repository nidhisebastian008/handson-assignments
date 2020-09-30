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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String userName = request.getParameter("user");
		String password=request.getParameter("pass");
		long phone=Long.parseLong(request.getParameter("phone"));
		
		
		UserService service = (UserService)UserFactory.getInstance("service");
			
			User newUser= new User();
			newUser.setName(userName);
			newUser.setPassword(password);
			newUser.setPhone(phone);
			
			User user = service.createUser(newUser);
			HttpSession session = request.getSession();
			session.setAttribute("userKey", user);
			RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
			rd.forward(request, response);
		
	}

}
