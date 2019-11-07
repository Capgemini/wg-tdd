var url_string = window.location.href
var url = new URL(url_string);

angular.module('demo', [])
    .controller('Hello', function($scope, $http) {
        $http.get(window.location.origin + '/greeting?' + url.searchParams).
        then(function(response) {
            $scope.greeting = response.data;
        });
    });