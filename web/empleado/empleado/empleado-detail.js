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
                data: $scope.empleado,
                url: contextPath + "/api/Empleado"
            }).success(function (data) {
                $scope.empleado = data;
                $scope.empleado = null;
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

        $scope.empleado = {
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
                url: contextPath + "/api/Empleado/" + $scope.empleado.idEmpleado
            }).success(function (data) {
                $scope.empleado = data;
                $scope.findSucursalesByEntidad($scope.empleado.sucursalBancaria.entidadBancaria.idEntidadBancaria);
//                alert(JSON.stringify($scope.empleado));
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();


        $scope.update = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/Empleado/" + $scope.empleado.idEmpleado,
                data: $scope.empleado
            }).success(function () {
                $scope.empleado = {};
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

        $scope.empleado = {
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
                url: contextPath + "/api/Empleado/" + $scope.empleado.idEmpleado
            }).success(function (data) {
                $scope.empleado = data;
                $scope.findSucursalesByEntidad($scope.empleado.sucursalBancaria.entidadBancaria.idEntidadBancaria);
//                alert(JSON.stringify($scope.empleado));
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });//success.Error
        };//Consultar
        $scope.get();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Empleado/" + $scope.empleado.idEmpleado
            }).success(function () {
                //alert("El empleado nº " + $scope.empleado.idEmpleado + " ha sido borrado correctamente...");
                $scope.empleado = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });//success.Error
        };//Consultar
    }]);

