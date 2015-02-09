app.controller("EmpleadoInsertController", ["$scope", "$http", "$location", "$rootScope", "$routeParams", function ($scope, $http, $location, $rootScope, $routeParams) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";
        $scope.estiloDisabled = "";

        $scope.irLista = function () {
            $location.path("/empleado/list");
        };

        $scope.empleadoEdit = {
            sucursalBancaria: {
                idSucursalBancaria: parseInt($routeParams.idSucursalBancaria),
                entidadBancaria: {
                    idEntidadBancaria: parseInt($routeParams.idEntidadBancaria)
                }
            }
        };
//        alert($scope.empleadoEdit.sucursalBancaria.idSucursalBancaria + "; " + $scope.empleadoEdit.sucursalBancaria.entidadBancaria.idEntidadBancaria);

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
        $scope.findSucursalesByEntidad($scope.empleadoEdit.sucursalBancaria.entidadBancaria.idEntidadBancaria);

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


        $scope.empleadoEdit = {
            sucursalBancaria: {
                idSucursalBancaria: parseInt($routeParams.idSucursalBancaria),
                entidadBancaria: {
                    idEntidadBancaria: parseInt($routeParams.idEntidadBancaria)
                }
            }
        };

        $scope.errorValidacion = false;


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

        if ($routeParams.idEntidadBancaria) {
            $scope.findSucursalesByEntidad($scope.empleadoEdit.sucursalBancaria.entidadBancaria.idEntidadBancaria);
            $scope.estado = {
                accion: 'insertarDesdeSucursal'
            };
            $scope.estiloDisabled = $rootScope.estiloBloqueado;
        }


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

        $scope.comprobarValidaciones = function () {
            if (!$scope.formularioEmpleado.$error.required
                    && !$scope.formularioEmpleado.$error.pattern) {
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
                    data: $scope.empleadoEdit,
                    url: contextPath + "/api/Empleado"
                }).success(function (data) {
                    $scope.empleadoEdit = data;
                    $scope.empleadoEdit = null;
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


app.controller("EmpleadoUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();

        if ($routeParams.idSucursalBancaria) {
            $scope.estado = {
                accion: 'actualizarDesdeSucursal'
            };
            $scope.estiloDisabled = $rootScope.estiloBloqueado;
        } else {
            $scope.estado = {
                accion: 'actualizar'
            };
        }


        $scope.estilo = "";

        $scope.empleadoEdit = {
            idEmpleado: $routeParams.idEmpleado
        };

        $scope.irLista = function () {
            $location.path("/empleado/list");
        };

        $scope.errorValidacion = false;


        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Empleado/" + $scope.empleadoEdit.idEmpleado
            }).success(function (data) {
                $scope.empleadoEdit = data;
                $scope.findSucursalesByEntidad($scope.empleadoEdit.sucursalBancaria.entidadBancaria.idEntidadBancaria);
//                alert(JSON.stringify($scope.empleadoEdit));
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };
        $scope.get();


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
        
        $scope.comprobarValidaciones = function () {
            if (!$scope.formularioEmpleado.$error.required
                    && !$scope.formularioEmpleado.$error.pattern) {
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
                    url: contextPath + "/api/Empleado/" + $scope.empleadoEdit.idEmpleado,
                    data: $scope.empleadoEdit
                }).success(function () {
                    $scope.empleadoEdit = {};
                    $scope.irLista();
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

app.controller("EmpleadoDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estiloDisabled = $rootScope.estiloBloqueado;//Estilo para los input disabled
        $scope.estilo = $rootScope.estiloBloqueado;

        $scope.empleadoEdit = {
            idEmpleado: $routeParams.idEmpleado
        };

        $scope.irLista = function () {
            $location.path("/empleado/list");
        };

        $scope.errorValidacion = false;


        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Empleado/" + $scope.empleadoEdit.idEmpleado
            }).success(function (data) {
                $scope.empleadoEdit = data;
                $scope.findSucursalesByEntidad($scope.empleadoEdit.sucursalBancaria.entidadBancaria.idEntidadBancaria);
//                alert(JSON.stringify($scope.empleadoEdit));
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };
        $scope.get();


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


        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Empleado/" + $scope.empleadoEdit.idEmpleado
            }).success(function () {
                $scope.empleadoEdit = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
    }]);

