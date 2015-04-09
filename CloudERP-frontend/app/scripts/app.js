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
    'schemaForm',
    'autofields',
    'ui.bootstrap',
    'react',
    'ui.select'
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
      .when('/autoField', {
        templateUrl: 'views/autofield.html',
        controller: 'AutoFieldCtrl'
      })
      .when('/react', {
        templateUrl: 'views/react.html',
        controller: 'ReactCtrl'
      })
      .when('/jsx', {
        templateUrl: 'views/jsx.html',
        controller: 'JsxCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  }).config(function(formlyConfigProvider) {
  var templates = '/views/fields/';
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
    'textarea',
    'multiselect',
    'date',
    'time'
  ];

  angular.forEach(fields, function(val) {
    formlyConfigProvider.setTemplateUrl(val, formly + val + '.html');
  });

}).config(function(uiSelectConfig) {
  //uiSelectConfig.search-enabled=true;
  uiSelectConfig.theme = 'bootstrap';
  uiSelectConfig.resetSearchInput = true;
});
