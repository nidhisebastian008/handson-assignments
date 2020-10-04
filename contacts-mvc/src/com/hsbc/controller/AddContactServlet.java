package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.model.beans.Contact;
import com.hsbc.model.beans.User;
import com.hsbc.model.service.UserService;
import com.hsbc.model.utilities.UserFactory;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactServlet() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);
		String contactName=request.getParameter("contactname");
		long contactPhone=Long.parseLong(request.getParameter("contactphone"));
		
		HttpSession session=request.getSession();
		User sessionUser=((User) session.getAttribute("userKey"));
		
		
		UserService service = (UserService)UserFactory.getInstance("service");
		
		Contact newContact= new Contact();
		newContact.setUserId(sessionUser.getUserId());
		newContact.setContactName(contactName);
		newContact.setContactPhone(contactPhone);
		service.createContact(sessionUser.getUserId(), newContact);
		
		RequestDispatcher rd = request.getRequestDispatcher("loginsuccess.jsp");
		rd.include(request, response);
	}

}
