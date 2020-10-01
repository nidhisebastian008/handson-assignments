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
	<p> Name : ${userKey.name}, Phone: ${userKey.phone}</p>
	</br>
	<a href="editprofile.jsp">Edit Profile</a>
	<a href="addcontact.jsp">Add Contact</a>
	<a href="ViewContactServlet">View All Contacts</a>
	<a href="editcontact.jsp">Edit Contact</a>
	<a href="deletecontact.jsp">delete contact</a>
	<a href="DeleteProfileServlet">delete profile</a>
	<a href="LogoutServlet">logout</a>
	

</body>
</html>