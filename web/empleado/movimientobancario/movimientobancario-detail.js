app.controller("MovimientoBancarioInsertController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";

        $scope.irLista = function () {
            $location.path("/movimientobancario/list");
        };

        //ng-Options
        $scope.tipoMovimientos = [
            {ID: '0', nombre: 'DEBE'},
            {ID: '1', nombre: 'HABER'}
        ];

        $scope.movimientoBancario = {};

        $scope.errorValidacion = false;


        $scope.insert = function () {
            if (!$scope.formularioMovimiento.$error.required
                    && !$scope.formularioMovimiento.$error.pattern
                    && !$scope.formularioMovimiento.$error.number) {
                $http({
                    method: "POST",
                    url: contextPath + "/api/MovimientoBancario",
                    data: $scope.movimientoBancario
                }).success(function (data) {
                    $scope.movimientoBancario = data;
                    $scope.movimientoBancario = null;
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
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentasBancarias = data;
                for (var i = 0; i < $scope.cuentasBancarias.length; i++) {
                    var cuentaBancaria = $scope.cuentasBancarias[i];
                    if (cuentaBancaria.idCuentaBancaria === ($routeParams.idCuentaBancaria * 1)) {
                        $scope.movimientoBancario.cuentaBancaria = cuentaBancaria;
                        $scope.insertdesdedetail = {
                            accion: 'insertardesdedetail'
                        };
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        $scope.findAll();
    }]);

app.controller("MovimientoBancarioUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estilo = "";

        $scope.movimientoBancario = {
            idMovimientoBancario: $routeParams.idMovimientoBancario
        };

        $scope.irLista = function () {
            $location.path("/movimientobancario/list");
        };
        
        $scope.errorValidacion = false;


        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario
            }).success(function (data) {
                $scope.movimientoBancario = data;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();
        $scope.tipoMovimientos = [
            {ID: '0', nombre: 'DEBE'},
            {ID: '1', nombre: 'HABER'}
        ];
        
        $scope.update = function () {
            if (!$scope.formularioMovimiento.$error.required
                    && !$scope.formularioMovimiento.$error.pattern
                    && !$scope.formularioMovimiento.$error.number) {
                $http({
                    method: "PUT",
                    url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario,
                    data: $scope.movimientoBancario
                }).success(function () {
                    //alert("Los datos del movimiento nº " + $scope.movimientoBancario.idMovimientoBancario + " se han actualizado correctamente...");
                    $scope.movimientoBancario = {};
                    $scope.irLista();
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
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentasBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        $scope.findAll();

    }]);

app.controller("MovimientoBancarioDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

        $scope.movimientoBancario = {
            idMovimientoBancario: $routeParams.idMovimientoBancario
        };

        $scope.irLista = function () {
            $location.path("/movimientobancario/list");
        };
        $scope.cuentasBancarias = [];
        $scope.cuentaBancaria = {};
        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario
            }).success(function (data) {
                $scope.movimientoBancario = data;
                $scope.cuentasBancarias[0] = $scope.movimientoBancario.cuentaBancaria;
                $scope.cuentaBancaria.idCuentaBancaria = $scope.cuentasBancarias[0].idCuentaBancaria;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();
        $scope.tipoMovimientos = [
            {ID: '0', nombre: 'DEBE'},
            {ID: '1', nombre: 'HABER'}
        ];

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario
            }).success(function () {
                //alert("El movimiento nº " + $scope.movimientoBancario.idMovimientoBancario + " ha sido borrado correctamente...");
                $scope.movimientoBancario = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };


    }]);
