app.controller("EntidadBancariaInsertController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

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
                data: $scope.entidadBancaria,
                url: contextPath + "/api/EntidadBancaria/"
            }).success(function (data) {
                alert("Se ha Insertado la Entidad");
                $scope.entidadBancaria = data;
            }).error(function () {
                alert("No se ha Borrado la Entidad");
            });//success.Error
        };//Consultar
    }]);


app.controller("EntidadBancariaUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.visible = {
            insert: false,
            update: true,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false
        };

        $scope.entidadBancaria = {};

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $routeParams.idEntidadBancaria
            }).success(function (data) {
                $scope.entidadBancaria = data;
            }).error(function (status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

        $scope.get();


        $scope.update = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/EntidadBancaria/" + $routeParams.idEntidadBancaria,
                data: $scope.entidadBancaria
            }).success(function (data, status, headers, config) {
                $scope.entidadBancaria = data;
                alert("Los datos de la entidad nº " + $routeParams.idEntidadBancaria + " se han actualizado correctamente...");
            }).error(function (data, status, headers, config) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

    }]);

app.controller("EntidadBancariaDeleteController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.visible = {
            insert: false,
            update: false,
            delete: true
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: true
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function (data) {
                $scope.entidadBancaria = data;
            }).error(function () {
                alert("No existe la Entidad");
            });//success.Error
        };//Consultar
        if ($routeParams !== undefined) {
            $scope.entidadBancaria = {};
            $scope.entidadBancaria.idEntidadBancaria = $routeParams.idEntidadBancaria;
            $scope.get();
        }
        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function (data) {
                alert("Se ha borrado la Entidad: " + $routeParams.idEntidadBancaria);
                $scope.entidadBancaria = {};
            }).error(function () {
                alert("No se ha Borrado la Entidad");
            });//success.Error
        };//Consultar
    }]);
