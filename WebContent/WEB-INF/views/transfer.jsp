<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HCL Internal Bank Application</title>
</head>
<body>
<form:form action="transfer" method="post" modelAttribute="transferbean">
	<table>
		<tr>
			<td>Enter From Account:</td>
			<td><form:input path="fromAccountId"/><form:errors path="fromAccountId" class="error"></form:errors> </td>
		</tr>
		<tr>
			<td>Enter TO Account:</td>
			<td><form:input path="toAccountId"/><form:errors path="toAccountId" class="error"/></td>
		</tr>
		<tr>
			<td>Enter Amount:</td>
			<td><form:input path="amount"/><form:errors path="amount" class="error"/></td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>