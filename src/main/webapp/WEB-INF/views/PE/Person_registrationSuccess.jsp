<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<script type="text/javascript"
	src="http://documentcloud.github.com/underscore/underscore-min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<title>Registration Confirmation Page</title>
</head>

<body>
	<br />
	<b style="align: center">${Person_registrationSuccess_message}</b>
	<br />
	<br />
	<h4 align="center">
		Go back to <a href="<c:url value='/personList' />"> Persons List </a>
	</h4>
</body>

</html>