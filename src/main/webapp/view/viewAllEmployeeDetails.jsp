<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="./js/ajax.js"></script>
<body>
<p id="tbDetails"></p>
<a href="./createAccount">add new details</a>
<form:form method="get" modelAttribute="EmployeeRole" action="viewEmployeebyRole" id="form">
<tr>
	<td>Select Role:</td>
	<td> <form:select path="role">
		
			<form:option value="Admin">Admin</form:option>
			<form:option value="CaseWorker">CaseWorker</form:option>	
	</form:select> </td>
	</tr>
	

	<table border="1" style="color: green" id="userTable" >
	
		<thead>
			<tr>
				<th>Sl.No</th>
				<th>Employee_ID</th>
				<th>First_Name</th>
				<th>Last_Name</th>
				<th>Email_ID</th>
				<th>Gender</th>
				<th>Role</th>
				<th>Account_Status</th>
				<th>Delete_Status</th>
				<th >Options</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach  items="${allEmployeeDetails}" var="emp" varStatus="index">
		 		<tr style="color: black">
		 			<td>${index.count+1}</td>
		 			<td>${emp.employeeId}</td>
		 			<td>${emp.firstName}</td>
		 			<td>${emp.lastName}</td>
		 			<td>${emp.gender}</td>
		 			<td>${emp.emailId}</td>
		 			<td>${emp.role}</td>
		 			<td>${emp.accountStatus}</td>
		 			<td>${emp.isDeleted}</td>
		 			<td><a href="./editEmployeeAccount?eid=${emp.employeeId}">Edit</a>||

						<c:if test="${emp.isDeleted eq 'N'.charAt(0)}">
							<a href="./softDeleteAccount?eid=${emp.employeeId}"
								onclick="return deleteConfirm()">Delete</a>
						</c:if>
						 <c:if test="${emp.isDeleted eq 'Y'.charAt(0)}">
							<a href="./activeDeletedAccount?eid=${emp.employeeId}">Active</a>
						</c:if></td>
		 		</tr>
		 	</c:forEach>
		
	</table>
	</form:form>
</body>
</html>