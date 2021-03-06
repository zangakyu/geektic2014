var app = angular.module("geektic", ['ngRoute']);

app.config(function ($routeProvider) {
        $routeProvider.
            when('/geeks', {templateUrl:'views/geeks.html',   controller:'GeeksCtrl'}).
            when('/geeks/:geekId', {templateUrl:'views/geek.html',   controller:'GeekCtrl'}).
            when('/search',  {templateUrl:'views/search.html',    controller:'SearchPrepareCtrl'}).
            when('/search/:interest/:sex',  {templateUrl:'views/searchResult.html',    controller:'SearchCtrl'}).
            otherwise({redirectTo:'/search'});
});

app.controller('GeeksCtrl', function($scope, $http) {
    $http.get('/api/geeks').success(function(geeks) {
        $scope.geeks=geeks;
    });
});

app.controller('GeekCtrl', function($scope, $http,$routeParams) {
    $http.get('/api/geeks/'+$routeParams.geekId).success(function(geek) {
        $scope.geek=geek;
    });
});

app.controller('SearchPrepareCtrl', function($scope, $http, $location) {
	$scope.searchGeek = function (interest,sex){
	   $location.path("/search/"+interest+"/"+sex);
		console.log($location.path());
	}
});

app.controller('SearchCtrl', function($scope, $http, $location, $routeParams) {
		$scope.searchGeek = function (interest,sex){
	     $location.path("/search/"+interest+"/"+sex);
		  console.log($location.path());
		}
		if($routeParams.interest!="undefined" && $routeParams.sex!="undefined"){
			$http.get('/api/geeks/search?interest='+$routeParams.interest+"&sex="+$routeParams.sex).success(function(geeks) {
	         $scope.geeks=geeks;
	      });
		} 
		else{
			console.log("nope");		
		}   
});

app.controller('HomeCtrl', function($scope, $http) {
});