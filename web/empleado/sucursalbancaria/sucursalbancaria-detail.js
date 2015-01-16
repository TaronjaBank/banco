app.controller("SucursalBancariaInsertController", ["$scope", "$http", "$location", function ($scope, $http, $location) {

        $scope.estado = {
            accion: 'insertar'
        };
        
        $scope.estilo = "";

        $scope.insert = function () {
            $http({
                method: "POST",
                url: contextPath + "/api/SucursalBancaria",
                data: $scope.sucursalBancaria
            }).success(function (data) {
                //alert("La nueva sucursal bancaria ha sido insertada correctamente...");
                $scope.sucursalBancaria = data;
                $scope.sucursalBancaria = null;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);




app.controller("SucursalBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", function ($scope, $http, $routeParams, $location) {

        $scope.estado = {
            accion: 'actualizar'
        };
        
        $scope.estilo = "";

        $scope.sucursalBancaria = {
            idSucursalBancaria: $routeParams.idSucursalBancaria
        };
        
        $scope.irLista = function() {
            $location.path("/sucursalbancaria/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria
            }).success(function (data) {
                $scope.sucursalBancaria = data;
                alert($scope.sucursalBancaria.entidadBancaria.idEntidadBancaria);
        }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();


        $scope.update = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria,
                data: $scope.sucursalBancaria
            }).success(function () {
                //alert("Los datos de la sucursal nº " + $scope.sucursalBancaria.idSucursalBancaria + " se han actualizado correctamente...");
                $scope.sucursalBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);




app.controller("SucursalBancariaDeleteController", ["$rootScope","$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {

        $scope.estado = {
            accion: 'borrar'
        };
        
        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

        $scope.sucursalBancaria = {
            idSucursalBancaria: $routeParams.idSucursalBancaria
        };
        
        $scope.irLista = function() {
            $location.path("/sucursalbancaria/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria
            }).success(function (data) {
                $scope.sucursalBancaria = data;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();


        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria
            }).success(function () {
                //alert("La sucursal bancaria nº " + $routeParams.idSucursalBancaria + " ha sido borrada correctamente...");
                $scope.sucursalBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);
