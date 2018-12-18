'user strict';

var app = angular.module('myApp', []);
console.log("registration.js loaded");
app.factory('httpRequestInterceptor', function() {
	return {
		request : function(config) {
			config.headers['Accept'] = 'application/json;odata=verbose';
			config.headers['x-session-id'] = Math.floor(100000000 + Math
					.random() * 900000000);
			;
			return config;
		}
	};
});

app.config(function($httpProvider) {
	$httpProvider.interceptors.push('httpRequestInterceptor');
});

app
		.controller(
				'httpCtrl',
				function($scope, $http, $window, $timeout) {

					$scope.firstName = null;
					$scope.lastName = null;
					$scope.email = null;
					$scope.userpassword = null;
					$scope.useraddress1 = null;
					$scope.useraddress2 = null;
					$scope.pincode = null;
					$scope.city = null;
					$scope.state = null;
					$scope.country = null;
					$scope.contactnumber = null;
					$scope.statusbody = null;
					$scope.title = null;
					$scope.status = null;
					$scope.message = null;
					$scope.redirectToLogin = function() {
						$window.location.href = "/login";
					}

					$scope.postRequest = function(value, firstName, lastName,
							email, userpassword, useraddress1, useraddress2,
							city, state, country, pincode, contactnumber) {
						if (value) {
							var createUserReq = {
								name : $scope.firstName + " " + $scope.lastName,
								email : $scope.email,
								password : $scope.userpassword,
								address : {
									addressline1 : $scope.useraddress1,
									addressline2 : $scope.useraddress2,
									city : $scope.city,
									country : $scope.country,
									state : $scope.state,
								},
								pincode : $scope.pincode,
								username : $scope.email,
								contactnumber : $scope.contactnumber
							};

							// Call the services
							$http
									.post('emt/createuser',
											JSON.stringify(createUserReq))
									.then(
											function(response) {
												if (response.data) {
													$scope.statusbody = 'User Registration is successful. You are being redirected to login to continue';
													$scope.title = 'Congrats, you are one step away from us!';
													$scope.message = "success";
													$timeout(
															function() {
																$scope
																		.redirectToLogin();
															}, 5000);

													console.log(response.data);
												}
											},
											function(response) {
												$scope.title = "Phshhhh, something wrong happened!";
												$scope.statusbody = "User Registration has failed! Please try again.";
												$scope.statusval = response.status;
												$scope.statustext = response.statusText;
												$scope.headers = response
														.headers();
											});
						}
					};
				});
