<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src="https://code.angularjs.org/1.4.5/angular-route.js"></script>


<link rel="stylesheet" href="./resources/css/quizPlay.css">
<script src="<c:url value="./resources/js/angular/quizPlay.js"/>"
	type="text/javascript"></script>
</head>
<body>

	<div ng-app="myApp" ng-controller="quizPlayController" class="quiz">
		<div id="formid">
			<div id="form" style="display: inline;">
				<div class="container">
					<div class="survey-header">

						<p class="survey-question" ng-model="question">{{questions.question}}<br>
						</p>
						
						
					</div>

						<div class="loader" ng-show="loader"></div>



					<div class="survey-body">

							<div  class="col-lg-12 col-sm-12 col-xs-12 alert alert-success" ng-show="successMessagebool">
				             <div class="col-sm-6">
								<div class="form-group">
									<div class="col-sm-12">
										<input type="text" ng-model="options" id="question" class="form-control" name="question" placeholder="Enter answer" />
									</div></div></div></div>
									<div class="booleans" ng-show="booleansradiobuttons">
                                   <div class="list">
								<input type="radio" ng-model="options" value="{{questions.a}}">	<div class="options">true</div>
								<div class="list"><input type="radio" ng-model="options" value="{{questions.b}}"><div class="options">false</div>
								
							</div>
							</div></div>
							

						<div class="choices" ng-show="radiobuttons">
							<div class="list">
								<input type="radio" ng-model="options" value="{{questions.a}}">
								<div class="options">{{questions.a}}</div>
							</div>
							<div class="list">
								<input type="radio" ng-model="options" value="{{questions.b}}">
								<div class="options">{{questions.b}}</div>
							</div>
							<div class="list">
								<input type="radio" ng-model="options" value="{{ questions.c}}">
								<div class="options">{{questions.c}}</div>
							</div>
							<div class="list">
								<input type="radio" ng-model="options" value="{{ questions.d}}">
								<div class="options">{{questions.d}}</div>
								<input type="hidden" ng-model="questions.qid"
									value="{{questions.qid}}">
							</div>
						</div>

						<div class="survey-footer">
							<div class="nav-buttons"></div>
							<div class="modal-footer">
								<button type="button"
									class="btn btn-primary g-bg-blue waves-effect"
									data-dismiss="modal"
									ng-click="getQuestionsById(questions.qid,options)">Next
									Questions</button>
							</div>
						</div>


					</div>
				</div>
			</div>
			<button type="button" class="btn btn-primary g-bg-blue waves-effect"
				data-dismiss="modal" ng-click="submitExam()" id="btnsubmit">Submit</button>
		</div>
		<button type="button" id="startExam"
			class="btn btn-primary g-bg-blue waves-effect" data-dismiss="modal"
			ng-click="getQuestionsById(0,options)">Start</button>
	</div>
	<!-- JQuery libraries -->
	<script
		src="<c:url value="./resources/js/jquery/jquery-2.1.4.min.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value="./resources/js/jquery/jquery.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value="./resources/js/jquery/jquery-ui.min.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value="./resources/js/jquery/jquery.min.js"/>"
		type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$("#formid").hide();

			$("#startExam").click(function() {
				$("#formid").show();
				$("#startExam").hide();

			});

		});
	</script>
	
	<style>
	input[type=text] ,input[type=password]{
  background-color: #f6f6f6;
  border: none;
  color: #0d0d0d;
  padding: 15px 32px; 
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  width: 85%;
  border: 2px solid #f6f6f6;
  -webkit-transition: all 0.5s ease-in-out;
  -moz-transition: all 0.5s ease-in-out;
  -ms-transition: all 0.5s ease-in-out;
  -o-transition: all 0.5s ease-in-out;
  transition: all 0.5s ease-in-out;
  -webkit-border-radius: 5px 5px 5px 5px;
  border-radius: 5px 5px 5px 5px;
}


input[type=text],input[type=password]:placeholder {
  color: #cccccc;
}
	
	</style>
</body>
</html>