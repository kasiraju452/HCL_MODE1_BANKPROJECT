<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HCL Internal Bank Application Deposit page</title>
</head>
<body>
	<form:form action="deposit" method="post" modelAttribute="depositBean">
		<table>
			<tr>
				<td>Enter From Account:</td>
				<td><form:input path="Accountid"/><form:errors path="Accountid" class="error"/></td>
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