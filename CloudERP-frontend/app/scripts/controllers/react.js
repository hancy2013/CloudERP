'use strict';

/**
 * @ngdoc function
 * @name cloudErpFrontendApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the cloudErpFrontendApp
 */
var app = angular.module('cloudErpFrontendApp');
app.controller('ReactCtrl', function($scope) {
	$scope.person = {
		fname: 'Clark',
		lname: 'Kent'
	};
	/** @jsx React.DOM */

});
var Hello = React.createClass( {
  propTypes: {
    fname: React.PropTypes.string.isRequired,
    lname: React.PropTypes.string.isRequired
  },

  render: function() {
    return React.DOM.span( null,
      'Hello ' + this.props.fname + ' ' + this.props.lname
    );
  }
} );

app.value( "Hello", Hello );

app.directive( 'hello', function( reactDirective ) {
  return reactDirective( Hello );
} );