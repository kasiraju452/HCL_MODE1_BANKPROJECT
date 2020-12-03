<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
<link href="${pageContext.request.contextPath}/css/form.css"
    rel="stylesheet">
</head>
<body>
<form:form action="addaccount" method="post" modelAttribute="accountBean">
	
	<table >
			<tr>
				<td><form:hidden path = "accountId" value = "0" /></td>
			</tr>
			<tr>
				<td>Enter Account Name:</td>
				<td><form:input path="name" /><form:errors path="name" class="error"></form:errors> </td>
			</tr>

			<tr>
				<td>Enter Account Type:</td>
				<td><form:select path="accountType" items="${accounttype}"></form:select><form:errors path="accountType" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Enter address:</td>
				<td><form:input path="address"  /><form:errors path="address" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Enter phone:</td>
				<td><form:input path="phone" /><form:errors path="phone" class="error"></form:errors></td>
			</tr>

			<tr>
				<td>Enter email:</td>
				<td><form:input path="email" /><form:errors path="email" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td>Enter AadharCard Number:</td>
				<td><form:input path="aadharNumber" /><form:errors path="aadharNumber" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td>Enter Pan Card Number:</td>
				<td><form:input path="panNumber" /><form:errors path="panNumber" class="error"></form:errors></td>
			</tr>
			

			<tr>
				<td><input type="submit" value="Add Account" /></td>
			</tr>
		</table>
	
</form:form>
</body>
</html>