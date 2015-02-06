app.controller("CuentaBancariaInsertController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";

        $scope.cuentaBancaria = {};
        $scope.clientes = [];
        

        $scope.insert = function () {
            $http({
                method: "POST",
                data: $scope.cuentaBancaria,
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentaBancaria = {};
                $scope.findAll();
                $scope.clientes = [];
            }).error(function (data, status) {
                alert("Error: No se ha podido Insertar");
            });
        };
        var idSucursalBancaria=parseInt($routeParams.idSucursalBancaria);
        $scope.findClientesBySucursal = function (idSucursalBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" +idSucursalBancaria + "/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentasBancarias = data;
                for (var i = 0; i < $scope.cuentasBancarias.length; i++) {
                    if (i === 0) {
                        $scope.clientes[i] = $scope.cuentasBancarias[i].cliente;
                    } else {
                        add = 0;
                        for (var j = 0; j < $scope.clientes.length; j++) {
                            if ($scope.clientes[j].idCliente !== $scope.cuentasBancarias[i].cliente.idCliente) {
                                add += 0;
                            } else {
                                add += 1;
                            }
                        }
                        if (add === 0) {
                            $scope.clientes[i] = $scope.cuentasBancarias[i].cliente;
                        }
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido listar las Sucursales");
            });

        };
        $scope.findAll = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
                for (var i = 0; i < $scope.sucursalesBancarias.length; i++) {
                    var sucursalBancaria = $scope.sucursalesBancarias[i];

                    if (sucursalBancaria.idSucursalBancaria === idSucursalBancaria) {
                        $scope.cuentaBancaria.sucursalBancaria = sucursalBancaria;
                        $scope.findClientesBySucursal(idSucursalBancaria);
                        $scope.insertdesdedetail = {
                            accion: 'insertardesdedetail'
                        };
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido listar las Sucursalesaaaaaa");
            });

        };
        $scope.findAll();
    }]);

app.controller("CuentaBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estilo = "";

        $scope.cuentaBancaria = {
            idCuentaBancaria: $routeParams.idCuentaBancaria
        };

        $scope.sucursalBancaria = {
            idSucursalBancaria: ""
        };
        
        $scope.clientes = [];


        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function (data) {
                $scope.cuentaBancaria = data;
                $scope.sucursalBancaria.idSucursalBancaria = $scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria;
                $scope.findClientesBySucursal($scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria);
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };
        $scope.get();

        $scope.findAllMovimientosByCuenta = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria + "/MovimientoBancario"
            }).success(function (data) {
                $scope.movimientosBancarios = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        $scope.findAllMovimientosByCuenta();

        var idSucursalBancaria=parseInt($routeParams.idSucursalBancaria);
        $scope.findClientesBySucursal = function (idSucursalBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" +idSucursalBancaria + "/CuentaBancaria"
            }).success(function (data) {
                $scope.clientes=[];
                $scope.cuentasBancarias = data;
                for (var i = 0; i < $scope.cuentasBancarias.length; i++) {
                    if (i === 0) {
                        $scope.clientes[i] = $scope.cuentasBancarias[i].cliente;
                    } else {
                        add = 0;
                        for (var j = 0; j < $scope.clientes.length; j++) {
                            if ($scope.clientes[j].idCliente !== $scope.cuentasBancarias[i].cliente.idCliente) {
                                add += 0;
                            } else {
                                add += 1;
                            }
                        }
                        if (add === 0) {
                            $scope.clientes[i] = $scope.cuentasBancarias[i].cliente;
                        }
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido listar las Sucursales");
            });

        };
        $scope.findAll = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
                for (var i = 0; i < $scope.sucursalesBancarias.length; i++) {
                    var sucursalBancaria = $scope.sucursalesBancarias[i];

                    if (sucursalBancaria.idSucursalBancaria === idSucursalBancaria) {
                        $scope.cuentaBancaria.sucursalBancaria = sucursalBancaria;
                        $scope.findClientesBySucursal(idSucursalBancaria);
                        $scope.insertdesdedetail = {
                            accion: 'insertardesdedetail'
                        };
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido listar las Sucursalesaaaaaa");
            });

        };
        $scope.findAll();

        $scope.update = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria,
                data: $scope.cuentaBancaria
            }).success(function () {
                $scope.cuentaBancaria = {};
                $location.path("/cuentabancaria/list");
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);

app.controller("CuentaBancariaDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

        $scope.cuentaBancaria = {
            idCuentaBancaria: $routeParams.idCuentaBancaria
        };

        $scope.irLista = function () {
            $location.path("/cuentabancaria/list");
        };
        $scope.sucursalesBancarias = [];

        $scope.sucursalBancaria = {
            idSucursalBancaria: ""
        };
        
        $scope.clientes = [];
        
        
        

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function (data) {
                $scope.cuentaBancaria = data;
                $scope.sucursalBancaria.idSucursalBancaria = $scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria;
                $scope.findClientesBySucursal($scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria);
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };
        $scope.get();


        $scope.findAllMovimientosByCuenta = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria + "/MovimientoBancario"
            }).success(function (data) {
                $scope.movimientosBancarios = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        $scope.findAllMovimientosByCuenta();
        
        var idSucursalBancaria=parseInt($routeParams.idSucursalBancaria);
        $scope.findClientesBySucursal = function (idSucursalBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" +idSucursalBancaria + "/CuentaBancaria"
            }).success(function (data) {
                $scope.clientes=[];
                $scope.cuentasBancarias = data;
                for (var i = 0; i < $scope.cuentasBancarias.length; i++) {
                    if (i === 0) {
                        $scope.clientes[i] = $scope.cuentasBancarias[i].cliente;
                    } else {
                        add = 0;
                        for (var j = 0; j < $scope.clientes.length; j++) {
                            if ($scope.clientes[j].idCliente !== $scope.cuentasBancarias[i].cliente.idCliente) {
                                add += 0;
                            } else {
                                add += 1;
                            }
                        }
                        if (add === 0) {
                            $scope.clientes[i] = $scope.cuentasBancarias[i].cliente;
                        }
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido listar las Sucursales");
            });

        };
        $scope.findAll = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
                for (var i = 0; i < $scope.sucursalesBancarias.length; i++) {
                    var sucursalBancaria = $scope.sucursalesBancarias[i];

                    if (sucursalBancaria.idSucursalBancaria === idSucursalBancaria) {
                        $scope.cuentaBancaria.sucursalBancaria = sucursalBancaria;
                        $scope.findClientesBySucursal(idSucursalBancaria);
                        $scope.insertdesdedetail = {
                            accion: 'insertardesdedetail'
                        };
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido listar las Sucursalesaaaaaa");
            });

        };
        $scope.findAll();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function () {
                $scope.cuentaBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);

