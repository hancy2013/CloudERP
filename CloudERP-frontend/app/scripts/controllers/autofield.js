angular.module('cloudErpFrontendApp')
.controller('AutoFieldCtrl', ['$scope', function ($scope) {
    $scope.user = {
        username: '',
        password: '',
        confirmPassword: '',
    };

    $scope.schema = [
        { property: 'username', type: 'text', attr: { ngMinlength: 4, required: true }, msgs: {minlength: 'Needs to have at least 4 characters'} },
        { property: 'password', type: 'password', attr: { required: true } },
        { property: 'confirmPassword', label: 'Confirm Password', type: 'password', attr: { confirmPassword: 'user.password', required: true } }
    ];

    $scope.join = function(){
        if(!$scope.joinForm.$valid) return;
        //join stuff....
    }
}]);