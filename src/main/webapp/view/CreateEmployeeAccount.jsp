<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
${msg}
 <body>
	<form:form method="post" modelAttribute="Employeemodel" action="SaveAccountDetails">
		<table>
			<tr>
			    <form:hidden path="employeeId"/>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>Male<form:radiobutton path="gender" value="m" /> &nbsp;
					Female <form:radiobutton path="gender" value="f" />
				</td>
			</tr>
			<tr>
				<td>Role in the Organisation:</td>
				<td><form:select path="role">
						<form:option value="" >--Select--</form:option>
						<form:option value="Admin">Admin</form:option>
						<form:option value="CaseWorker">CW(CaseWorker)</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Create"></td>
			</tr>
		</table>
	</form:form>
	<a href="./viewAllEmployee">ViewAllEmployee</a>
</body>
</html>