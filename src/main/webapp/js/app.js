var app = angular.module("geektic", ['ngRoute']);

app.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.
            when('/api/geeks', {templateUrl:'views/geeks.html',   controller:'GeekticCtrl'}).
            when('/api/search',  {templateUrl:'views/search.html',    controller:'GeekticCtrl'}).
            when('/api/geek',  {templateUrl:'views/geek.html',    controller:'GeekticCtrl'}).
            otherwise({redirectTo:'/'});
});

app.controller('GeekticCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});
app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});