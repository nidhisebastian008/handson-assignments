<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "EditServlet" method = "post">
		<label>
			Phone <input type = "number" name = "phone" required>
		</label>
		<br />
		<label>
			Password <input type = "password" name = "pass" required>
		</label>
		<br />
		<input type = "submit" value = "Edit">
	</form>

</body>
</html>