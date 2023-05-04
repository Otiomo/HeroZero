

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Data List</a></li>
					<li><a href="employeeregister.jsp" class="nav-link">Registration</a></li>
					<li><a href="login.jsp" class="nav-link">Login</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<c:if test="${country != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${country == null}">
					<form action="insert" method="post">
				</c:if>

				

				<c:if test="${country != null}">
					<input type="hidden" name="id" value="<c:out value='${country.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Country</label> <input type="text"
						value="<c:out value='${country.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>2022</label> <input type="text"
						value="<c:out value='${country.$2022}' />" class="form-control"
						name="$2022">
				</fieldset>

				<fieldset class="form-group">
					<label>2021</label> <input type="text"
						value="<c:out value='${country.$2021}' />" class="form-control"
						name="$2021">
				</fieldset>
				<fieldset class="form-group">
					<label>2020</label> <input type="text"
						value="<c:out value='${country.$2020}' />" class="form-control"
						name="$2020">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				
			
			
			</div>
			
		</div>
	
</body>
</html>