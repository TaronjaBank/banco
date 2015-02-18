app.controller("CuentaBancariaInsertController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {

        $scope.estado = {
            accion: 'insertar'
        };

        $scope.bloqueo = {
            dniCliente: true
        };

        $scope.estiloNumCuenta = $rootScope.estiloBloqueado;
        $scope.estiloSucursal = "";
        $scope.estiloCliente = $rootScope.estiloBloqueado;

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


        //Comportamiento en función al parámetro de la URL
        if (($routeParams.idSucursalBancaria) && (!$routeParams.idCliente)) {
            $scope.estiloSucursal = $rootScope.estiloBloqueado;
            $scope.insertdesdedetail.accionDesdeSucursal = true;
        } else if ((!$routeParams.idSucursalBancaria) && ($routeParams.idCliente)) {
            $scope.cuentaBancaria.cliente.idCliente = parseInt($routeParams.idCliente);
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
            if (idSucursalBancaria === undefined) {
                $scope.clientes = [];
                
                $scope.cuentaBancaria.numeroCuentaBancaria = "";
                $scope.estiloCliente = $rootScope.estiloBloqueado;
                $scope.bloqueo.dniCliente = true;
            } else {
                $http({
                    method: "GET",
                    url: contextPath + "/api/SucursalBancaria/" + idSucursalBancaria
                }).success(function (data) {
                    $scope.sucursalBancaria = data;
                    var sucursal = $scope.sucursalBancaria;
                    var codigoEntidad = sucursal.entidadBancaria.codigoEntidadBancaria;
                    var codigoSucursal = sucursal.codigoSucursalBancaria;
                    $scope.cuentaBancaria.numeroCuentaBancaria = codigoEntidad + "-" + codigoSucursal + "-" + ("000" + ($scope.lastIdCuenta + 1)).slice(-4);
                    $scope.bloqueo.dniCliente = false;

                    if (!$routeParams.idCliente) {
                        $scope.findClientesBySucursal(sucursal.idSucursalBancaria);
                        $scope.estiloCliente = "";
                    }
                }).error(function () {
                    alert("Error: no existe coincidencia en la base de datos");
                });
            }
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


        $scope.insert = function () {
            if(isNaN($scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria)){
                $scope.cuentaBancaria={};
            }
            $scope.mostrarValidaciones = true;
           $(".validacion-caja-mensajes").fadeIn(500, "linear");
           if (!$scope.formularioCuentaBancaria.$invalid) {
                $http({
                    method: "POST",
                    data: $scope.cuentaBancaria,
                    url: contextPath + "/api/CuentaBancaria"
                }).success(function (data) {
                    $scope.cuentaBancaria = {};
                    $scope.findAllSucursales();
                    $scope.clientes = [];
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

        promise.then(function (status) {
            if (status === 200) {
                $scope.findClientes();
                $scope.findAllSucursales();
                $scope.getLastIdCuenta();
            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function (error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

    }]);

app.controller("CuentaBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {

        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estiloNumCuenta = $rootScope.estiloBloqueado;
        $scope.estiloSucursal = $rootScope.estiloBloqueado;

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
                alert("Error: no se ha podido listar las Sucursalesaaaaaa");
            });

        };



        $scope.update = function () {
              alert($scope.cuentaBancaria.cliente.idCliente);
            $scope.mostrarValidaciones = true;
            $(".validacion-caja-mensajes").fadeIn(500, "linear");

            if (!$scope.formularioCuentaBancaria.$invalid) {
              if($scope.cuentaBancaria.cliente.idCliente===undefined){
                 $scope.cuentaBancaria.cliente=null; 
              }
                $http({
                    method: "PUT",
                    url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria,
                    data: $scope.cuentaBancaria
                }).success(function () {
                    $scope.cuentaBancaria = {};
                    $location.path("/cuentabancaria/list");
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

        promise.then(function (status) {
            if (status === 200) {
                $scope.get();
                $scope.findAllMovimientosByCuenta();
                $scope.findAllSucursales();

            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function (error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

    }]);

app.controller("CuentaBancariaDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {

        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estiloNumCuenta = $rootScope.estiloBloqueado;
        $scope.estiloSucursal = $rootScope.estiloBloqueado;
        $scope.estiloCliente = $rootScope.estiloBloqueado;

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

        var promise = $rootScope.comprobarSesion();

        promise.then(function (status) {
            if (status === 200) {
                $scope.get();
                $scope.findAllMovimientosByCuenta();
                $scope.findAllSucursales();

            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function (error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

    }]);

