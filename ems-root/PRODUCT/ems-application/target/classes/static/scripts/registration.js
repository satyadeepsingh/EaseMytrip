
var app = angular.module('myApp',[]);
console.log("registration.js loaded");
app.factory('httpRequestInterceptor', function () {
    return {
      request: function (config) {
        config.headers['Accept'] = 'application/json;odata=verbose';
        config.headers['x-session-id'] = '355345';
        return config;
        }
    };
});
  
app.config(function ($httpProvider) {
    $httpProvider.interceptors.push('httpRequestInterceptor');
});
app.controller('httpCtrl', function($scope, $http) {

    $scope.firstName = null;
    $scope.lastName = null;
    $scope.useremail = null;
    $scope.userpassword = null;
    $scope.useraddress1 = null;
    $scope.useraddress2 = null;
    $scope.pincode = null;
    $scope.city = null;
    $scope.state = null;
    $scope.country = null;
    console.log("calling postRequest()");

    
    $scope.postRequest = function (firstName, lastName, useremail,userpassword,useraddress1,useraddress2,city,state, country,pincode) {
        var createUserReq = {
            name: $scope.firstName + " " + $scope.lastName,
            email: $scope.useremail,
            password: $scope.userpassword,
            address : {
                addressline1: $scope.useraddress1,
                addressline2: $scope.useraddress2,
                city:$scope.city,
                country:$scope.country,
                state: $scope.state,
            },
            pincode: $scope.pincode,
            username: $scope.useremail
        };
        console.log($scope.userpassword);
        console.log($scope.firstName);
        //Call the services
        $http.post('/emt/createuser', JSON.stringify(createUserReq))
        .then(function (response) {
            if (response.data) {
                console.log(response.data);
                $scope.msg = "Post Data Submitted Successfully!";
            }
        }, function (response) {
            $scope.msg = "Service not Exists";
            $scope.statusval = response.status;
            $scope.statustext = response.statusText;
            $scope.headers = response.headers();
        });
    };
});
