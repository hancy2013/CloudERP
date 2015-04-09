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
      required: true,
      disabled: true
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
      format: 'hh:mm',
      hstep: 1,
      mstep: 5,
      ismeridian: true
    }, {
      key: 'select',
      type: 'select',
      options: ['a', 'b']
    }, {
      key: 'multiselect',
      label: 'multiselect',
      placeholder: 'select one',
      type: 'multiselect',
      options: ['测试中文Adam@gmail.com',
        '测试中文2Adam@gmail.com'
      ]
    }, {
      key: "textarea",
      label: '测试文本区',
      type: 'textarea',
      lines: 6
    }, {
      key: 'checkbox',
      label: '测试复选框',
      type: 'checkbox'
    }, {
      key: 'radio',
      label: '测试Radio',
      type: 'radio',
      options: [{
        name: '测试Radio1',
        value: '1'
      }, {
        name: '测试Radio2',
        value: '2'
      }]
    }, {
      key: 'number',
      label: '测试数字',
      type: 'number',
      min: 10,
      max: 100,
      minlength: 2,
      maxlength: 3
    }, {
      key: 'email',
      label: '测试email',
      type: 'email'
    }];


    $scope.toPrettyJSON = function(obj, tabWidth) {
      var strippedObj = angular.copy(obj);
      angular.forEach(strippedObj, function removeFormFieldForPerformancePurposes(field) {
        delete field.formField;
      });
      return JSON.stringify(strippedObj, null, Number(tabWidth));
    };

    $scope.$watch('formFieldsStr', function onOptionsUpdated(newValue) {
      try {
        $scope.formFields = $parse(newValue)({});
        $scope.formFieldsError = false;
      } catch (e) {
        $scope.formFieldsError = true;
      }
    });
    $scope.$watch('formDataStr', function onDataUpdated(newValue) {
      try {
        $scope.formData = $parse(newValue)({});
        $scope.formDataError = false;
      } catch (e) {
        $scope.formDataError = true;
      }
    });
    $scope.formFieldsStr = $scope.toPrettyJSON($scope.formFields, 4);
    $scope.formDataStr = $scope.toPrettyJSON($scope.formData, 4);
    $scope.submittedData = null;
    $scope.formOptions = {
      hideSubmit: false,
      submitCopy: 'Submit'
    };
    $scope.onSubmit = function() {
      $scope.submittedData = $scope.formData;
      console.log($scope.submittedData);
    }
  });