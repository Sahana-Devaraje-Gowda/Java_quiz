<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!doctype html>
<html>
<head>
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"	href="./resources/js/validator/formValidation.min.css"/>
<link rel="stylesheet"	href="./resources/css/login.css"/>
<link rel="stylesheet"	href="./resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="./resources/css/style.css">
 <script  src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
   <script src="<c:url value="./resources/js/angular/getExamDetails.js"/>" 	type="text/javascript"></script>
</head>
<body>
 <div ng-app="myapp" ng-controller="loginController"> 
<div class="wrapper fadeInDown">
  <div id="formContent" class="form-group">
    <div class="fadeIn first">
		<img src="./resources/images/Usericon.png" alt="" />
    </div>
    <!-- Login Form -->
<%--     <form action="${pageContext.request.contextPath}/login" id="loginForm" method="post" class="form-horizontal">
 --%>    
     <form ng-submit="processUserDetails()" id="loginForm"  class="form-horizontal" method="post">
    	<div class="form-group">
     	  <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email Address" ng-model="userform.email">
     	</div>
     	 
     	<div class="form-group">
      	  <input type="password" id="password" class="fadeIn third" name="password" placeholder=" Password" ng-model="userform.password">
		     <div style="color: red" id="errormsg">
		     ${errormsg}
		     </div>
        </div>
      
        
	    
      <input type="button" class="fadeIn fourth" ng-click="loginProcess()" value="Log In">
      <input type="button"  class="fadeIn fourth" value="SignUp" onclick="window.location.href='./registration'">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
     <a class="underlineHover" href="${pageContext.request.contextPath}/forgotpassword">Forgot Password?</a>
    </div>

  </div>
</div>
<div class="Rajesh Vanga">

</div>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header pt-n">
        
        <h3 class="font-21">Terms and Conditions</h3>
        <button type="button" class="close font-21" data-dismiss="modal">&times;</button>
      </div>
      <div class="modal-body">
        <p class="font-12">Last updated: March 20, 2019</p>
        <p>Please read these Terms and Conditions. </p>
		<p>Your access to and use of the Service is conditioned upon your acceptance.</p>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-primary g-bg-blue waves-effect" data-dismiss="modal">Close</button>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-primary g-bg-blue waves-effect" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
<div class="theme-bg"></div>
<!-- JQuery libraries -->
<script src="<c:url value="./resources/js/jquery/jquery-2.1.4.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="./resources/js/jquery/jquery.js"/>"	type="text/javascript"></script>
<script src="<c:url value="./resources/js/jquery/jquery-ui.min.js"/>"	type="text/javascript"></script>
<script src="<c:url value="./resources/js/jquery/jquery.min.js"/>"	type="text/javascript"></script>

<!-- form validation libraries  -->
<script	src="https://cdnjs.cloudflare.com/ajax/libs/es6-shim/0.35.3/es6-shim.min.js"></script>
<script src="<c:url value="./resources/js/validator/formValidation.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="./resources/js/validator/bootstrap.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="./resources/js/validation.js"/>" type="text/javascript"></script>
 <script  src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
 <script src="<c:url value="./resources/js/angular/loginProcess.js"/>" 	type="text/javascript"></script>
</body>
</html>