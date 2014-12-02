app.controller("EntidadBancariaInsertController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.visible = {
            insert: true,
            update: false,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false,
            estadoFecha: true
        };
        
        hoy=new Date();
        $scope.entidadBancaria={
            fechaCreacionEntidadBancaria:hoy.getFullYear()+"-"+hoy.getMonth()+"-"+hoy.getDate()
        };

        $scope.insert = function () {
            $http({
                method: "POST",
                data: $scope.entidadBancaria,
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                alert("La nueva entidad bancaria ha sido insertada correctamente...");
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
            estado: false,
            estadoFecha: true
        };

        $scope.entidadBancaria = {
            idEntidadBancaria:$routeParams.idEntidadBancaria
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
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
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria,
                data: $scope.entidadBancaria
            }).success(function (data) {
                alert("Los datos de la entidad nº " + $scope.entidadBancaria.idEntidadBancaria + " se han actualizado correctamente...");
                $scope.entidadBancaria = data;
            }).error(function (status) {
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
            estado: true,
            estadoFecha: true
        };

        $scope.entidadBancaria = {
            idEntidadBancaria:$routeParams.idEntidadBancaria
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
        
            $scope.get();
        
        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function () {
                alert("La entidad bancaria nº " + $scope.entidadBancaria.idEntidadBancaria + " ha sido borrada correctamente...");
                $scope.entidadBancaria = {};
            }).error(function () {
                alert("No se ha Borrado la Entidad");
            });//success.Error
        };//Consultar
    }]);
