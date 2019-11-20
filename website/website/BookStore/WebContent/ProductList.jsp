<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mysql.*" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
    <p>Displaying Products: </p>

    <table border="0" cellpadding="10">
        <thead>
            <tr>
                <th>Title</th>
                <th>Year</th>              
               
            </tr>
        </thead>
        <tbody>

            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = null;
                conn = DriverManager.getConnection("jdbc:mysql://localhost/website", "root", "root45&");
                Statement stmt = null;
                stmt = conn.createStatement();
                String query = "select * from book";
                ResultSet rs = null;
                rs = stmt.executeQuery(query);
                while(rs.next()){
            %>
            <tr>
                <%
                    String title = rs.getString("title");
                    int year = rs.getInt("year");
                   
                %>
                <td><%=title %></td>
                <td><%=year %></td>
                
            </tr>               

            <%      
                }
            %>

        </tbody>
    </table>
</div>
</body>
</html>