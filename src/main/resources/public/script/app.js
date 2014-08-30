var app = angular.module('app', [ 'services', 'ngRoute', 'ngCookies',
		'ngAnimate' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/cars', {
		templateUrl : 'list.html',
		controller : 'CarListController'
	}).when('/car', {
		templateUrl : 'form.html',
		controller : 'CarFormController'
	}).when('/cars/:id', {
		templateUrl : 'form.html',
		controller : 'CarFormController'
	}).otherwise({
		redirectTo : '/cars'
	});
});

app.controller("CarListController", function($scope, CarService) {
	$scope.cars = CarService.query()

	$scope.remove = function(car) {
		CarService.remove(car, function() {
			CarService.query(function(data) {
				$scope.cars = data
			})
		})
	}

	$scope.search = function() {
		CarService.query({
			query : $scope.query
		}, function(data) {
			$scope.cars = data
		})
	}
})

app.controller("CarFormController", function($scope, CarService, $location,
		$routeParams) {
	var idCar = $routeParams.id

	if (idCar) {
		$scope.car = CarService.get({
			id : idCar
		})
	} else {
		$scope.car = {
			name : 'Fiat',
			price : 1000,
			productionYear : 1999
		}
	}

	$scope.save = function() {
		CarService.save($scope.car, function() {
			$location.path("#/cars");
		})
	}
})
