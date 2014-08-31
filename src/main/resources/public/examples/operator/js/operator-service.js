var operatorServiceModule = angular.module('operator.service', [ 'ngResource']);

operatorServiceModule.factory('OperatorService', [ '$resource', function($resource) {
	return $resource('operators/:id');
} ]); 