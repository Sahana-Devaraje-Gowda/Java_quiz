var app = angular.module('myapp', []);

	app.controller('registrationController', function($scope, $http) {
		$scope.users = []
		$scope.registrationform = {
				userName : "",
				email : "",
				password : "",
		};
		$scope.errormsg=false;	
	$scope.registrationProcess = function() {
		
		
		if(angular.equals($scope.registrationform.email,"")&(angular.equals($scope.registrationform.email,""))&(angular.equals($scope.registrationform.password,"")) ){
			console.log("Empty form");

		}else{
		$http({
			 method : 'POST',
			 url : 'signupComplete',
			 data : angular.toJson($scope.registrationform),
			 headers : {
				 'Content-Type' : 'application/json'
				 }
		}).success( function (data) {
			window.location.href = ('./login');
		}, function errorCallback(response) {
			$scope.errormsg=true;

		}).catch(function (reason) {
			
			$scope.errormsg=true;		   });
		
		}
	};
	
	}); 
	 