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
					<li><a href="register.jsp" class="nav-link">Registration</a></li>
					<li><a href="login.jsp" class="nav-link">Login</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="container col-md-5">
		<div class="card">			
			<form action="update" method="post" class="form-group">
    			<input type="hidden" name="id" value="${country.id}" />
    			<label for="name">Name:</label>
    			<input type="text" id="name" name="name" value="${country.name}"  class="form-control" required /><br />
    			<label for="$2020">2020:</label>
    			<input type="number" id="$2020" name="$2020" value="${country.$2020}" class="form-control" required /><br />
    			<label for="$2021">2021:</label>
    			<input type="number" id="$2021" name="$2021" value="${country.$2021}" class="form-control" required /><br />
    			<label for="$2022">2022:</label>
    			<input type="number" id="$2022" name="$2022" value="${country.$2022}" class="form-control" required /><br />
    			<input type="submit" value="Save" class ="btn btn-primary"/>
			</form>									
		</div>
	</div>
	
</body>
</html>