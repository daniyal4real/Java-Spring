var app = angular.module('aitu-project', []);
app.controller('ShowOrderCtrl', function($scope, $http) {
    $scope.customerList = [];
    $scope.getCustomerList = function() {
        $http({
            url: 'http://127.0.0.1:9090/api/customers/list',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            },
        })
            .then(function (response) {
                    console.log(response);
                    $scope.customerList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };
    $scope.getCustomerList();

})
