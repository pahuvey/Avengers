
var myApp = angular.module("myApp" , ["ngRoute"]);

myApp.config(function($routeProvider){
	$routeProvider
	.when('/', {templateUrl:'home.html'})
	.when('/avengers1', {templateUrl:'avengers.html'})
	
	.when('/agents', {templateUrl:'agents.html'})
	
	.when('/formulaire', {templateUrl:'formulaire.html'});

	
	});






myApp.controller("myCtrl", function($scope, $http) {
    init($scope, $http);
    $scope.avenger = {}
    $scope.remove = function(id) {
        deleteAvenger(id,$http,$scope);
    }

    $scope.show = function(id) {
        getAvenger(id, $scope, $http);
    }

    $scope.addAvenger = function() {
        saveAvenger($scope,$http);
    }	
    $scope.date = new Date();
	
	$scope.edit=function(id){
		editAvenger1(id, $http, $scope);
	}
		

});