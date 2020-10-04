<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Your Contacts</h3>
	<%-- ${contactsListLey} --%>
	
	<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "core" %>
	<ol>
		<core:forEach items="${contactsListKey}" var="c">
			<li>Id=${c.contactId},Name= ${c.contactName}, Phone = ${c.contactPhone}</li>
		</core:forEach>
	</ol>

</body>
</html>