'use strict';
var app = angular.module('loginApp',[]);
app.controller('loginCtrl', function($scope,$http,$window) {
    $scope.username = null;
    $scope.password = null;
    $scope.status=null;
    $scope.title=null;
    $scope.statusbody=null;
    $scope.login = function(value,username,password) {
        if(value) {
            var loginData = {
                username: $scope.username,
                password: $scope.password
            }

            $http.get('/login', JSON.stringify(loginData))
            .then(function(response){
                if(response.data) {
                    console.log("login success");
                    console.log(response.status);
                    console.log(response.data);
                 }
            }, function(response) {
                console.log("login failed");
                $scope.status="failed";
            });
        }
    }
});