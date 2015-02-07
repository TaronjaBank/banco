app.controller("SucursalBancariaInsertController", ["$scope", "$http", "$location", "$routeParams", "$rootScope", function ($scope, $http, $location, $routeParams, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.insertdesdedetail = {
            accionDesdeEntidad: false
        };

        $scope.estilo = "";

        if ($routeParams.idEntidadBancaria) {
            $scope.estiloDisabledNombreEntidad = $rootScope.estiloBloqueado;
        }

        $scope.sucursalBancaria = {};

        $scope.errorValidacion = false;


        $scope.insert = function () {
            if (!$scope.formularioSucursal.$error.required
                    && !$scope.formularioSucursal.$error.pattern) {
                $http({
                    method: "POST",
                    url: contextPath + "/api/SucursalBancaria",
                    data: $scope.sucursalBancaria
                }).success(function (data) {
                    $scope.sucursalBancaria = data;
                    $scope.sucursalBancaria = null;
                }).error(function () {
                    alert("Error: no se ha podido realizar la operación");
                });
                $scope.errorValidacion = false;
            } else {
                $scope.errorValidacion = true;
            }
        };

        $scope.findAll = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                $scope.entidadesBancarias = data;
                for (var i = 0; i < $scope.entidadesBancarias.length; i++) {
                    var entidadBancaria = $scope.entidadesBancarias[i];
                    var fecha = entidadBancaria.fechaCreacionEntidadBancaria;
                    entidadBancaria.fechaCreacionEntidadBancaria = new Date(fecha);
                    if (entidadBancaria.idEntidadBancaria === ($routeParams.idEntidadBancaria * 1)) {
                        $scope.sucursalBancaria.entidadBancaria = entidadBancaria;
                        $scope.insertdesdedetail.accionDesdeEntidad = true;
                    }
                }

            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAll();


    }]);

app.controller("SucursalBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estilo = "";

        $scope.sucursalBancaria = {
            idSucursalBancaria: $routeParams.idSucursalBancaria
        };

        $scope.irLista = function () {
            $location.path("/sucursalbancaria/list");
        };

        $scope.errorValidacion = false;


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

        $scope.findAllCuentasBySucursal = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria + "/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentasBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllCuentasBySucursal();

        $scope.findAllEmpleadosBySucursal = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria + "/Empleado"
            }).success(function (data) {
                $scope.empleados = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllEmpleadosBySucursal();

        $scope.findAllEntidades = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                $scope.entidadesBancarias = data;
                for (var i = 0; i < $scope.entidadesBancarias.length; i++) {
                    var fecha = $scope.entidadesBancarias[i].fechaCreacionEntidadBancaria;
                    $scope.entidadesBancarias[i].fechaCreacionEntidadBancaria = new Date(fecha);
                }
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllEntidades();

        $scope.update = function () {
            if (!$scope.formularioSucursal.$error.required
                    && !$scope.formularioSucursal.$error.pattern) {
                $http({
                    method: "PUT",
                    url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria,
                    data: $scope.sucursalBancaria
                }).success(function () {
                    $scope.sucursalBancaria = {};
                    $scope.irLista();
                }).error(function () {
                    alert("Error: no se ha podido realizar la operación");
                });
                $scope.errorValidacion = false;
            } else {
                $scope.errorValidacion = true;
            }
        };

    }]);


app.controller("SucursalBancariaDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estiloDisabledNombreEntidad = $rootScope.estiloBloqueado;
        $scope.estilo = $rootScope.estiloBloqueado;

        $scope.sucursalBancaria = {
            idSucursalBancaria: $routeParams.idSucursalBancaria
        };

        $scope.irLista = function () {
            $location.path("/sucursalbancaria/list");
        };

        $scope.entidadesBancarias = [];

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria
            }).success(function (data) {
                $scope.sucursalBancaria = data;
                $scope.entidadesBancarias[0] = $scope.sucursalBancaria.entidadBancaria;
                $scope.entidadBancaria.idEntidadBancaria = $scope.entidadesBancarias[0].idEntidadBancaria;

            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();

        $scope.findAllCuentasBySucursal = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria + "/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentasBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllCuentasBySucursal();

        $scope.findAllEmpleadosBySucursal = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria + "/Empleado"
            }).success(function (data) {
                $scope.empleados = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllEmpleadosBySucursal();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/SucursalBancaria/" + $scope.sucursalBancaria.idSucursalBancaria
            }).success(function () {
                $scope.sucursalBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);