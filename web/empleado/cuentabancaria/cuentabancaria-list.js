app.controller("CuentaBancariaListController", ["$scope", "$http", function ($scope, $http) {
        $scope.findAll = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentasBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });//success.Error
        };//Consultar  
        $scope.findAll();
    }]);

