var app = angular.module('myapp', []);

	app.controller('loginController', function($scope, $http) {
		$scope.users = []
		$scope.userform = {
				email : "",
				password : ""
		};
	 
	$scope.loginProcess = function() {
		
		if(!angular.equals($scope.userform.email,"")){

			if(angular.equals($scope.userform.password,"")){
				console.log("Empty Password");

			}
		else{
		
		$http({
			 method : 'POST',
			 url : 'loginProcess',
			 data : angular.toJson($scope.userform),
			 headers : {
				 'Content-Type' : 'application/json'
				 }
		}).success( function (data) {
			window.location.href = ('./index');
		}).error(function(data, status, headers, config) {
			$("#errormsg").html("Username or Password inccorect");
	    });
		}
	}}
	}); 
	 