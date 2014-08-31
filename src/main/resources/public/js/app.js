var app = angular.module('app', [ 'operator', 'ngRoute', 'ngCookies',
		'ngAnimate' ]);



app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'view/main.html',
	}).otherwise({
		redirectTo : '/'
	});
});