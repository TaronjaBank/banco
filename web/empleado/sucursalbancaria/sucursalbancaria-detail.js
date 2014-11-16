app.controller("SucursalBancariaInsertController", ["$scope", "$http", function($scope, $http) {

        $scope.visible = {
            insert: true,
            update: false,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false
        };

        

        $scope.insert = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/SucursalBancaria/",
                data: $scope.sucursalBancaria
            }).success(function(data) {
                alert("La nueva sucursal bancaria ha sido insertada correctamente...");
                $scope.sucursalBancaria = data;
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

        $scope.sucursalBancaria = {
            idSucursalBancaria:$routeParams.idSucursalBancaria
        };

        $scope.get = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria
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
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria,
                data: $scope.sucursalBancaria
            }).success(function(data) {
                alert("Los datos de la sucursal nº " + $scope.sucursalBancaria.idSucursalBancaria + " se han actualizado correctamente...");
                $scope.sucursalBancaria = data;
            }).error(function(status) {
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

        $scope.sucursalBancaria = {
            idSucursalBancaria:$routeParams.idSucursalBancaria
        };

        $scope.get = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria
            }).success(function(data) {
                $scope.sucursalBancaria = data;
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

        $scope.get();


        $scope.deleteData = function() {
            $http({
                method: "DELETE",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria
            }).success(function() {
                alert("La sucursal bancaria nº " + $routeParams.idSucursalBancaria + " ha sido borrada correctamente...");
                $scope.sucursalBancaria = {};
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error:" + status);
            });
        };

    }]);
