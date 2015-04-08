angular.module('cloudErpFrontendApp')
  .controller('FormCtrl', function($scope) {
    $scope.schema = {
      type: "object",
      properties: {
        name: {
          type: "string",
          "x-schema-form": {
            type: "text",
            placeholder: "Don't hold back",
            readonly: true
          }
        },
        title: {
          type: "string",
          "x-schema-form": {
            type: "select",
            titleMap: {
              "yes": "Yes I do",
              "no": "Hell no"
            }
          }
        },
        textarea: {
          type: "string",
          "x-schema-form": {
            type: "textarea",
            placeholder: "Don't hold back"
          }
        },
        checkbox: {
          type: "boolean"
        },
        checkboxes: {
          type: "string",
          "x-schema-form": {
            type: "checkboxes",
            titleMap: {
              "yes": "Yes I do",
              "no": "Hell no"
            }
          }
        },
        number: {
          type: "number"
        },
        password: {
          type: "string",
          "x-schema-form": {
            type: "password",
            placeholder: "Don't hold back"
          }
        },
        birthday: {
          type: "string",
          format: "date"
        }
      }
    };

    $scope.form = ['*', {
      type: "submit",
      title: "Save"
    }];

    $scope.model = {};

    $scope.onSubmit = function(form) {
      // First we broadcast an event so all fields validate themselves
      console.log($scope.model);
      $scope.$broadcast('schemaFormValidate');

      // Then we check if the form is valid
      if (form.$valid) {
        // ... do whatever you need to do with your data.
      }
    }
  });