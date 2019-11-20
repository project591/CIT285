package Product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PreparedStatement pstm_A; // This if for the Author table
	private PreparedStatement pstm_B; // This is for the Book table
	
	public void init() throws ServletException{
		initializeJdbc();
	}
		   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();

String AuthorID = request.getParameter("AuthorID");
String AuthorFirstName = request.getParameter("AuthorFirstName");
String AuthorLastName = request.getParameter("AuthorLastName");
String BookId = request.getParameter("BookId");
String isbn = request.getParameter("isbn");
String title = request.getParameter("title");
String editor = request.getParameter("editor");
String edition = request.getParameter("edition");
String year = request.getParameter("year");

try {
	
	if (BookId.length() == 0 ||AuthorFirstName .length() == 0 || AuthorLastName.length() == 0) {
		out.println("Title, Author First Name, and Author Last Name are required");
	}	

else {
	storeProduct(AuthorID, AuthorFirstName, AuthorLastName, BookId, isbn, title, editor, edition, year);
	out.println(title + " " + 
			" is now registered in the database"			
			);
	// The link below will take you back to the homepage after registring. 
	PrintWriter out1 = response.getWriter();
	out1.println("<A HREF=\"http://localhost:8080/BookStore/Home.html\">Homepage</A>");
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
	("jdbc:mysql://localhost/website","root","root45&");
	System.out.println("Database Connected");
	
	// Insert information to the different tables in the database.
	pstm_A = conn.prepareStatement("insert into author" +
			"(AuthorID , AuthorFirstName, AuthorLastName) values(?,?,?)");
	
	// This, below, will insert values into the address table in the database
	pstm_B = conn.prepareStatement("insert into book" +
	"(BookId, isbn, title, editor, edition, year) values(?,?,?,?,?,?)");	

				
	}
	catch (Exception ex)
	{
		ex.printStackTrace();
	}	
 }

private void storeProduct(String AuthorID, String AuthorFirstName, String AuthorLastName,String BookId, String isbn,String title,
String editor, String edition, String year) throws SQLException
{
	pstm_A.setString(1, AuthorID);	
	pstm_A.setString(2, AuthorFirstName);	
	pstm_A.setString(3, AuthorLastName);	
	pstm_B.setString(1, BookId);
	pstm_B.setString(2, isbn);
	pstm_B.setString(3, title);
	pstm_B.setString(4, editor);
	pstm_B.setString(5, edition);	
	pstm_B.setString(6, year);
	
	pstm_A.executeUpdate(); // Will update the user table
	pstm_B.executeUpdate(); // Will update the address table
 }
}
