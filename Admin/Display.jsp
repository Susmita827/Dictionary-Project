<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>  

body{
	background-image:url("https://cdn.pixabay.com/photo/2019/01/24/22/12/flower-3953461_960_720.jpg");
	background-position:center;
	background-size:cover;
	background-repeat:no-repeat;
	background-attachment:fixed;
} 
h1{
text-decoration:underline;
color:#00ff00;
} 

table, th, td {    
border: 1px solid black;  
margin-left: auto;  
margin-right: auto;  
border-collapse: collapse;    
width: 500px;  
text-align: center;  
font-size: 20px; 
background-color:white; 
}  
th{
background-color:#808080;
}
td{
background-color:#c0c0c0;
}  
</style>  
</head>
<body>
<h1 style="text-align:center">User Data</h1>
    <table border="1" style="width:40%;text-align:center;left:30px" >

        <tr>
            <th>WORDS</th>
            <th>MEANING</th>
            </tr>
            
            <% 
            ResultSet rs = null;
            try{
            rs =(ResultSet) request.getAttribute("resultSet");
            while (rs.next()) {
        %>
            <tr align="center" >
                <td><%= rs.getString("Words") %></td>
                <td><%= rs.getString("Meaning") %></td>
                </tr>
        <% }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close the ResultSet
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } %>
        
    </table>
    

</body>
</html>