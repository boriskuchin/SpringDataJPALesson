angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8180/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.changeQuantity = function (productID, delta) {
        $http({
            url: contextPath + '/products/change_quantity',
            method: 'POST',
            params: {
                id: productID,
                delta: delta
            }

        }).then(function (response) {
            console.log($scope.url);
            $scope.loadProducts();

        });
    };

    $scope.deleteProduct = function (productID) {
        $http({
            url: contextPath + '/products/delete',
            method: 'GET',
            params: {
                id: productID
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };


        $scope.filterProduct = function () {
            // console.log("filterProduct");
            $http({
                url: contextPath + '/products/filter',
                method: 'POST',
                params: {
                    min: $scope.filter.min,
                    max: $scope.filter.max
                }
            }).then(function (response) {

                $scope.ProductList = response.data;
                console.log(response.data);
            });
        };


    $scope.addProduct = function () {
        console.log($scope.newProduct);
        $http.post(contextPath + '/productAdd', $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
            });
        $scope.newProduct = null
    }


    $scope.loadProducts();

});