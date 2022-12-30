angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8180/app/v1/products';

    $scope.loadProducts = function () {
        $http({
            url: contextPath ,
            method: 'get',
            params: {
                minCost: $scope.filter ? $scope.filter.minCost : null,
                maxCost: $scope.filter ? $scope.filter.maxCost : null,
                id: $scope.filter ? $scope.filter.id : null,
                page: $scope.filter ? $scope.filter.page : null,
                name: $scope.filter ? $scope.filter.name : null
            }
        }).then(function (response) {
            console.log(response.data.content)
                $scope.ProductList = response.data.content;
            });
    };




    $scope.changeQuantity = function (productID, delta) {
        $http({
            url: contextPath ,
            method: 'PUT',
            params: {
                id: productID,
                delta: delta
            }

        }).then(function (response) {
            $scope.loadProducts();

        });
    };

    $scope.deleteProduct = function (productID) {
        $http({
            url: contextPath,
            method: 'DELETE',
            params: {
                id: productID
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };


    $scope.addProduct = function () {
        console.log($scope.newProduct);
        $http.post(contextPath, $scope.newProduct)
            .then(function (response) {
                $scope.loadProducts();
            });
        $scope.newProduct = null
    }


    $scope.loadProducts();

});