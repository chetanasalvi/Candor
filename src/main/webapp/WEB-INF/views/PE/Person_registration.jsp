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

<title>Person Registration</title>
<style>
label {
	display: inline-block;
	width: 600px;
	text-align: right;
}
</style>
</head>

<body>
	<h3 align="center" style="color: #6F9EC3">
		<c:choose>
			<c:when test="${edit}">
				Update Person Form
			</c:when>
			<c:otherwise>
				Person Registration Form
			</c:otherwise>
		</c:choose>
	</h3>
	<br />

	<form action="" method="post">
		<spring:bind path="person.firstName">
			<label for="firstName">First Name : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="person.middleInitial">
			<label for="middleInitial">Middle Initial : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="person.lastName">
			<label for="lastName">Last Name : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="person.birthDate">
			<label for="birthDate">Birth Date : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="person.ssn">
			<label for="ssn">SSN : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="address.addressLineOne">
			<label for="addressLineOne">House No : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="address.addressLineTwo">
			<label for="addressLineTwo">Apt Name : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="address.addressLineThree">
			<label for="addressLineThree">Street Name : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="address.city">
			<label for="city">City : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="address.state">
			<label for="state">State : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="address.zipCode">
			<label for="zipCode">Zipcode : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<spring:bind path="address.status">
			<label for="status">Status : </label>
			<input type="text" name="${status.expression}"
				value="${status.value}">
			<span class="fieldError" style="color: red">${status.errorMessage}</span>
			<br />
		</spring:bind>

		<c:choose>
			<c:when test="${edit}">
				<input type="submit" value="Update"
					style="position: relative; top: 25px; left: 50%;" />
			</c:when>
			<c:otherwise>
				<input type="submit" value="Register"
					style="position: relative; top: 25px; left: 50%;" />
			</c:otherwise>
		</c:choose>
	</form>

	<br />
	<br />
	<h4 align="center">
		Go back to <a href="<c:url value='/personList' />"> Person List </a>
	</h4>
</body>
</html>