<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan</title>

<spring:url value="/resources/js/loan.js" var="loanScript"/>
<script src="${loanScript}"></script>

</head>
<body>
	<div>Return value of a taken loan is 130%!</div>
	<form:form action="takeLoan" method="POST" modelAttribute="loanBean">
		<table>
			<tr>
				<td>Choose account:</td>
				<td>
					<form:select path="account" required="true">
						<option>Choose..</option>
						<form:options items="${client.accounts}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td>
					<form:input id="amount" path="amount" required="true"/>
				</td>
			</tr>
			<tr>
				<td>Interest: </td>
				<td>
					<form:radiobutton path="interest" value="0.1" selected="true"/>10%
					<form:radiobutton path="interest" value="0.2"/>20%
					<form:radiobutton path="interest" value="0.3"/>30%
					<form:radiobutton path="interest" value="0.4"/>40%
					<form:radiobutton path="interest" value="0.5"/>50%
				</td>
			</tr>
			<tr>
				<td>Total repay:</td>
				<td id="repay"></td>
			</tr>
			<tr>
				<td>Months to repay:</td>
				<td id="months"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>