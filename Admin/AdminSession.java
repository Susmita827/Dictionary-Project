package com.dict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminSession
 */
@WebServlet("/AdminSession")
public class AdminSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("un");
		String password=request.getParameter("pw");
		
		if(username.equals("Admin")&& password.equals("Admin123")) {
			HttpSession session=request.getSession(true);
			
			response.sendRedirect("Details.jsp");
		}
		
		else {
			
			response.sendRedirect("Admin.jsp"); 
			
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("un");
		String password=request.getParameter("pw");
		
		if(username.equals("Admin")&& password.equals("Admin123")) {
			HttpSession session=request.getSession(true);
			
			response.sendRedirect("Details.jsp");
		}
		
		else {
			
			response.sendRedirect("Admin.jsp"); 
			
			
		}
		
	}

}
