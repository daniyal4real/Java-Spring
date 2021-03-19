var app = angular.module('aitu-project', []);
app.controller('FactoryCtrl', function($scope, $http) {
    $scope.ordersList = [];

    $scope.authorization = {
        login: '',
        password: '',
    };

    $scope.login = function(authorization) {
        $http({
            url: 'http://127.0.0.1:9090/api/login/factory',
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            },
            data: authorization
        })
            .then(function (response) {
                    $scope.authorization = response.data;
                    $scope.getOrders();
                    $scope.createDashboard();
                },
                function (response) { // optional
                    $scope.authorization = {}
                });
    };


    $scope.getOrders = function() {
        $http({
            url: 'http://127.0.0.1:9090/api/factory/orders',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            },
            data: $scope.ordersList
        })
            .then(function (response) {
                    console.log(response);
                    $scope.ordersList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };


    $scope.getOrdersByStatus = function(status) {
        $http({
            url: 'http://127.0.0.1:9090/api/orders/status/'+status,
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.ordersList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };

    $scope.update = function(orderId) {
        $http({
            url: 'http://127.0.0.1:9090/api/orders/status/'+orderId,
            method: "PUT",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            },
        })
            .then(function (response) {
                    console.log(response);
                    $scope.getOrders();
                },
                function (response) { // optional
                    console.log(response);
                });
    };

});


