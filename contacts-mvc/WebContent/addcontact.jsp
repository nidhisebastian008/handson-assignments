<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddContactServlet" method="post">
		<label>
			Name <input type = "text" name = "contactname" required>
		</label>
		<br />
		<label>
			Phone <input type = "number" name = "contactphone" required>
		</label>
		<br />
		<input type = "submit" value = "Add Contact">
</form>

</body>
</html>