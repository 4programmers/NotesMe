var services = angular.module('services', [ 'ngResource']);

//IE cache HACK-- IE cache AJAX request
services.config(['$httpProvider', function($httpProvider) {
	 $httpProvider.interceptors.push('noCacheInterceptor');
	}]).factory('noCacheInterceptor', function () {
	            return {
	                request: function (config) {
	                    console.log(config.method);
	                    console.log(config.url);
	                    if(config.method=='GET'){
	                        var separator = config.url.indexOf('?') === -1 ? '?' : '&';
	                        config.url = config.url+separator+'noCache=' + new Date().getTime();
	                    }
	                    console.log(config.method);
	                    console.log(config.url);
	                    return config;
	               }
	           };
	    });


services.factory('CarService', [ '$resource', function($resource) {
	return $resource('cars/:id');
} ]); 