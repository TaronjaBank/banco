app.controller("EntidadBancariaInsertController", ["$scope", "$http", function ($scope, $http) {

        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";

        $scope.entidadBancaria = {
            fechaCreacionEntidadBancaria: new Date()
        };

        $scope.insert = function () {
            $http({
                method: "POST",
                data: $scope.entidadBancaria,
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                $scope.entidadBancaria = data;
                $scope.entidadBancaria = null;
                $scope.entidadBancaria = {
                    fechaCreacionEntidadBancaria: new Date()
                };
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
    }]);


app.controller("EntidadBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", function ($scope, $http, $routeParams, $location) {

        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estilo = "";

        $scope.entidadBancaria = {
            idEntidadBancaria: $routeParams.idEntidadBancaria
        };

        $scope.irLista = function () {
            $location.path("/entidadbancaria/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function (data) {
                $scope.entidadBancaria = data;
                $scope.entidadBancaria.fechaCreacionEntidadBancaria = new Date($scope.entidadBancaria.fechaCreacionEntidadBancaria);
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();


        $scope.update = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria,
                data: $scope.entidadBancaria
            }).success(function () {
                $scope.entidadBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);

app.controller("EntidadBancariaDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {

        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

        $scope.entidadBancaria = {
            idEntidadBancaria: $routeParams.idEntidadBancaria
        };

        $scope.irLista = function () {
            $location.path("/entidadbancaria/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function (data) {
                $scope.entidadBancaria = data;
                $scope.entidadBancaria.fechaCreacionEntidadBancaria = new Date($scope.entidadBancaria.fechaCreacionEntidadBancaria);
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function () {
                $scope.entidadBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
    }]);
