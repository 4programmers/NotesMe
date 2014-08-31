var operatorModule = angular.module('operator', ['ngRoute', 'ngCookies','operator.service','operator.controller']);

operatorModule.config(function($routeProvider) {
	$routeProvider.when('/examples/operators', {
		templateUrl : 'examples/operator/view/operator-list.html',
		controller : 'OperatorListController'
	}).when('/examples/operator', {
		templateUrl : 'examples/operator/view/operator-form.html',
		controller : 'OperatorFormController'
	}).when('/examples/operators/:id', {
		templateUrl : 'examples/operator/view/operator-form.html',
		controller : 'OperatorFormController'
	});
}); 
