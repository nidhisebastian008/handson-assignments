<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to Login Success Page</h3>
	<p>Id: ${userKey.userId}, Name : ${userKey.name}, Phone: ${userKey.phone}</p>
	</br>
	<a href="update.html">Update details</a>
	<a href="login.html">Logout</a>
	<form action = "SearchServlet" method = "post">
		<label>
			user-id <input type = "text" name = "userid">
		</label>
		<input type = "submit" value = "search">
	</form>

</body>
</html>