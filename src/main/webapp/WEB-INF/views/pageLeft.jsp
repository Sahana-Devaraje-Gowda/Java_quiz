<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"	href="./resources/js/validator/formValidation.min.css"/>
<link rel="stylesheet"	href="./resources/css/login.css"/>
<link rel="stylesheet"	href="./resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="./resources/css/style.css">

<link rel="stylesheet" href="./resources/css/playQuiz.css">

<style>
.help-block{
	color:red;
	width: 100%;
    display: block;
}
</style>
</head>

<body>
 
<!-- JQuery libraries -->
<script src="<c:url value="./resources/js/jquery/jquery-2.1.4.min.js"/>" type="text/javascript"></script>
<%-- <script src="<c:url value="./resources/js/jquery/jquery.js"/>"	type="text/javascript"></script>
 --%>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script src="<c:url value="./resources/js/jquery/jquery-ui.min.js"/>"	type="text/javascript"></script>
<script src="<c:url value="./resources/js/jquery/jquery.min.js"/>"	type="text/javascript"></script>
<!-- form validation libraries  -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/es6-shim/0.35.3/es6-shim.min.js"></script>
<script src="<c:url value="./resources/js/validator/formValidation.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="./resources/js/validator/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="./resources/js/validation.js"/>" type="text/javascript"></script>
 <script  src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<%--  <script src="<c:url value="./resources/js/angular/playQuiz.js"/>" 	type="text/javascript"></script>
 --%> <script src="<c:url value="./resources/js/angular/loginProcess.js"/>" 	type="text/javascript"></script>
 <script src="<c:url value="./resources/js/angular/registrationProcess.js"/>" 	type="text/javascript"></script>
 <script src="<c:url value="./resources/js/angular/createQuiz.js"/>" 	type="text/javascript"></script>
</body>
</html>