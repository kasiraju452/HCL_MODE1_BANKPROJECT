<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all accounts</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}
.links a {
  background-color: #4CAF50;
  text-decoration: none;
  text-align: center;
  color: white;
  float:left;
  padding: 14px 25px;
  margin: 8px 10px;
  border: none;
  cursor: pointer;
  width: 200px;
}
.links > a:hover {
  opacity: 0.8;
}
h2 {
	color:red;
	
}
</style>
</head>
<body>
<br>
<h4><a href="home">Home</a></h4>
<h4><a href="logout">Logout</a></h4>
<table>
	<tr>
		<th>Name</th>
		<th>Balance</th>
		<th>Address</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Aadhar Card Number</th>
		<th>PAN Number</th>
		
		<c:if test="${sessionScope.user.userType == 'ADMIN' || sessionScope.user.userType == 'MANAGER' }">
		<th>Delete Account</th>
		<th>Update Account</th>
		</c:if>
		
		<c:if test="${sessionScope.user.userType == 'CLERK' }">
		<th>Transaction</th>
		</c:if>
		
	</tr>
	<c:forEach var="account" items="${allaccounts}">
	<tr>
		<td>${account.name}</td>
		<td><c:out value="${account.balance}"></c:out> </td>
		<td><c:out value="${account.address}"></c:out> </td>
		<td><c:out value="${account.phone}"></c:out> </td>
		<td><c:out value="${account.email}"></c:out> </td>
		<td><c:out value="${account.aadharNumber}"></c:out> </td>
		<td><c:out value="${account.panNumber}"></c:out> </td>
		
		<c:if test="${sessionScope.user.userType == 'ADMIN' || sessionScope.user.userType == 'MANAGER' }">
		<td><a href="deleteaccount?id=${account.accountId}">delete account</a></td>
		<td><a href="updateaccount?id=${account.accountId}">update account</a></td>
		</c:if>
		
		<c:if test="${sessionScope.user.userType == 'CLERK' }">
		<td><h4><a href="getalltransactions?id=${account.accountId}"> Get All Transactions</a></h4></td>
		</c:if>
	</tr>
	</c:forEach>
</table>


</body>
</html>