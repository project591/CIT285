<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Product Form</h1>
<form action="addProduct" method="post">
			<table style="with: 50%">
			
			<tr>
				<td>Author ID</td>
				<td><input type="text" name="AuthorID" /></td>					
					
				</tr>			
			<tr>
			<tr>
					<td>Author First Name</td>
					<td><input type="text" name="AuthorFirstName" /></td>					
					
			</tr>
			<tr>
					<td>Author Last Name</td>
					<td><input type="text" name="AuthorLastName" /></td>
										
			
			<tr>
					<td>Book ID</td>
					<td><input type="text" name="BookId" /></td>
			</tr>
			<tr>
					<td>ISBN</td>
					<td><input type="text" name="isbn" /></td>
			</tr>
			<tr>
					<td>Title</td>
					<td><input type="text" name="title" /></td>
			</tr>
			<tr>
					<td>Editor</td>
					<td><input type="text" name="editor" /></td>
			</tr>
			<tr>
					<td>Edition</td>
					<td><input type="text" name="edition" /></td>
			</tr>
			<tr>
					<td>Year</td>
					<td><input type="text" name="year" /></td>										
			</tr></table>
			<input type="submit" value="Submit" /></form>			
			
</body>
</html>