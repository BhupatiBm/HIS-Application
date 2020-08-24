<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
${succMsg}
${errMsg}
<body>
<form:form action="unlockEmployeeAccount"  method="post" modelAttribute="unlockModel">
	<table>
		<tr>
			<td>Email:</td>
			<td><form:input path="emailId" readonly="true"/></td>
		</tr>
		<tr>
			<td>Temporary Password:</td>
			<td><form:password path="temporaryPassword" /></td>
		</tr>
		<tr>
			<td>New Password:</td>
			<td><form:password path="newPassword" /></td>
		</tr>
		<tr>
			<td>Confirm Password:</td>
			<td><form:password path="confirmPassword" /></td>
		</tr>
		<tr>
		<td><input type="submit"  value="Activate My Account"> 
		</tr>
	</table>
</form:form>
</body>
</html>