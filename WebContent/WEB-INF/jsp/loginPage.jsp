<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IT bank SOVY login</title>

<spring:url value="/resources/css/homePage.css" var="homeStyle"/>
<link rel="stylesheet" type="text/css" href="${homeStyle}"/>

</head>

<body>	
	<form:form id="login" action="loginClient" method="post" modelAttribute="loginBean">
		<h1>Client login</h1>
		<div id="error-message">
			<c:if test="${!empty error}">
				${error}
			</c:if>
		</div>
		<table>
			<tr>
				<td>
					<form:label path="Username">Username: </form:label>
				</td>
				<td>
					<form:input id="username" path="username" name="username"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="Password">Password: </form:label>
				</td>
				<td>
					<form:password id="password" path="password" name="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="Submit" value="Submit"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>

</html>