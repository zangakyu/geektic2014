var app = angular.module("geektic", ['ngRoute']);

app.config(function ($routeProvider) {
        $routeProvider.
            when('/geeks', {templateUrl:'views/geeks.html',   controller:'GeeksCtrl'}).
            when('/geeks/:geekId', {templateUrl:'views/geek.html',   controller:'GeekCtrl'}).
            when('/search',  {templateUrl:'views/search.html',    controller:'SearchCtrl'}).
            when('/',  {templateUrl:'views/search.html',    controller:'HomeCtrl'}).
            otherwise({redirectTo:'/'});
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

app.controller('SearchCtrl', function($scope, $http) {
	$scope.searchGeek = function (interest,sex){
		console.log("test");
	}
  /*  $http.get('/api/search').success(function(geeks) {
        $scope.geeks=geeks;
    }); */
});

app.controller('HomeCtrl', function($scope, $http) {
});