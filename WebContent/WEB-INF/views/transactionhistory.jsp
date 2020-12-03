<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h4><a href="home">Home</a></h4><br/>
<h4><a href="logout">Logout</a></h4>
<table>
	<tr>
		<th>Transaction Info</th>
		<th>Date and Time</th>
		<th>Amount</th>
		<th>Transaction Type</th>
	</tr>
	<c:forEach var="transaction" items="${transactionHistory}">
	<tr>
		<td>${transaction.txInfo}</td>
		<td><c:out value="${transaction.timestamp}"></c:out> </td>
		<td><c:out value="${transaction.amount}"></c:out> </td>
		<td><c:out value="${transaction.txType}"></c:out> </td>
		
	</tr>
	</c:forEach>
</table>

</body>
</html>