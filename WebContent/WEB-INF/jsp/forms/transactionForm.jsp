<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body>
	<form:form action="transaction" modelAttribute="transactionBean" method="POST">
		<table>
			<tr>
				<td>Choose account: </td>
				<td>
					<form:select path="account" placeholder="SELECT ACCOUNT" required="true">
						<option>Choose..</option>
						<form:options items="${client.accounts}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Account number:</td>
				<td>
					<form:input path="number" required="true"/>
				</td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td>
					<form:input path="amount" required="true"/>
				</td>
			</tr>
			<tr>
				<td>Do I want to get notified on recieve?</td>
				<td><form:checkbox path="notify"/>Yes</td>
			</tr>
		</table>
	</form:form>
</body>
</html>