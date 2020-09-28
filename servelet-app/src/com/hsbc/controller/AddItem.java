package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddItem
 */
@WebServlet("/add-item")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String itemName=request.getParameter("item");
		
		
		PrintWriter pw = response.getWriter();
		// session object
		HttpSession session = request.getSession();

		
		// storing data in a session
		
		if(session.isNew())
		{
			List<String>list= new ArrayList<>();
			list.add(itemName);
			session.setAttribute("list", list);
		}else
		{
			 List<String> retList= ((List<String>) session.getAttribute("list"));
			 retList.add(itemName);
			 session.setAttribute("list", retList);
		}
		
		
		pw.print("<html><body>");
		pw.print("<p>Session Id: "+session.getId()+"</p>");
		pw.print("<p>Item Count: "+((List<String>) session.getAttribute("list")).size()+"</p>");
		pw.print("</body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("item.html");
		rd.include(request, response);
		
		doGet(request, response);
	}

}
