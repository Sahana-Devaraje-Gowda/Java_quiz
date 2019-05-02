<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="pageLeft.jsp"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent"><br><br><br><br>
    <div class="fadeIn first">
				<img src="<c:url value="./resources/images/lock.png"/>" alt="" />
    </div>
          <p>You can reset your password here.</p>
    <br>
      <input type="text" id="email" class="fadeIn second" name="email" placeholder="Email Address">
       <input type="text" id="otp" class="fadeIn second" name="otp" placeholder="Enter OTP here" style="display: none;">
    <div id="setPassword" style="display: none;">
      <input type="text" id="password" class="fadeIn third" name="password" placeholder=" Password">
            <input type="text" id="reenterpassword" class="fadeIn third" name="reenterpassword" placeholder="Reenter Password">
     </div>
      <br>
      <br>
      <div style="color: red;" id="errorMsg"></div>
      <br>
             <div class="form-group" style="text-align: center;">
             <span id="wrongOTP" style="color: red"></span>
     </div>
      <input type="button" class="fadeIn fourth" id="sendPassword" value="Send My Password">
      
       <input type="button" class="fadeIn fourth" id="otpSubmit" value="Submit" style="display: none;">
         <input type="button" class="fadeIn fourth" id="newpasswordbtn" value="Submit" style="display: none;">
       
      
<br><br>
  </div>
</div>
</body>
<script type="text/javascript">

$(document).ready(function() {
	
	
	$("#newpasswordbtn").click(function() {
		debugger;
		var password1=$("#password").val();
		var email1=$("#email").val();
		var reenterPassword=$("#reenterpassword").val();
		if(password1==reenterPassword){
			var formData = {
					email : email1,
					password : password1,

				}
			$.ajax({
				type : "POST",
				url : ("./saveNewPassword"),
				dataType : 'json',
				data : JSON.stringify(formData),
				contentType : "application/json;charset=UTF-8",
				xhrFields : {
					withCredentials : true
				},success : function(data) {
					 window.location.href = "./login";
				},
				error : function(xhr, status, error) {
					alert(error,status);
					 window.location.href = "./login";				},
				});
				}else{
			$("#errorMsg").html("Password does not match");
		}
	
	});
	$("#sendPassword").click(function() {
		debugger;
var email=$("#email").val();

		$.ajax({
			type : "POST",
			url : ("./resetPassword"),
			dataType : 'json',
			data : email,
			contentType : "application/json;charset=UTF-8",
			xhrFields : {
				withCredentials : true
			},
			success : function(data) {
				$("#otp").show();
				$("#otpSubmit").show();
				$("#sendPassword").hide();

				$("#otpSubmit").click(function() {
					var otp=$("#otp").val();
         if(data==otp){
			$("#otp").hide();
			$("#setPassword").show();
			$("#otpSubmit").hide();
			$("#newpasswordbtn").show();
			

         }else{
        	 $("#errorMsg").html("Incorrect OTP");
         }
				});

			},
			error : function(xhr, status, error) {
				$("#errorMsg").html("Email Not registerd with us.!!!!");

			},

	});
	});
	
	
	
});

</script>
</html>