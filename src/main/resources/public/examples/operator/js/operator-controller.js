var operatorControllerModule = angular.module('operator.controller', ['ngRoute', 'ngCookies','operator.service']);

operatorControllerModule.controller("OperatorListController", function($scope, OperatorService) {
	$scope.operators = OperatorService.query()

	$scope.remove = function(operator) {
		OperatorService.remove(operator, function() {
			OperatorService.query(function(data) {
				$scope.operators = data
			})
		})
	}

})

operatorControllerModule.controller("OperatorFormController", function($scope, OperatorService, $location,
		$routeParams) {
	var idOperator = $routeParams.id

	if (idOperator) {
		$scope.operator = OperatorService.get({
			id : idOperator
		})
	}

	$scope.save = function() {
		OperatorService.save($scope.operator, function() {
			$location.path("examples/operators");
		})
	}
})
