var app = angular.module('myapp', []);
app.controller('crateQuizController', function($scope, $http) {

	$scope.names = []
	$scope.CreateExam = {
		description : "",
		typeofQuestion : "",
		question : "",
		correctAnswer : "",
		a : "",
		b : "",
		c : "",
		d : ""
	};

	
	

	$scope.createQuiz = function() {
		$http({
			method : 'POST',
			url : 'createQuiz',
			data : angular.toJson($scope.CreateExam),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(data) {
			$scope.names = data
			if (confirm("Do you Want add one more Question in ")) {
				window.location.href = ('./createQuiz');
			} else {
				$http({
					method : 'GET',
					url : 'invalidsession',
					headers : {
						'Accept' : 'application/json',
						'Content' : 'application/json'
					}
				}).success(function(data) {

				}, function errorCallback(response) {
				});
				window.location.href = ('./index');

				$scope.isDisabled = false;
			}
		}, function errorCallback(response) {
		});

	};

});