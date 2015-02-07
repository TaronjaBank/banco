app.controller("ClienteInsertController", ["$scope", "$http", "$location", "$routeParams", "$rootScope", function ($scope, $http, $location, $routeParams, $rootScope) {

        $rootScope.comprobarSesion();

        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";

        $scope.cliente = {};

        $scope.errorValidacion = false;


        $scope.comprobarValidaciones = function () {
            if (!$scope.formularioCliente.$error.required
                    && !$scope.formularioCliente.$error.pattern) {
                $scope.errorValidacion = false;
            } else {
                $scope.errorValidacion = true;
            }
            return $scope.errorValidacion;
        };

        $scope.insert = function () {
            if ($scope.comprobarValidaciones() === false) {
                $http({
                    method: "POST",
                    url: contextPath + "/api/Cliente",
                    data: $scope.cliente
                }).success(function (data) {
                    $scope.cliente = data;
                    $scope.cliente = null;
                }).error(function () {
                    alert("Error: no se ha podido realizar la operación");
                });
            } else {
                $("#contenedorFormularioDetail input").keyup(function () {
                    $scope.comprobarValidaciones();
                });
                $(".validacion-caja-mensajes").slideDown(300, "linear");
            }
        };

    }]);


app.controller("ClienteUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {

        $rootScope.comprobarSesion();

        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estilo = "";

        $scope.cliente = {
            idCliente: $routeParams.idCliente
        };

        $scope.errorValidacion = false;

        $scope.irLista = function () {
            $location.path("/cliente/list");
        };

        $scope.get = function () {

            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente
            }).success(function (data) {
                $scope.cliente = data;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };
        $scope.get();


        $scope.comprobarValidaciones = function () {
            if (!$scope.formularioCliente.$error.required
                    && !$scope.formularioCliente.$error.pattern) {
                $scope.errorValidacion = false;
            } else {
                $scope.errorValidacion = true;
            }
            return $scope.errorValidacion;
        };

        $scope.update = function () {
            if ($scope.comprobarValidaciones() === false) {
                $http({
                    method: "PUT",
                    url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente,
                    data: $scope.cliente
                }).success(function () {
                    $scope.cliente = {};
                    $scope.irLista();
                }).error(function () {
                    alert("Error: no se ha podido realizar la operación");
                });
            } else {
                $("#contenedorFormularioDetail input").keyup(function () {
                    $scope.comprobarValidaciones();
                });
                $(".validacion-caja-mensajes").slideDown(300, "linear");
            }
        };

        $scope.findAllCuentasByCliente = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente + "/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentasBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllCuentasByCliente();

    }]);


app.controller("ClienteDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

        $scope.cliente = {
            idCliente: $routeParams.idCliente
        };

        $scope.irLista = function () {
            $location.path("/cliente/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente
            }).success(function (data) {
                $scope.cliente = data;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente
            }).success(function () {
                $scope.cliente = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllCuentasByCliente = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente + "/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentasBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllCuentasByCliente();

    }]);