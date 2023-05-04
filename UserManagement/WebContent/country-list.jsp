<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.xadmin.usermanagement.model.Country"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Country Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: grey">
			

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Data-List </a></li>
					<li><a href="employeeregister.jsp" class="nav-link">Registration</a></li>
					<li><a href="login.jsp" class="nav-link">Login</a></li>
					
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center"> From Hero to Zero</h3>
			
			
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>2020</th>
						<th>2021</th>
						<th>2022</th>
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="country" items="${listCountry}">

						<tr>
							<td><c:out value="${country.name}" /></td>
							<td><c:out value="${country.$2020}" /></td>
							<td><c:out value="${country.$2021}" /></td>
							<td><c:out value="${country.$2022}" /></td>
			
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>