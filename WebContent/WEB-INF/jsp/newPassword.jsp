<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="changePassword" modelAttribute="passwordBean">
		<form:hidden path="clientId" value="${clientId}"/>
		<table>	
			<tr>
				<td>
					<form:label path="NewPassword">Password: </form:label>
				</td>
				<td>
					<form:password path="password"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="NewPasswordRe">Repeat: </form:label>
				</td>
				<td>
					<form:password path="passwordRe"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>