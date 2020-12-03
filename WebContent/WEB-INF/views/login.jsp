<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link href="${pageContext.request.contextPath}/cascadestylesheet/style.css"
    rel="stylesheet">
</head>
<body>
	<form:form action="login" method="post" modelAttribute="loginBean">
		<table>
			<tr>
				<td>Enter username:</td>
				<td><form:input path="username" /><form:errors path="username" class="error"></form:errors> </td>
			</tr>

			<tr>
				<td>Enter password:</td>
				<td><form:input type="password"  path="password" /><form:errors path="password" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="login"> </td>				
			</tr>
		</table>
	</form:form>
</body>
</html>