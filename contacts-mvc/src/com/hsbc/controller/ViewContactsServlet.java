package com.hsbc.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ViewContacts
 */
@WebServlet("/ViewContactsServlet")
public class ViewContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewContactsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session=request.getSession();
		User sessionUser=((User) session.getAttribute("userKey"));
		
		
		UserService service= (UserService) UserFactory.getInstance("service");
		List<Contact>contactsList=service.fetchAllContacts(sessionUser.getUserId());
		//exception null mila to no contacts saved
		
		session.setAttribute("contactsListKey", contactsList);
		
		RequestDispatcher rd= request.getRequestDispatcher("viewcontact.jsp");
		rd.forward(request, response);
//		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
