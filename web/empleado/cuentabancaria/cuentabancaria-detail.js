app.controller("CuentaBancariaInsertController", ["$scope", "$http", function ($scope, $http) {

        $scope.visible = {
            insert: true,
            update: false,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false
        };

        

        $scope.insert = function () {
            $http({
                method: "POST",
                data: $scope.cuentaBancaria,
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                alert("La nueva cuenta bancaria ha sido insertada correctamente...");
                $scope.cuentaBancaria = data;
            }).error(function (data, status) {
                alert("No se ha Insertado la Cuenta");
                console.log(data + "    " + status);
            });
        };

    }]);

app.controller("CuentaBancariaUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {
        
        $scope.visible = {
            insert: false,
            update: true,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false
        };
        
        $scope.cuentaBancaria = {
            idCuentaBancaria:$routeParams.idCuentaBancaria
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function (data) {
                $scope.cuentaBancaria = data;
            }).error(function () {
                alert("No existe la cuenta");
            });
        };

        $scope.get();

        $scope.update = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria,
                data: $scope.cuentaBancaria
            }).success(function () {
                alert("Los datos de la cuenta nº " + $scope.cuentaBancaria.idCuentaBancaria + " se han actualizado correctamente...");
                $scope.cuentaBancaria = {};
            }).error(function () {
                alert("No ha producido un Error");
            });
        };
    }]);

app.controller("CuentaBancariaDeleteController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {
        
        $scope.visible = {
            insert: false,
            update: false,
            delete: true
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: true
        };
        
        $scope.cuentaBancaria = {
            idCuentaBancaria:$routeParams.idCuentaBancaria
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function (data) {
                $scope.cuentaBancaria = data;
            }).error(function () {
                alert("No existe la cuenta");
            });
        };

        $scope.get();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function () {
                alert("La cuenta bancaria nº " + $scope.cuentaBancaria.idCuentaBancaria + " ha sido borrada correctamente...");
                $scope.cuentaBancaria = {};
            }).error(function () {
                alert("No se ha Borrado la Cuenta");
            });
        };
    }]);

