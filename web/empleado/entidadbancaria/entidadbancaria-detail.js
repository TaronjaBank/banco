app.controller("EntidadBancariaInsertController", ["$scope", "$http", "$location", function ($scope, $http, $location) {

        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";

        $scope.irLista = function () {
            $location.path("/entidadbancaria/list");
        };

        hoy = new Date();
        $scope.entidadBancaria = {
            fechaCreacionEntidadBancaria: hoy.getFullYear() + "-" + (hoy.getMonth() + 1) + "-" + hoy.getDate()
        };

        $scope.insert = function () {
            $http({
                method: "POST",
                data: $scope.entidadBancaria,
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                //alert("La nueva entidad bancaria ha sido insertada correctamente...");
                $scope.entidadBancaria = data;
                $scope.entidadBancaria = null;
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
                var fecha = new Date($scope.entidadBancaria.fechaCreacionEntidadBancaria);
                $scope.entidadBancaria.fechaCreacionEntidadBancaria = fecha.getFullYear() + "-" + (fecha.getMonth()+1) + "-" + fecha.getDate();
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
                //alert("Los datos de la entidad nº " + $scope.entidadBancaria.idEntidadBancaria + " se han actualizado correctamente...");
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
                var fecha = new Date($scope.entidadBancaria.fechaCreacionEntidadBancaria);
                $scope.entidadBancaria.fechaCreacionEntidadBancaria = fecha.getFullYear() + "-" + (fecha.getMonth()+1) + "-" + fecha.getDate();
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });//success.Error
        };//Consultar

        $scope.get();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function () {
                //alert("La entidad bancaria nº " + $scope.entidadBancaria.idEntidadBancaria + " ha sido borrada correctamente...");
                $scope.entidadBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });//success.Error
        };//Consultar
    }]);
