app.controller("CuentaBancariaInsertController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estiloDisabledNumCuenta = $rootScope.estiloBloqueado;
        $scope.estiloDisabledSucursal = "";
        $scope.estiloDisabledCliente = "";

        $scope.insertdesdedetail = {
            accionDesdeSucursal: false,
            accionDesdeCliente: false
        };

        $scope.cuentaBancaria = {
            sucursalBancaria: {
                idSucursalBancaria: parseInt($routeParams.idSucursalBancaria)
            },
            cliente: {
                idCliente: ""
            }
        };
        $scope.lastIdCuenta = -1;

        $scope.clientes = [];

        $scope.errorValidacion = false;

        var idSucursalBancaria = $scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria;


        $scope.findClientes = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente"
            }).success(function (data) {
                $scope.clientes = data;
            }).error(function () {
                alert("Error: no se ha podido listar los clientes");
            });
        };
        $scope.findClientes();


        //Comportamiento en función al parámetro de la URL
//        alert("idSucursal: " + $routeParams.idSucursalBancaria + "; idCliente: " + $routeParams.idCliente);
        if (($routeParams.idSucursalBancaria) && (!$routeParams.idCliente)) {
            $scope.estiloDisabledSucursal = $rootScope.estiloBloqueado;
            $scope.insertdesdedetail.accionDesdeSucursal = true;
        } else if ((!$routeParams.idSucursalBancaria) && ($routeParams.idCliente)) {
            $scope.cuentaBancaria.cliente.idCliente = parseInt($routeParams.idCliente);
            $scope.estiloDisabledCliente = $rootScope.estiloBloqueado;
            $scope.insertdesdedetail.accionDesdeCliente = true;
        } else if (($routeParams.idSucursalBancaria) && ($routeParams.idCliente)) {
            throw new error("ambos parámetros tienen valor!");
        } else if ((!$routeParams.idSucursalBancaria) && (!$routeParams.idCliente)) {
//            throw new error("ningún parámetro tiene valor!");
        } else {
            throw new error("falta alguna opción por considerar!");
        }


        //Operaciones a realizar al cambiar selección del ng-options de sucursales
        $scope.fromChangeSucursal = function (idSucursalBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + idSucursalBancaria
            }).success(function (data) {
                $scope.sucursalBancaria = data;
//                alert(JSON.stringify($scope.sucursalBancaria));
                var sucursal = $scope.sucursalBancaria;
                var codigoEntidad = sucursal.entidadBancaria.codigoEntidadBancaria;
                var codigoSucursal = sucursal.codigoSucursalBancaria;
                $scope.cuentaBancaria.numeroCuentaBancaria = codigoEntidad + "-" + codigoSucursal + "-" + ($scope.lastIdCuenta + 1);

                if (!$routeParams.idCliente) {
                    $scope.findClientesBySucursal(sucursal.idSucursalBancaria);
                }
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };


        $scope.findClientesBySucursal = function (idSucursalBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + idSucursalBancaria + "/CuentaBancaria"
            }).success(function (data) {
                $scope.clientes = [];
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


        $scope.findAllSucursales = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
                for (var i = 0; i < $scope.sucursalesBancarias.length; i++) {
                    var sucursalBancaria = $scope.sucursalesBancarias[i];
                    if (sucursalBancaria.idSucursalBancaria === idSucursalBancaria) {
                        $scope.cuentaBancaria.sucursalBancaria = sucursalBancaria;
                        $scope.fromChangeSucursal(sucursalBancaria.idSucursalBancaria);
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido listar las Sucursales");
            });
        };
        $scope.findAllSucursales();


        $scope.getLastIdCuenta = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                var cuentas = data;
                for (var i = 0; i < cuentas.length; i++) {
                    if (cuentas[i].idCuentaBancaria > $scope.lastIdCuenta) {
                        $scope.lastIdCuenta = cuentas[i].idCuentaBancaria;
                    }
                }
            }).error(function () {
                alert("Error: no se han podido listar las cuentas bancarias");
            });
        };
        $scope.getLastIdCuenta();


        $scope.comprobarValidaciones = function () {
//            alert("estoy en $scope.comprobarValidaciones");
            if (!$scope.formularioCuentaBancaria.$error.required) {
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
                    data: $scope.cuentaBancaria,
                    url: contextPath + "/api/CuentaBancaria"
                }).success(function (data) {
                    $scope.cuentaBancaria = {};
                    $scope.findAllSucursales();
                    $scope.clientes = [];
                    $scope.lastIdCuenta++;
                }).error(function (data, status) {
                    alert("Error: No se ha podido Insertar");
                });
            } else {
                $("#contenedorFormularioDetail input").keyup(function () {
                    $scope.comprobarValidaciones();
                });
                $("#contenedorFormularioDetail select").change(function () {
//                    alert("estoy en change");
                    $scope.comprobarValidaciones();
                });
                $(".validacion-caja-mensajes").slideDown(300, "linear");
            }
        };

    }]);

app.controller("CuentaBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estiloDisabledNumCuenta = $rootScope.estiloBloqueado;
        $scope.estiloDisabledSucursal = $rootScope.estiloBloqueado;

        $scope.cuentaBancaria = {
            idCuentaBancaria: $routeParams.idCuentaBancaria
        };

        $scope.sucursalBancaria = {
            idSucursalBancaria: ""
        };

        $scope.clientes = [];

        $scope.errorValidacion = false;


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

        var idSucursalBancaria = parseInt($routeParams.idSucursalBancaria);
        $scope.findClientesBySucursal = function (idSucursalBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + idSucursalBancaria + "/CuentaBancaria"
            }).success(function (data) {
                $scope.clientes = [];
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
        $scope.findAllSucursales = function () {
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
                alert("Error: no se ha podido listar las Sucursales");
            });

        };
        $scope.findAllSucursales();

        $scope.comprobarValidaciones = function () {
            if (!$scope.formularioCuentaBancaria.$error.required) {
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
                    url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria,
                    data: $scope.cuentaBancaria
                }).success(function () {
                    $scope.cuentaBancaria = {};
                    $location.path("/cuentabancaria/list");
                }).error(function () {
                    alert("Error: no se ha podido realizar la operación");
                });
            } else {
                $("#contenedorFormularioDetail input").keyup(function () {
                    $scope.comprobarValidaciones();
                });
                $("#contenedorFormularioDetail select").change(function () {
                    $scope.comprobarValidaciones();
                });
                $(".validacion-caja-mensajes").slideDown(300, "linear");
            }
        };

    }]);

app.controller("CuentaBancariaDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estiloDisabledNumCuenta = $rootScope.estiloBloqueado;
        $scope.estiloDisabledSucursal = $rootScope.estiloBloqueado;
        $scope.estiloDisabledCliente = $rootScope.estiloBloqueado;

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

        $scope.errorValidacion = false;


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

        var idSucursalBancaria = parseInt($routeParams.idSucursalBancaria);
        $scope.findClientesBySucursal = function (idSucursalBancaria) {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + idSucursalBancaria + "/CuentaBancaria"
            }).success(function (data) {
                $scope.clientes = [];
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

        $scope.findAllSucursales = function () {
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
                alert("Error: no se ha podido listar las Sucursales");
            });

        };
        $scope.findAllSucursales();

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

