<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Connvertex-Candor</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>
</head>

<body>
	<h3 align="center" style="color: #6F9EC3">List of Persons</h3>
	<table align="center" border="1">
		<tr>
			<td width="150" align="center">FIRST NAME</td>
			<td width="50" align="center">MI</td>
			<td width="150" align="center">LAST NAME</td>
			<td width="150" align="center">Birth Date</td>
			<td width="150" align="center">SSN</td>
			<td width="150" align="center">ADDRESS ID</td>
			<td width="150" align="center">Action</td>
		</tr>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td>${person.firstName}</td>
				<td>${person.middleInitial}</td>
				<td>${person.lastName}</td>
				<td>${person.birthDate}</td>
				<td><a href="<c:url value='/viewPerson-${person.ssn}' />">${person.ssn}</a></td>
				<td>${person.addressID}</td>
				<td><a href="<c:url value='/deletePerson-${person.ssn}' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<h4 align="center">
		<a href="<c:url value='/personRegistration' />">Add New Person</a>
	</h4>
</body>
</html>