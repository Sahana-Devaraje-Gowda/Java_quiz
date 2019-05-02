var app = angular.module('myapp', []);

	app.controller('myappcontroller', function($scope, $http) {
		$scope.exams = []
		$scope.examsform = {
			examId : "",
			description : ""
		};
		getUserDetails();
		function getUserDetails() {
			$http({
				method : 'GET',
				url : 'ExamDetails'
			}).then(function successCallback(response) {
				$scope.exams = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}
		
		

	 
	$scope.getQuestionsById = function(exam) {
		$http({
			 method : 'POST',
			 url : 'startExam',
			 data : angular.toJson(exam),
			 headers : {
				 'Content-Type' : 'application/json'
				 }
		}).success( function (data) {
			window.location.href = ('./startExam');
		});
	 
	};
	
	$scope.login = function() {
		window.location.href = ('./login');
	};
	$scope.Logout = function() {
		window.location.href = ('./logout');
	};
	$scope.registration = function() {
		window.location.href = ('./registration');
	};
	
	$scope.forgotpassword = function() {
		window.location.href = ('./forgotpassword');
	};
	$scope.CreateQuiz = function() {
		window.location.href = ('./createQuiz');
	};
	}); 
	 