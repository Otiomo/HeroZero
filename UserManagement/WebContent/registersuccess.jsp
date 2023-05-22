<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="com.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
					class="nav-link">Data-List</a></li>
					<li><a href="register.jsp" class="nav-link">Registration</a></li>
					<li><a href="login.jsp" class="nav-link">Login</a></li>
			</ul>
		</nav>
	</header>
<body>
<div style="text-align:center">  
 <h1 >User successfully registered!</h1>

 <a href="<%=request.getContextPath()%>/list" class="btn btn-success">List Data</a>
 <a href="login.jsp" class="btn btn-success">Add Data</a>
 
</div>
</body>
</html>