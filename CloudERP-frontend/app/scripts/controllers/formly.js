'use strict';

/**
 * @ngdoc function
 * @name cloudErpFrontendApp.controller:FormlyCtrl
 * @description
 * # FormlyCtrl
 * Controller of the cloudErpFrontendApp
 */
angular.module('cloudErpFrontendApp')
  .controller('FormlyCtrl', function ($scope) {
    $scope.formFields = [{
      key: 'title',
      type: 'text',
      label: '名称',
      required: true,
      disabled: false,
      placeholder:'测试',
      description:'测试描述'
    }, {
      key: 'content',
      type: 'textarea',
      label: '内容',
      required: true
    }, {
      key: 'image',
      type: 'text',
      label: '图片',
      required: true
    }];

    $scope.post={};
    
    $scope.formOptions = {
      uniqueFormId: true,
      hideSubmit: false,
      submitCopy: '保存'
    };

    $scope.onSubmit = function(){
      console.log($scope.post);
    }
  });
