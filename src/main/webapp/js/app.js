var app = angular.module("geektic", ['ngRoute']);

app.config(function ($routeProvider) {
        $routeProvider.
            when('/geeks', {templateUrl:'views/geeks.html',   controller:'GeekticCtrl'}).
            when('/search',  {templateUrl:'views/search.html',    controller:'GeekticCtrl'}).
            when('/geek',  {templateUrl:'views/geek.html',    controller:'GeekticCtrl'}).
            otherwise({redirectTo:'/'});
});

app.controller('GeekticCtrl', function($scope, $http) {
    $http.get('/api/geeks').success(function(geeks) {
        $scope.geeks=geeks;
    });
});
app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});