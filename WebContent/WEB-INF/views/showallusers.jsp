<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show all users</title>
<style type="text/css">
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
<h4><a href="home">Home</a></h4>
<h4><a href="logout">Logout</a></h4>
<table>
	<tr>

		<th>Username</th>
		<th>User Role</th>
		<th>Address</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Delete user</th>
		<th>Update user</th>
		
	</tr>
	<c:forEach var="user" items="${allusers}">
	
	<tr>
		<td>${user.username}</td>
		<td><c:out value="${user.userType}"></c:out> </td>
		<td><c:out value="${user.address}"></c:out> </td>
		<td><c:out value="${user.phone}"></c:out> </td>
		<td><c:out value="${user.email}"></c:out> </td>
		<td><a href="deleteuser?id=${user.uid}">delete user</a></td>
		<td><a href="updateuser?id=${user.uid}">update user</a></td>
		
	</tr>
	</c:forEach>
</table>
</body>
</html>