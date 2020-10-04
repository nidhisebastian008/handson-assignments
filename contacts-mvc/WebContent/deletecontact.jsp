<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DeleteContactServlet" method="post">
		<label>
			Contact Id<input type = "number" name = "contactid" required>
		</label>
		
		<input type = "submit" value = "Delete Contact">
</form>

</body>
</html>