<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html>
    <meta charset ="utf-8">
    <meta name ="viewport" content="width=device-width, intial-scale=1">
    <title>Custom Coding</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
     <link rel="stylesheet" href="./resources/css/style.css">
     <link href="./resources/css/style.css" rel="stylesheet">
     <script  src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="<c:url value="./resources/js/angular/getExamDetails.js"/>" type="text/javascript"></script>
   </head>
    <body>
                <div ng-app="myapp" ng-controller="myappcontroller">
    
        <header>
            <h2 href="#">Quiz Manager</h2>
            <nav>
            <c:if test="${username!=null}">
             <p> ${username}</p>
               <a ng-click="CreateQuiz()" >Create Quiz</a>
              <a ng-click="Logout()" >Logout</a>
              
            </c:if>
            <c:if test="${username==null}">
                 <a ng-click="login()" >SignIn</a> 
                <li>
                <a ng-click="registration()" >SignUp</a> 
                 </li>
                <li><a href="#">Help</a> </li>
            
                        </c:if></nav>
            </header>
            <section class="hero">
            <div class="background-image" style="background-image: <img src="./resources/images/Usericon.png" />"></div>
                <div class="hero-content-area">
                <h1>Quiz Manager</h1>
                
                 <div style="display: none;"> <h3 ng-repeat="exam in exams">  <a href="#">{{ exam.examId }}</a></h3></div>
                   <h3 ng-repeat="exam in exams"> 
                <a ng-click="getQuestionsById(exam)" >{{ exam.description }}</a> 
                </h3>
                
                </div> 
                
            </section>
            </div> 

	<footer>
		<ul>
			<li><a href="#"><i class="fa fa-twitter-square"></i></a></li>
			<li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
			<li><a href="#"><i class="fa fa-snapchat-square"></i></a></li>
			<li><a href="#"><i class="fa fa-pinterest-square"></i></a></li>
			<li><a href="#"><i class="fa fa-github-square"></i></a></li>
		</ul>
		<p>Made by Sahana Devraj </p>
	</footer>
        
    </body>
</html>