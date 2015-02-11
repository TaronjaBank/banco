app.controller("SucursalBancariaInsertController", ["$scope", "$http", "$location", "$routeParams", "$rootScope", function ($scope, $http, $location, $routeParams, $rootScope) {

        var promise = $rootScope.comprobarSesion();

        promise.then(function (status) {
            if (status === 200) {
                $scope.findAll();
            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function (error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";


        //Para el ng-Options
        $scope.sucursalBancaria = {};

        $scope.insert = function () {
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
                        $scope.insertdesdedetail = {
                            accion: 'insertardesdedetail'
                        };
                    }
                }

            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);

app.controller("SucursalBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {

        var promise = $rootScope.comprobarSesion();

        promise.then(function (status) {
            if (status === 200) {
                $scope.get();
                $scope.findAllCuentasBySucursal();
                $scope.findAllEmpleadosBySucursal();
                $scope.findAllEntidades();
            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function (error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

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

        $scope.update = function () {
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
        };

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

    }]);






app.controller("SucursalBancariaDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {

        var promise = $rootScope.comprobarSesion();

        promise.then(function (status) {
            if (status === 200) {
                $scope.get();
                $scope.findAllCuentasBySucursal();
                $scope.findAllEmpleadosBySucursal();
            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function (error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

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
    }]);