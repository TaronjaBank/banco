app.controller("ClienteInsertController", ["$scope", "$http", "$location", "$routeParams", "$rootScope", function($scope, $http, $location, $routeParams, $rootScope) {

        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";

        $scope.cliente = {};


        $scope.insert = function() {
            $scope.mostrarValidaciones = true;
            $(".validacion-caja-mensajes").fadeIn(500, "linear");

            if (!$scope.formularioCliente.$invalid) {
                $http({
                    method: "POST",
                    url: contextPath + "/api/Cliente",
                    data: $scope.cliente
                }).success(function(data) {
                    $scope.cliente = data;
                    $scope.cliente = {};
                    $scope.mostrarValidaciones = false;
                }).error(function(data, status) {
                    if (status === 400) {
                        $scope.bussinessMessageList = data;
                        $scope.mostrarValidacionesServidor = true;
                        $(".validacion-caja-mensajes").fadeIn(500, "linear");
                    } else {
                        alert("Error: no se ha podido realizar la operación");
                    }
                });
            }
        };

        var promise = $rootScope.comprobarSesion();

        promise.then(function(status) {
            if (status === 200) {

            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function(error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

    }]);


app.controller("ClienteUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function($scope, $http, $routeParams, $location, $rootScope) {



        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estilo = "";

        $scope.cliente = {
            idCliente: $routeParams.idCliente
        };

        $scope.irLista = function() {
            $location.path("/cliente/list");
        };

        $scope.get = function() {

            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente
            }).success(function(data) {
                $scope.cliente = data;
            }).error(function() {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };



        $scope.update = function() {
            $scope.mostrarValidaciones = true;
            $(".validacion-caja-mensajes").fadeIn(500, "linear");

            if (!$scope.formularioCliente.$invalid) {
                $http({
                    method: "PUT",
                    url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente,
                    data: $scope.cliente
                }).success(function() {
                    $scope.cliente = {};
                    $scope.irLista();
                }).error(function(data, status) {
                    if (status === 400) {
                        $scope.bussinessMessageList = data;
                        $scope.mostrarValidacionesServidor = true;
                        $(".validacion-caja-mensajes").fadeIn(500, "linear");
                    } else {
                        alert("Error: no se ha podido realizar la operación");
                    }
                });
            }
        };

        $scope.findAllCuentasByCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente + "/CuentaBancaria"
            }).success(function(data) {
                $scope.cuentasBancarias = data;
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };


        var promise = $rootScope.comprobarSesion();

        promise.then(function(status) {
            if (status === 200) {
                $scope.get();
                $scope.findAllCuentasByCliente();
            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function(error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });
    }]);


app.controller("ClienteDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function($rootScope, $scope, $http, $routeParams, $location) {

        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

        $scope.cliente = {
            idCliente: $routeParams.idCliente
        };

        $scope.irLista = function() {
            $location.path("/cliente/list");
        };

        $scope.get = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente
            }).success(function(data) {
                $scope.cliente = data;
            }).error(function() {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };



        $scope.deleteData = function() {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente
            }).success(function() {
                $scope.cliente = {};
                $scope.irLista();
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllCuentasByCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente + "/CuentaBancaria"
            }).success(function(data) {
                $scope.cuentasBancarias = data;
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };


        var promise = $rootScope.comprobarSesion();

        promise.then(function(status) {
            if (status === 200) {
                $scope.get();
                $scope.findAllCuentasByCliente();
            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function(error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });
    }]);
