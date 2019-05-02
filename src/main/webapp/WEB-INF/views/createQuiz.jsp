<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="pageLeft.jsp"%>
<!doctype html>
<html>
<head>
</head>

<body>
<div ng-app="myapp" ng-controller="crateQuizController"> 
	<%-- <form action="/signupComplete" id="registrationForm" method="post"> --%>
	<form ng-submit="processUserDetails()" id="CreateExam"  class="form-horizontal" method="post">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark" style="background-color: #D1F2EB !important;">
			<a style="font color: black" href="#">Create Quiz</a>
		</nav>
		<br>
		<div class="container">
		<div class="row">			
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="description" class="form-control" name="description" placeholder="Exam Description" ng-model="CreateExam.description"/>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="question" class="form-control" name="question" placeholder="Enter Question" ng-model="CreateExam.question"/>
					</div>
				</div>
			</div>
			
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
					
					<select id="description" ng-model="CreateExam.correctAnswer" placeholder="Type of Question" id="correctAnswer"  class="form-control" name="correctAnswer">
					
					<option  value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
					<option value="D">D</option>
					</select>
 					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="a" name="a" class="form-control" placeholder="Option 1" ng-model="CreateExam.a"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="b" name="b" class="form-control" placeholder="Option 2"  ng-model="CreateExam.b"/>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="c" name="c" class="form-control" placeholder="Option 3" ng-model="CreateExam.c"/>
					</div>
				</div>
			</div>			
		</div>
		<div class="row">
		<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" id="d" name="d" class="form-control" placeholder="Option 4"  ng-model="CreateExam.d"/>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<div class="col-sm-12">
					
					<select id="description" ng-model="CreateExam.typeofQuestion" placeholder="Type of Question">
					<option  value="Text">Text</option>
					<option value="MCQ">MCQ</option>
					<option value="Boolean">Boolean</option>
					</select>
 					</div>
				</div>
			</div>	
			</div>
		 <div style="color: red" id="errormsg">
		     ${errormsg}
		     </div>
        <button type="reset" class="btn-default pull-center" onclick="window.location.href='./index'">Cancel</button>
		<input type="submit" class="btn btn-info" name="register-submit" id="register-submit" tabindex="4"
			class="form-control btn btn-register" value="Submit"  ng-click="createQuiz()" style="float: center;">
			</div>
	</form>
</body>


</html>