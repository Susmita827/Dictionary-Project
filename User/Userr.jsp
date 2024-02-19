<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.Connection"%>
    <%@page import="java.sql.DriverManager"%>
    <%@page import="java.sql.SQLException"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background-image:url("https://images.wallpaperscraft.com/image/single/book_flowers_petals_851036_1280x720.jpg");
	background-position:center;
	background-size:cover;
	background-repeat:no-repeat;
	background-attachment:fixed;
}
        .container {
            text-align: center;
            margin-top: 50px;
        }
        .meaning-box {
            border: 1px solid black;
            width: 50%;
            margin: 20px auto;
            padding: 10px;
            text-align:center;
            background-color:#FFE9EC;
        }
        .meaning {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
        <h1>Word Meaning Search</h1>
        <div class="search-word">
            <form method="post">
                <label for="searchWord"><b>Enter word:</b></label>
                <input type="text" id="searchWord" name="searchWord">
                <button type="submit">Search</button>
            </form>
        </div>
    </div>

    <div class="meaning-box">
        <% 
            // Handle form submission
            if(request.getMethod().equalsIgnoreCase("post")) {
                // Retrieve the word entered by the user
                String searchWord = request.getParameter("searchWord");
                
                
                Connection connection = null;
                PreparedStatement st = null;
                ResultSet resultSet = null;
                try {
                    // Establish database connection (replace with your actual connection code)
                    connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345678");
                    
                    // Prepare and execute the query
                    String query = "select Meaning FROM dictionarys WHERE Words = ?";
                    st = connection.prepareStatement(query);
                    st.setString(1, searchWord);
                    resultSet = st.executeQuery();
                    if(resultSet.next()) {
                        String meaning = resultSet.getString("meaning");
        %>
                        <h2>Meaning of <%= searchWord %>:</h2>
                        <div class="meaning">
                            <p><%= meaning %></p>
                        </div>
        <% 
                    } else {
        %>
                        <p>No meaning found for <%= searchWord %></p>
        <% 
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    // Close the resources
                    try {
                        if(resultSet != null) resultSet.close();
                        if(st != null) st.close();
                        if(connection != null) connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        %>
    </div>

    
</body>
</html>