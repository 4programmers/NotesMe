var app = angular.module('app', [ 'operator','login', 'ngRoute', 'ngCookies',
		'ngAnimate' ]);



app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'view/main.html'
	}).otherwise({
		redirectTo : '/'
	});
});