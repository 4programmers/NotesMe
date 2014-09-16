var loginModule = angular.module('login',['ngRoute', 'ngCookies']);

loginModule.config(function($routeProvider) {
    $routeProvider.when('/login', {
        templateUrl: 'authentication/view/login-form.html',
        controller: 'LoginController'
    });
 });

loginModule.controller('LoginController', function() {

});

