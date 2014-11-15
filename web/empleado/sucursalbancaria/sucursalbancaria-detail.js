app.controller("SucursalBancariaInsertController", ["$scope", "$http", function($scope, $http) {
        //$routeParams: inyección de los parámetros variables de la ruta

        $scope.visible = {
            insert: true,
            update: false,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false
        };

        $scope.sucursalBancaria = {};

        $scope.insert = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/SucursalBancaria/",
                data: $scope.sucursalBancaria
            }).success(function(data) {
                $scope.sucursalBancaria = data;
                alert("La sucursal nº " + $scope.sucursalBancaria.idSucursalBancaria + " ha sido insertada correctamente...");
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

    }]);




app.controller("SucursalBancariaUpdateController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.visible = {
            insert: false,
            update: true,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false
        };

        $scope.sucursalBancaria = {};

        $scope.get = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.idSucursalBancaria
            }).success(function(data) {
                $scope.sucursalBancaria = data;
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

        $scope.get();


        $scope.update = function() {
            $http({
                method: "PUT",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.idSucursalBancaria,
                data: $scope.sucursalBancaria
            }).success(function(data, status, headers, config) {
                $scope.sucursalBancaria = data;
                alert("Los datos de la sucursal nº " + $routeParams.idSucursalBancaria + " se han actualizado correctamente...");
            }).error(function(data, status, headers, config) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

    }]);




app.controller("SucursalBancariaDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.visible = {
            insert: false,
            update: false,
            delete: true
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: true
        };

        $scope.sucursalBancaria = {};

        $scope.get = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.idSucursalBancaria
            }).success(function(data, status, headers, config) {
                $scope.sucursalBancaria = data;
            }).error(function(data, status, headers, config) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

        $scope.get();


        $scope.deleteData = function() {
            $http({
                method: "DELETE",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.idSucursalBancaria
            }).success(function(data, status, headers, config) {
                alert("La sucursal bancaria nº " + $routeParams.idSucursalBancaria + " ha sido borrada correctamente de la BD...");
                $scope.sucursalBancaria = {};
            }).error(function(data, status, headers, config) {
                alert("Error en la peticiión al servidor; error:" + status);
            });
        };

    }]);
