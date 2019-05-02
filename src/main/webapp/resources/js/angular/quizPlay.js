var myApp = angular.module('myApp', []);
myApp.controller('quizPlayController', function($scope, $http) {
	
	$scope.questions = []
	
	$scope.questionsfrom = {
			qid : "",
			question :"",
			a : ""
		};
	//response.data.question
		 $scope.loader = false;

	$scope.getQuestionsById = function (id,options){
	$http({
	     method: 'POST',
	     url: 'getQuestionsbyID/'+id+'/'+options,
	     data : angular.toJson(id,options),
		 'Content-Type' : 'application/json'
	  })
	    .then(function successCallback(response) {
	    	
	    	if(response.data.questiondescrption=='Text'){
	    		$scope.questions.qid=response.data.qid;
	    		 $scope. questions.question=response.data.question;
	    		 $scope.options = "";
	    		 $scope.successMessagebool = true;
	    		 $scope.radiobuttons = false;
	    		 $scope.booleansradiobuttons = false;
	    	}
	    	else if(response.data.questiondescrption=='Boolean'){
	    		 $scope.booleansradiobuttons = true;
	    		 $scope.successMessagebool = false;
	    		 $scope.radiobuttons = false;
		    	$scope.questions.qid=response.data.qid;
		    	 $scope. questions.question=response.data.question;
			      $scope.questions.a= response.data.answers.a;
			      $scope.questions.b= response.data.answers.b;
	    	}
	    	else{
	    		 $scope.radiobuttons = true;
	    		 $scope.successMessagebool = false;
	    		 $scope.booleansradiobuttons = false;
	        $scope.questions = response.data;
	        $scope.questions.qid=response.data.qid;
	        $scope. questions.question=response.data.question;
	        $scope.questions.a= response.data.answers.a;
	        $scope.questions.b= response.data.answers.b;
	        $scope. questions.c= response.data.answers.c;
	        $scope. questions.d= response.data.answers.d;
	    	}
	    }, function errorCallback(response) {
	        alert("Exam is Complted Please Submit the Exam");

	    }); 

	};
	$scope.submitExam = function (){
		hideing(true);
		 $scope. questions.question="Calculating the results, Please wait....!";

		$http({
		     method: 'POST',
		     url: 'submitExam',
		     data : 'a',
		     headers: { 'Content-Type' : 'application/json'}
		  }).then(function successCallback(response) {
				hideing(true);
				 $scope. questions.question="You got "+response.data+" marks";

		        alert("You got "+response.data+" \n Result successfully sent to your registred email ID");
		        $scope.loader = false;
			// window.location.href = ('./index');
			  
		  }, function errorCallback(response) {
		    }); 
		  };
		 function hideing(value){
			 $scope.loader = value;
			 $scope. questions.question="Calculating the results, Please wait....!";
			 $scope.radiobuttons = false;
    		 $scope.successMessagebool = false;
    		 $scope.booleansradiobuttons = false;
		 }
	
	});