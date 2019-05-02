<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <%@include file="pageLeft.jsp"%> --%>
<!doctype html>
<html>
<head>
     <script  src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../resources/css/playQuiz.css">
</head>
<body>
<h1>Quiz on Important Facts</h1>

 
   <div ng-app="myApp" ng-controller="MyController">
    <button type="button" ng-click="getItems()">Get Items</button>
    <ul>
       <li ng-repeat="item in items">{{ item.qid }}</li>
        <li ng-repeat="item in items">{{ item.question }}</li>
    </ul>
     <li ng-repeat="answer in answers">{{ item.qid }}</li>
     <input type="radio" ng-model="answer" value={{ answer.answers }}>{{ answer.a }} 
</div>
 
 
<button id="previous">Previous Question</button>
<button id="next">Next Question</button>
<button id="submit">Submit Quiz</button>
<div id="results"></div>
 <script src="<c:url value="../resources/js/angular/playQuiz.js"/>" 	type="text/javascript"></script>
</body>
</html>