<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 <%@include file="pageLeft.jsp"%>
 <!doctype html>
<html>
<head>
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"	href="./resources/js/validator/formValidation.min.css"/>
<link rel="stylesheet"	href="./resources/css/login.css"/>
<link rel="stylesheet"	href="./resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="./resources/css/style.css">

   
</head>

<body>
<div ng-app="myapp" ng-controller="registrationController"> 
	<form ng-submit="registrationProcess()" id="registrationForm" >
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="background-color: #D1F2EB !important;">
			<a style="font color: black" href="#">Personal Detailsssss</a>
		</nav>
		<br>
		<div class="container">
		<div class="row">			
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="userName" class="form-control" name="userName" placeholder="User Name" ng-model="registrationform.userName"/>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="company" class="form-control" name="company" placeholder="Company Name" ng-model="registrationform.company"/>
					</div>
				</div>
			</div>
			
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="email" name="email" placeholder="Email" class="form-control" ng-model="registrationform.email"/>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="password" id="password" name="password" class="form-control" placeholder="Password" ng-model="registrationform.password"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="password" id="reenterpassword" name="reenterpassword" class="form-control" placeholder="Reenter Password" />
					</div>
				</div>
			</div>			
		</div>
		 <div style="color: red" id="errormsg" ng-show="errormsg">
		     Invalid User Details
		     </div>
        <button type="reset" class="btn-default pull-center" onclick="window.location.href='/QuizManager'">Cancel</button>
		<input type="submit" class="btn btn-info" name="register-submit" id="register-submit" tabindex="4"
			class="form-control btn btn-register" value="Register Now" 
			style="float: center;">
			</div>
	</form>
	
	
         <script src="<c:url value="./resources/js/angular/registrationProcess.js"/>" 	type="text/javascript"></script>
      
      
      <!-- JQuery libraries -->
<script src="<c:url value="./resources/js/jquery/jquery-2.1.4.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="./resources/js/jquery/jquery-ui.min.js"/>"	type="text/javascript"></script>
<script src="<c:url value="./resources/js/jquery/jquery.min.js"/>"	type="text/javascript"></script>

<!-- form validation libraries  -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/es6-shim/0.35.3/es6-shim.min.js"></script>
<script src="<c:url value="./resources/js/validator/formValidation.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="./resources/js/validator/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="./resources/js/validation.js"/>" type="text/javascript"></script>
 <script  src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 

      
</body>


</html>