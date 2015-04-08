'use strict';

var app = angular.module('cloudErpFrontendApp');

app.controller('JsxCtrl', function($scope) {
	$scope.person = {
		fname: 'Clark',
		lname: 'Kent'
	};
});

app.directive('hello', function(reactDirective) {
	return reactDirective(Hello);
});