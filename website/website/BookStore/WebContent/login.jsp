<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center">
		<h1>User Login</h1>
		<form action="login" method="post" id="loginForm">
			<label for="email">Email:</label>
			<input name="email" size="30" />
			<br><br>
			<label for="password">Password:</label>
			<input type="password" name="password" size="30" />
			<br>${message}
			<br><br>			
			<button type="submit">Login</button>
		</form>
		</div>
</body>
</html>