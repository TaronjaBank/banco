app.controller("CuentaBancariaInsertController", ["$scope", "$http", "$location", function ($scope, $http, $location) {

        $scope.estado = {
            accion: 'insertar'
        };
        
        $scope.estilo = "";
        
        $scope.irLista = function() {
            $location.path("/cuentabancaria/list");
        };

        $scope.insert = function () {
            $http({
                method: "POST",
                data: $scope.cuentaBancaria,
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentaBancaria = data;
                $scope.cuentaBancaria = null;
            }).error(function (data, status) {
                alert("Error: no se ha podido realizar la operación");
                //console.log(data + "    " + status);
            });
        };

    }]);

app.controller("CuentaBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", function ($scope, $http, $routeParams, $location) {
        
        $scope.estado = {
            accion: 'actualizar'
        };
        
        $scope.estilo = "";
        
        $scope.cuentaBancaria = {
            idCuentaBancaria:$routeParams.idCuentaBancaria
        };
        
        $scope.irLista = function() {
            $location.path("/cuentabancaria/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function (data) {
                $scope.cuentaBancaria = data;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();

        $scope.update = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria,
                data: $scope.cuentaBancaria
            }).success(function () {
                $scope.cuentaBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
    }]);

app.controller("CuentaBancariaDeleteController", ["$rootScope","$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        
        $scope.estado = {
            accion: 'borrar'
        };
        
        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled
        
        $scope.cuentaBancaria = {
            idCuentaBancaria:$routeParams.idCuentaBancaria
        };
        
        $scope.irLista = function() {
            $location.path("/cuentabancaria/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function (data) {
                $scope.cuentaBancaria = data;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function () {
                $scope.cuentaBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
    }]);

