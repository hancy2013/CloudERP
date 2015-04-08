'use strict';

/**
 * @ngdoc function
 * @name cloudErpFrontendApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the cloudErpFrontendApp
 */
angular.module('cloudErpFrontendApp')
	.controller('MainCtrl', function($scope) {
		$scope.awesomeThings = [
			'HTML5 Boilerplate',
			'AngularJS',
			'Karma'
		];
		$scope.menus = [{
			name: "Formly",
			href: "formly"
		}, {
			name: "SchemaForm",
			href: "schemaForm"
		}, {
			name: 'AutoField',
			href: "autoField"
		}, {
			name: 'react',
			href: 'react'
		}, {
			name: 'jsx',
			href: 'jsx'
		}];
	});