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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<title>Person Details</title>

<style>
label {
	display: inline-block;
	width: 650px;
	text-align: right;
}
</style>

</head>

<body>

	<h3 align="center" style="color: #6F9EC3">Person Details</h3>
	<br />

	<form:form method="POST" modelAttribute="person">
		<form:input type="hidden" path="personID" id="personID" />
		<table>
			<tr>
				<td style="padding-right: 10px">
					<label for="firstName">First Name : </label>
				</td>
				<td>
					${person.firstName}
					${person.middleInitial}
					${person.lastName}
				</td>
			</tr>
			<tr>
				<td><label for="birthDate">Birth Date : </label></td>
				<td>${person.birthDate}</td>
			</tr>

			<tr>
				<td><label for="ssn">SSN : </label></td>
				<td>${person.ssn}</td>
			</tr>

			<tr>
				<td><label for="city">City : </label></td>
				<td>${address.city}</td>
			</tr>

			<tr>
				<td><label for="state">State : </label></td>
				<td>${address.city}</td>
			</tr>

			<tr>
				<td><input type="submit" value="Update" onClick="/personList"
					style="position: relative; top: 25px; left: 95%;" /></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br />
	<h4 align="center">
		Go back to <a href="<c:url value='/personList' />"> Person List </a>
	</h4>
</body>
</html>