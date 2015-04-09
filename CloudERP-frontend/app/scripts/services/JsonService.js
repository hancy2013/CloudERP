var app = angular.module('cloudErpFrontendApp');
app.factory('jsonService', function jsonService($http) {
	return {
		getJSON: getJSON
	};

	function getJSON() {
		return $http.get('http://mysafeinfo.com/api/data?list=englishmonarchs&format=json');
	}
});