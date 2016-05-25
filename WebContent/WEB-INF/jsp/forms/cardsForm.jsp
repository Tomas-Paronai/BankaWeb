<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<spring:url value="/resources/css/homePage.css" var="homeStyle"/>
<link rel="stylesheet" type="text/css" href="${homeStyle}"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<spring:url value="/resources/js/navigation.js" var="navScript"/>
<script src="${navScript}"></script>

<script src="http://malsup.github.com/jquery.form.js"></script> 
<spring:url value="/resources/js/validate.js" var="valScript"/>
<script src="${valScript}"></script>

</head>
<body>
	<c:if test="${!empty client.cards}">	
	<form:form id="deactivate-card-form" method="post" action="deactivateCard" modelAttribute="cardBean">
		<form:select path="card" items="${client.activeCards}">
		</form:select>
		<input type="submit" value="Continue">
	</form:form>	
	</c:if>
</body>
</html>