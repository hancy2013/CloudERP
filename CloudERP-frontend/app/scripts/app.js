'use strict';

/**
 * @ngdoc overview
 * @name cloudErpFrontendApp
 * @description
 * # cloudErpFrontendApp
 *
 * Main module of the application.
 */
angular
  .module('cloudErpFrontendApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'formly',
    'schemaForm'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/formly', {
        templateUrl: 'views/formly.html',
        controller: 'FormlyCtrl'
      })
      .when('/schemaForm', {
        templateUrl: 'views/schemaform.html',
        controller: 'FormCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  }).config(function(formlyConfigProvider) {
  var templates = 'views/fields/';
  var formly = templates + 'formly-field-';
  var fields = [
    'checkbox',
    'email',
    'hidden',
    'number',
    'password',
    'radio',
    'select',
    'text',
    'textarea'
  ];

  angular.forEach(fields, function(val) {
    formlyConfigProvider.setTemplateUrl(val, formly + val + '.html');
  });

  formlyConfigProvider.setTemplateUrl('date', templates + 'date.html');
  formlyConfigProvider.setTemplateUrl('time', templates + 'time.html');

});;
