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
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
		PrintWriter out=response.getWriter();
		String user=request.getParameter("uname");
		 String password=request.getParameter("upw");
		 response.setContentType("text/html"); 
		 try {
				Class.forName("oracle.jdbc.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
					
					PreparedStatement sts=con.prepareStatement("insert into userdict values(?,?)");
					sts.setString(1,user);
					sts.setString(2,password);
					int s=sts.executeUpdate();
					
					//request.setAttribute("resultSet", rs);
		            request.getRequestDispatcher("Userr.jsp").forward(request, response);

		            // Close connections
		           // rs.close();
		            sts.close();
				
				con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		}
	
}


