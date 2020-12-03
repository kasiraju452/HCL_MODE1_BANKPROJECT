<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HCL BANKING APPLICATION</title>
<style type="text/css">
a {
	align-content: center;
}
</style>
</head>
<body>
	<marquee>
		<h3 style="color: aqua;">
			<i>HCL ONLINE BANKING APPLICATION</i>
		</h3>
	</marquee>
 <h2>Hi, ${sessionScope.user.userType}</h2>  <br>
<c:if test="${sessionScope.user.userType == 'ADMIN'}">
	Hello ADMIN ..
	<a href="showallaccounts">Show All Accounts</a><br>
	<a href="showallusers">Show All Users</a><br>
	<a href="addaccount"> Create New  Account </a> <br>
	<a href="adduser">  New add  User </a> <br>
	<a href="transfer"> Transfer Money</a> <br>
	<a href="withdraw"> Withdraw Money</a> <br>
	<a href="deposit"> Deposit Money </a> <br>
	<a href="logout"> Logout </a>
	
</c:if>

<c:if test="${sessionScope.user.userType == 'MANAGER'}">
	Hello MANAGER ..
	<a href="showallaccounts">Show All Accounts</a><br>
	<a href="showallusers">Show All Users</a><br>
	<a href="transfer"> Transfer Money</a> <br>
	<a href="withdraw"> Withdraw Money</a> <br>
	<a href="deposit"> Deposit Money </a> <br>
	<a href="logout"> Logout </a>
</c:if> 

<c:if test="${sessionScope.user.userType == 'CLERK'}">
	Hello CLERK ..
	<a href="showallaccounts">Show All Accounts</a><br>
	<a href="transfer"> Transfer Money</a> <br>
	<a href="withdraw"> Withdraw Money</a> <br>
	<a href="deposit"> Deposit Money </a> <br>
	<a href="logout"> Logout </a>
</c:if>

</body>
</html>