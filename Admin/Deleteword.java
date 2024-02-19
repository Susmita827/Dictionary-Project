package com.dict;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deleteword
 */
@WebServlet("/Deleteword")
public class Deleteword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String word=request.getParameter("wordd");
		response.setContentType("text/html"); 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
				
				PreparedStatement sts=con.prepareStatement("delete from dictionarys where Words=?");
				sts.setString(1,word);
				int s=sts.executeUpdate();
				if(s!=0) {
					response.sendRedirect("Details.jsp");
				}
				con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String words=request.getParameter("wordd");
		response.setContentType("text/html"); 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
				
				PreparedStatement sts=con.prepareStatement("Delete from dictionarys where Words=?");
				sts.setString(1,words);
				int s=sts.executeUpdate();
				if(s!=0) {
					response.sendRedirect("Details.jsp");
				}
				con.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}

