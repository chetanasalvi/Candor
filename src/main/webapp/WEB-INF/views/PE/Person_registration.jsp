<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

<title>Person Registration Form</title>

<style>
.error {
	color: #ff0000;
}

label {
	display: inline-block;
	width: 140px;
	text-align: right;
}
</style>

</head>

<body>

	<h2>
		<c:choose>
			<c:when test="${edit}">
				Update Person Form
			</c:when>
			<c:otherwise>
				Person Registration Form
			</c:otherwise>
		</c:choose>
	</h2>
	<spring:hasBindErrors name="person">
		<h2>Errors</h2>
		<div class="formerror">
			<ul>
				<c:forEach items="${errors.fieldErrors}" var="error">
					<div class="error">
						Field Error: ${error.field}. ErrorCode: ${error} <br />
					</div>
					<br />
				</c:forEach>
			</ul>
		</div>
	</spring:hasBindErrors>

	<form action="savePerson.do" method="post">
		<spring:bind path="person.firstName">
			<label for="firstName">First Name : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="firstName" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="person.middleInitial">
			<label for="middleInitial">Middle Initial : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="middleInitial" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="person.lastName">
			<label for="lastName">Last Name : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="lastName" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="person.birthDate">
			<label for="birthDate">Birth Date : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="birthDate" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="person.ssn">
			<label for="ssn">SSN : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="ssn" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="address.addressLineOne">
			<label for="addressLineOne">House No : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="addressLineOne" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="address.addressLineTwo">
			<label for="addressLineTwo">Apt Name : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="addressLineTwo" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="address.addressLineThree">
			<label for="addressLineThree">Street Name : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="addressLineThree" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="address.city">
			<label for="city">City : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="city" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="address.state">
			<label for="state">State : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="state" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="address.zipCode">
			<label for="zipCode">Zipcode : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="zipCode" cssClass="error" />
			<br />
		</spring:bind>

		<spring:bind path="address.status">
			<label for="status">Status : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<form:errors path="status" cssClass="error" />
			<br />
		</spring:bind>

		<input type="submit" value="Register"
			style="position: relative; top: 25px; left: 15%;" />
	</form>


	<%-- <form:form method="POST" modelAttribute="person">
		<form:input type="hidden" path="personID" id="personID" />
		<table>
			<tr>
				<td><label for="firstName">First Name: </label></td>
				<td><form:input path="firstName" id="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="middleInitial">Middle Initial: </label></td>
				<td><form:input path="middleInitial" id="middleInitial" /></td>
				<td><form:errors path="middleInitial" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="lastName">Last Name: </label></td>
				<td><form:input path="lastName" id="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><label for="birthDate">Birth Date: </label></td>
				<td><form:input path="birthDate" id="birthDate" /></td>
				<td><form:errors path="birthDate" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="ssn">SSN: </label></td>
				<td><form:input path="ssn" id="ssn" /></td>
				<td><form:errors path="ssn" cssClass="error" /></td>
			</tr>
			
			
			<tr>
				<td><label for="addressID">Address ID: </label></td>
				<td><form:input path="addressID" id="addressID" /></td>
				<td><form:errors path="addressID" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form> --%>
	<br />
	<br /> Go back to
	<a href="<c:url value='/personList' />"> Person List </a>
</body>
</html>