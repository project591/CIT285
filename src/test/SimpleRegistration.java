package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 * Servlet implementation class SimpleRegistration
 */
@WebServlet("/SimpleRegistration")
public class SimpleRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PreparedStatement pstm_A; // This if for the Address table
	private PreparedStatement pstm_E; // This is for the Email table
	private PreparedStatement pstm_U; // This is for the User table
	private PreparedStatement pstm_P; // This is for the Phone table	
	
	public void init() throws ServletException{
		initializeJdbc();
	}
		   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String lastName = request.getParameter("lastName");
String firstName = request.getParameter("firstName");
String password = request.getParameter("password");
String email = request.getParameter("email");
String telephone = request.getParameter("telephone");
String address = request.getParameter("street");
String city = request.getParameter("city");
String state = request.getParameter("state");
String zip = request.getParameter("zip");

try {
	
	if (lastName.length() == 0 || firstName.length() == 0 || email.length() == 0) {
		out.println("Last Name, First Name, and Email are required");
	}	

else {
	storeStudent(lastName, firstName, password, email, telephone,address, city, state,zip);
	out.println(firstName + " "+ lastName + 
			" is now registered in the database"
			
			
			);
	// The link below will take you back to the homepage after registring. 
	PrintWriter out1 = response.getWriter();
	out1.println("<A HREF=\"http://localhost:8080/registration/home.html\">Homepage</A>");
 }		
}

catch (Exception ex)
{
out.println("Error " + ex.getMessage());	
}

finally {
	out.close();
 }
}

private void initializeJdbc() {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver loaded");
	
	// Change this part of the code. website is the name of my database,Root is the username, and goodDay62! is the password of mySQL database
	// Change to your database the database name, username, and password.  
	Connection conn = DriverManager.getConnection
	("jdbc:mysql://localhost/website","root","juicer!");
	System.out.println("Database Connected");
	
	// Insert information to the different tables in the database.
	
	// This, below, will insert values into the address table in the database
	pstm_A = conn.prepareStatement("insert into address" +
	"(street, city, state, zip) values(?,?,?,?)");	
	//	// This, below, will insert values into the user table in the database
	pstm_U = conn.prepareStatement("insert into user" +
	"(lastName, firstName, password, email) values(?,?,?,?)");
	// This, below, will insert values into the phone table in the database
	pstm_P = conn.prepareStatement("insert into phone" +
	"(telephone) values(?)");
				
	}
	catch (Exception ex)
	{
		ex.printStackTrace();
	}	
 }

private void storeStudent(String lastName, String firstName, String password, String email
, String telephone, String address, String city, String state, String zip) throws SQLException
{
	pstm_U.setString(1, lastName);
	pstm_U.setString(2, firstName);
	pstm_U.setString(3, password);
	pstm_U.setString(4, email);
	pstm_P.setString(1, telephone);	
	pstm_A.setString(1, address);
	pstm_A.setString(2, city);
	pstm_A.setString(3, state);
	pstm_A.setString(4, zip);
	pstm_A.executeUpdate(); // Will update the address table
	pstm_U.executeUpdate(); // Will update the user table
	pstm_P.executeUpdate(); // Wil update the phone table
 }
}
