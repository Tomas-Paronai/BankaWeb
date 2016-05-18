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
	<div id="login-container">
	<div id="error-message">
			<c:if test="${!empty error}">
				${error}
			</c:if>
		</div>
	<form:form action="sendEmail" modelAttribute="emailBean" method="post">
		<form:label path="Email">Email: </form:label>
		<form:input path="email"/><br>
		<input type="submit" value="Send"/>
	</form:form>
	</div>
</body>

</html>