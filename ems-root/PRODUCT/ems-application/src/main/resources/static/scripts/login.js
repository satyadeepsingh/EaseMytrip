'use strict';
var app = angular.module('loginApp', []);
app.controller ('loginCtrl', function($scope, $location) {

    var path = $location.absUrl();
    var patt1 = /error=true/;
    var result = path.match(patt1);
    console.log(path);
    console.log(result);
    if(result[0] ==='error=true') {
        $scope.value=true;
        $scope.title="Login Failed!";
        $scope.statusbody="Please check your username and password!";
    }
});


				