app.controller("ClienteInsertController", ["$scope", "$http", "$location", "$routeParams", "$rootScope", function ($scope, $http, $location, $routeParams, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";


        //Para el ng-Options
        $scope.cliente = {};

        $scope.insert = function () {
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
        };

//        $scope.findAll = function () {
//            $http({
//                method: "GET",
//                url: contextPath + "/api/CuentaBancaria"
//            }).success(function (data) {
//                $scope.cuentasBancarias = data;
//                for (var i = 0; i < $scope.cuentasBancarias.length; i++) {
//                    var cuentaBancaria = $scope.cuentasBancarias[i];
//                    if (cuentaBancaria.idCuentaBancaria === ($routeParams.idCuentaBancaria*1)) {
//                        $scope.cliente.cuentaBancaria = cuentaBancaria;
//                        $scope.insertdesdedetail = {
//                            accion: 'insertardesdedetail'
//                        };
//                    }
//                }
//
//            }).error(function () {
//                alert("Error: no se ha podido realizar la operación");
//            });
//        };
//
//        $scope.findAll();


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

        $scope.update = function () {
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

//        $scope.findAll = function () {
//            $http({
//                method: "GET",
//                url: contextPath + "/api/EntidadBancaria"
//            }).success(function (data) {
//                $scope.entidadesBancarias = data;
//                for (var i = 0; i < $scope.entidadesBancarias.length; i++) {
//                    var fecha = $scope.entidadesBancarias[i].fechaCreacionEntidadBancaria;
//                    $scope.entidadesBancarias[i].fechaCreacionEntidadBancaria = new Date(fecha);
//                }
//            }).error(function () {
//                alert("Error: no se ha podido realizar la operación");
//            });
//        };
//
//        $scope.findAll();

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

//        $scope.entidadesBancarias = [];

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $scope.cliente.idCliente
            }).success(function (data) {
                $scope.cliente = data;
//                $scope.entidadesBancarias[0] = $scope.sucursalBancaria.entidadBancaria;
//                $scope.entidadBancaria.idEntidadBancaria = $scope.entidadesBancarias[0].idEntidadBancaria;

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

        $scope.findAllCuentasBySucursal();

    }]);