app.controller("EmpleadoInsertController", ["$scope", "$http", "$location", "$rootScope", "$routeParams", function ($scope, $http, $location, $rootScope, $routeParams) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";

        $scope.irLista = function () {
            $location.path("/empleado/list");
        };


        $scope.findSucursalesByEntidad = function (idEntidadBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + idEntidadBancaria + "/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllEntidades = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                $scope.entidadesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        $scope.findAllEntidades();


        $scope.insert = function () {
            $http({
                method: "POST",
                data: $scope.empleadoEdit,
                url: contextPath + "/api/Empleado"
            }).success(function (data) {
                $scope.empleadoEdit = data;
                $scope.empleadoEdit = null;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });//success.Error
        };//Consultar
    }]);


app.controller("EmpleadoUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estilo = "";

        $scope.empleadoEdit = {
            idEmpleado: $routeParams.idEmpleado
        };

        $scope.irLista = function () {
            $location.path("/empleado/list");
        };


        $scope.findSucursalesByEntidad = function (idEntidadBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + idEntidadBancaria + "/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllEntidades = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                $scope.entidadesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        $scope.findAllEntidades();


        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Empleado/" + $scope.empleadoEdit.idEmpleado
            }).success(function (data) {
                $scope.empleadoEdit = data;
                $scope.findSucursalesByEntidad($scope.empleadoEdit.sucursalBancaria.entidadBancaria.idEntidadBancaria);
//                alert(JSON.stringify($scope.empleadoEdit));
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();


        $scope.update = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/Empleado/" + $scope.empleadoEdit.idEmpleado,
                data: $scope.empleadoEdit
            }).success(function () {
                $scope.empleadoEdit = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);

app.controller("EmpleadoDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

        $scope.empleadoEdit = {
            idEmpleado: $routeParams.idEmpleado
        };

        $scope.irLista = function () {
            $location.path("/empleado/list");
        };


        $scope.findSucursalesByEntidad = function (idEntidadBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + idEntidadBancaria + "/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllEntidades = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                $scope.entidadesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        $scope.findAllEntidades();


        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Empleado/" + $scope.empleadoEdit.idEmpleado
            }).success(function (data) {
                $scope.empleadoEdit = data;
                $scope.findSucursalesByEntidad($scope.empleadoEdit.sucursalBancaria.entidadBancaria.idEntidadBancaria);
//                alert(JSON.stringify($scope.empleadoEdit));
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };
        $scope.get();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Empleado/" + $scope.empleadoEdit.idEmpleado
            }).success(function () {
                $scope.empleadoEdit = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
    }]);

