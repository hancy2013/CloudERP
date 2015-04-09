'use strict';

/**
 * @ngdoc function
 * @name cloudErpFrontendApp.controller:FormlyCtrl
 * @description
 * # FormlyCtrl
 * Controller of the cloudErpFrontendApp
 */
angular.module('cloudErpFrontendApp')
  .controller('FormlyCtrl', function($scope) {
    $scope.formData = {
      select: 'a'
    };

    $scope.formFields = [{
      key: 'name',
      type: 'text',
      label: 'Name',
      required: true
    }, {
      key: 'description',
      type: 'text',
      label: 'Description',
      required: true
    }, {
      key: 'startDate',
      required: true,
      label: 'Start Date',
      type: 'date',
      format: 'yyyy-MM-dd'
    }, {
      key: 'startTime',
      required: true,
      label: 'Start Time',
      type: 'time',
      hstep: 1,
      mstep: 5,
      ismeridian: true
    }, {
      key: 'endDate',
      label: 'End',
      type: 'date',
      format: 'dd/MM/yyyy'
    }, {
      key: 'endTime',
      required: true,
      label: 'End Time',
      type: 'time',
      hstep: 1,
      mstep: 5,
      ismeridian: true
    }, {
      key: 'select',
      type: 'select',
      options: [{
        name: 'A',
        value: 'a'
      }]
    }, {
      key: 'multiselect',
      label: 'multiselect',
      placeholder:'select one',
      type: 'multiselect',
      options: [{
        name: '测试中文',
        value: 'Adam@gmail.com'
      }]
    }];

    $scope.mode = {};
  $scope.person = {};
  $scope.people = [
    { name: 'Adam',      email: 'adam@email.com',      age: 12, country: 'United States' },
    { name: 'Amalie',    email: 'amalie@email.com',    age: 12, country: 'Argentina' },
    { name: 'Estefanía', email: 'estefania@email.com', age: 21, country: 'Argentina' },
    { name: 'Adrian',    email: 'adrian@email.com',    age: 21, country: 'Ecuador' },
    { name: 'Wladimir',  email: 'wladimir@email.com',  age: 30, country: 'Ecuador' },
    { name: 'Samantha',  email: 'samantha@email.com',  age: 30, country: 'United States' },
    { name: 'Nicole',    email: 'nicole@email.com',    age: 43, country: 'Colombia' },
    { name: 'Natasha',   email: 'natasha@email.com',   age: 54, country: 'Ecuador' },
    { name: 'Michael',   email: 'michael@email.com',   age: 15, country: 'Colombia' },
    { name: 'Nicolás',   email: 'nicolas@email.com',    age: 43, country: 'Colombia' }
  ];


    $scope.formOptions = {
      hideSubmit: false,
      submitCopy: 'Submit'
    };
    $scope.onSubmit = function() {
      console.log();
    }
  });