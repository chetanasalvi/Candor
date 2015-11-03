<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html ng-app>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>

	<script type="text/javascript"
		src="http://documentcloud.github.com/underscore/underscore-min.js"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

	<title>Person Registration Form</title>
	
	<style>
		.error {
			color: #ff0000;
		}
	</style>

</head>

<body>

	<h2>Person Details</h2>

	<form:form method="POST" modelAttribute="person">
		<form:input type="hidden" path="personID" id="personID" />
		<table>
			<tr>
				<td>Full Name: </td>
				<td>${person.firstName} ${person.middleInitial} ${person.lastName}</td>
			</tr>
			<tr>
				<td>Birth Date: </td>
				<td>${person.birthDate}</td>
			</tr>

			<tr>
				<td>SSN: </td>
				<td>${person.ssn}</td>
			</tr>
			
			<tr>
				<td>Address: </td>
				<td>${person.addressID}</td>
			</tr>

			<tr>
				<td colspan="3">
					<a href="<c:url value='/editPerson-${person.ssn}' />">Update</a>
				</td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Go back to
	<a href="<c:url value='/personList' />"> Person List </a>
</body>
</html>