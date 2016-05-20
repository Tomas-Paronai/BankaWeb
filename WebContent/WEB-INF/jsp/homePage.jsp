<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<spring:url value="/resources/css/homePage.css" var="homeStyle"/>
<link rel="stylesheet" type="text/css" href="${homeStyle}"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<spring:url value="/resources/js/navigation.js" var="navScript"/>
<script src="${navScript}"></script>
<spring:url value="/resources/js/load.js" var="loadScript"/>
<script src="${loadScript}"></script>

<spring:url value="/resources/img/operations/" var="picPath"/>
</head>

<body>
	<div id="header">
		<h2>Welcome ${client.name} !</h2>	
	</div>
	
	<div id="center">
		<ul class="tab">
			<li><a href="#" class="tablink" data="accounts">My accounts</a></li>
			<li><a href="#" class="tablink" data="cards">My cards</a></li>
			<li><a href="#" class="tablink" data="loans">My loans</a></li>
			<li><a href="#" class="tablink" data="operations">Operations</a></li>
		</ul>
		
		<div id="content-container">		
		<div id="accounts" class="tab-content" style="display: block;">
			<c:forEach items="${client.accounts}" var="account">
				<table class="tab-item">
					<tr>
						<td>Account number:</td>
						<td>${account.number}</td>
					</tr>
					<tr>
						<td>Balance:</td>
						<td>${account.balance} $</td>
					</tr>
				</table>
			</c:forEach>
		</div>
		
		<div id="cards" class="tab-content">
			<c:forEach items="${client.cards}" var="card">
				<table class="tab-item">
					<tr>
						<td>Account number:</td>
						<td>${card.accountID}</td>
					</tr>
					<tr>
						<td>Active:</td>
						<td>${card.block}</td>
					</tr>
				</table>
			</c:forEach>
		</div>
		
		<div id="loans" class="tab-content">
		<c:forEach items="${client.loans}" var="loan">
				<table class="tab-item">
					<tr>
						<td>Amount:</td>
						<td>${loan.amount} $</td>
					</tr>
					<tr>
						<td>Interest:</td>
						<td>${loan.interest} %</td>
					</tr>
					<tr>
						<td>Repaid amount:</td>
						<td>${loan.paid} $</td>
					</tr>
				</table>
			</c:forEach>
		</div>
		
		<div id="operations" class="tab-content">
			<ul id="op-options">
				<li><a href="#" class="trans-nav" data="new-transaction">Transaction</a></li>
				<li><a href="#" class="trans-nav" data="new-loan">Take loan</a></li>
				<li><a href="#" class="trans-nav" data="deactivate-card">Deactivate card</a></li>
				<li><a href="#" class="trans-nav" data="change-pass">Change password</a></li>
			</ul>
			
			<div id="operations-container">
				<div id="new-transaction" class="trans-content">
					TRANS				
				</div>				
				<div class="showcase" conn="new-transaction">
					<img src="${picPath}trans.jpg">	
				</div>
								
				<div id="new-loan" class="trans-content">
					LOANS						
				</div>
				<div class="showcase" conn="new-loan">
					<img src="${picPath}loans.jpg">
				</div>
				
				
				<div id="deactivate-card" class="trans-content">
					<!-- TODO <jsp:include page="forms/cardsForm.jsp"/>-->	
				</div>
				<div class="showcase" conn="deactivate-card">
					<img src="${picPath}cards.jpg">
				</div>				
				
				<div id="change-pass" class="trans-content">
					<jsp:include page="forms/newPassword.jsp"/>									
				</div>
				<div class="showcase" conn="change-pass">
					<img src="${picPath}passwords.jpg">
				</div>
				
			</div>
		</div>
	</div>
	</div>
	
	<div>
		<ul id="footer">
			<li><a>About</a></li>
			<li><a>FAQ</a></li>
			<li><a>Help/Support</a></li>
			<li><a href="indexLogin">Log out</a></li>	
		</ul>
	</div>
</body>

</html>