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
     $scope.formData = {};

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
      format: 'dd/MM/yyyy'
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
    }];

    $scope.formOptions = {
      hideSubmit: false,
      submitCopy: 'Submit'
    };

    $scope.post = {};

    $scope.formOptions = {
      hideSubmit: false,
      submitCopy: '保存'
    };

    $scope.onSubmit = function() {
      console.log($scope.post);
    }
  });