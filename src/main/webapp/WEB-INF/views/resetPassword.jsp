<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="pageLeft.jsp" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Icon -->
    <div class="fadeIn first">
		<img src="<c:url value="\images\Usericon.png"/>" alt="" />
    </div>
    <!-- Login Form -->
    <form action="/saveNewpassword" method="post" id="saveform">
      <input type="text" id="login" class="fadeIn second" name="email"  readonly="readonly" value="${email}">
      <input type="text" id="password" class="fadeIn third" name="password" placeholder=" Password">
      <input type="text" id="reenterpassword" class="fadeIn third" name="reenterpassword" placeholder="Reenter Password">
      <br>
     <div style="color: red" id="reentermsg">
     </div><br>
      <div class="form-group" style="text-align: center;">
      <input type="button" class="fadeIn fourth" id="btn_sub" value="Submit">
      </div>
    </form>
  </div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	
	$("#btn_sub").click(function() {
		debugger;
		var password=$("#password").val();
		var reEnterpassword=$("#reenterpassword").val();
		if(password==reEnterpassword){
			$("#saveform").submit();
		}else{
			$("#reentermsg").html("Password does not match");
		}
   });
});
</script>
</html>