package com.dict;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ddisplay
 */
@WebServlet("/Ddisplay")
public class Ddisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ddisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from dictionarys ORDER BY Words");
			 request.setAttribute("resultSet", rs);
	            request.getRequestDispatcher("Display.jsp").forward(request, response);

	            // Close connections
	            rs.close();
	            st.close();
			
			con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from dictionarys ORDER BY Words");
			 request.setAttribute("resultSet", rs);
	            request.getRequestDispatcher("Display.jsp").forward(request, response);

	            // Close connections
	            rs.close();
	            st.close();
			
			con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
}