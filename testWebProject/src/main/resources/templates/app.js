var app = angular.module('aitu-project', []);
app.controller('ProductCtrl', function($scope, $http) {
    $scope.productList = [];
    $scope.categoryList = [];

    $scope.getProducts = function() {
        $http({
            url: 'http://127.0.0.1:9090/api/products',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.productList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };

    $scope.getCategories = function() {
        $http({
            url: 'http://127.0.0.1:9090/api/categories',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.categoryList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };

    $scope.getProductsByCategory = function(categoryId) {
        $http({
            url: 'http://127.0.0.1:9090/api/products/categories/' + categoryId,
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        })
            .then(function (response) {
                    console.log(response);
                    $scope.productList = response.data;
                },
                function (response) { // optional
                    console.log(response);
                });
    };

    $scope.getCategories();
    $scope.getProducts();

    $scope.authorization = {
        login: '',
        password: '',
        token: ''
    };

    $scope.customer = {};

    $scope.login = function(authorization) {
        $http({
            url: 'http://127.0.0.1:9090/api/login',
            method: "POST",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
            },
            data: authorization
        })
            .then(function (response) {
                    $scope.authorization = response.data;
                    $scope.getMe();
                    $scope.getMyOrders();
                },
                function (response) { // optional
                    $scope.authorization = {}
                });
    };



    $scope.getMe = function(){
        $http({
            url: 'http://127.0.0.1:9090/api/customers/me',
            method: "GET",
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "Authorization":$scope.authorization.token
            }
        })
            .then(function (response) {
                    $scope.customer = response.data;
                },
                function (response) { // optional
                    console.log(response);
                    $scope.customer ={};
                    $scope.shopMessage = 'Login or Password is incorrect!';
                });
    };

    $scope.orderItemList = [];

    $scope.orderMessage = '';
    let orderItemList = [];

    $scope.createOrder = function () {
        $http({
            url: 'http://127.0.0.1:9090/api/orders/create',
            method: 'POST',
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "Authorization": $scope.authorization.token
            },
            data: $scope.orderItemList
        }).then(function (response){
            console.log(response);
        }, function (response){
            console.log(response);
        })
    };

    $scope.sendOrders = function() {
        if (Object.keys($scope.customer).length === 0) {
            $scope.orderMessage = 'You have not authorized';
            alert('You have not authorized')
        }else{
            if (Object.keys($scope.orderItemList).length === 0) {
                $scope.orderMessage = 'Order is empty';
                alert('Order is empty')
            }else{
                $scope.orderMessage = 'Accepted';
                alert('Success')
                $scope.createOrder();
                $scope.getMyOrders();
                console.log($scope.customer);
            }
        }
    };

    $scope.incrementProduct = function(product){
        for(orderItem of orderItemList) {
            if(orderItem.productId === product.productId) {orderItem.name = product.productName;orderItem.price = product.price;orderItem.quantity += 1;
            }
        }
        $scope.orderItemList.push({productId: product.productId, productName: product.productName, price: product.unitPrice, quantity: 1});
    };

    $scope.decrementProduct = function(product){
        for(orderItem of orderItemList) {
            if(orderItem.productId === product.productId) {orderItem.name = product.productName;orderItem.price = product.price;orderItem.quantity -= 1;
            }
        }
        $scope.orderItemList.pop();
    };


    $scope.myOrders = [];

    $scope.getMyOrders = function () {
        $http({
            url: 'http://127.0.0.1:9090/api/orders/my-orders',
            method: 'GET',
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json",
                "Authorization": $scope.authorization.token
            }
        }).then(function (response){
            console.log(response);
            $scope.myOrders = response.data;
        }, function (response){
            console.log(response);
        })
    };

    $scope.myOrderItems = [];

    $scope.getMyOrderItems = function (orderId) {
        $http({
            url: 'http://127.0.0.1:9090/api/orders_items/my-orders/' + orderId,
            method: 'GET',
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json"
            }
        }).then(function (response){
                console.log(response);
                 $scope.myOrderItems = response.data;
            }, function (response){
                console.log(response);
            })
         };
});



