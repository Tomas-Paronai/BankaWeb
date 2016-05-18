<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New password form</title>

<spring:url value="/resources/css/homePage.css" var="passStyle"/>
<link rel="stylesheet" type="text/css" href="${passStyle}"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<spring:url value="/resources/js/validate.js" var="valScript"/>
<script src="${valScript}"></script>

</head>
<body>
	<div id="passError" style="{color:red;}"></div>
	<form:form modelAttribute="passwordBean" action="changePassword" method="post" onsubmit="return validatePassword();">
		<c:if test="${!empty client.stringId}">
			<form:hidden path="id" value="${client.stringId}"/>
		</c:if>
		<table>
			<tr class="form-row">
				<td>
					<label>Password: </label>
				</td>
				<td>
					<form:password id="password" path="password"/>
				</td>
			</tr>
			<tr class="form-row">
				<td>
					<label>Repeat: </label>
				</td>
				<td>
					<form:password id="passwordRe" path="passwordRe"/>
				</td>
			</tr>
			<tr class="form-row">
				<td colspan="2">
					<input type="submit" value="Submit">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>