app.controller("EntidadBancariaInsertController", ["$scope", "$http", "$rootScope", function ($scope, $http, $rootScope) {

        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";
        $scope.estiloBloqueado = $rootScope.estiloBloqueado;

        $scope.entidadBancaria = {
            codigoEntidadBancaria: "",
            fechaCreacionEntidadBancaria: new Date()
        };
        
        $scope.lastIdEntidad = -1;

        
        $scope.getLastIdEntidad = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                var entidades = data;
                for (var i = 0; i < entidades.length; i++) {
                    if (entidades[i].idEntidadBancaria > $scope.lastIdEntidad) {
                        $scope.entidadBancaria.codigoEntidadBancaria = ("000" + (entidades[i].idEntidadBancaria + 1)).slice(-4);
                    }
                }
            }).error(function () {
                alert("Error: no se han podido listar las cuentas bancarias");
            });
        };
        $scope.getLastIdEntidad();
        
        
        $scope.insert = function () {
            $scope.mostrarValidaciones = true;
            $(".validacion-caja-mensajes").fadeIn(500, "linear");
            
            if (!$scope.formularioEntidadBancaria.$invalid) {
                $http({
                    method: "POST",
                    data: $scope.entidadBancaria,
                    url: contextPath + "/api/EntidadBancaria"
                }).success(function (data) {
                    $scope.entidadBancaria = data;
                    $scope.entidadBancaria = null;
                    $scope.entidadBancaria = {
                        fechaCreacionEntidadBancaria: new Date()
                    };
                }).error(function () {
                    alert("Error: no se ha podido realizar la operación");
                });
            }
        };
    }]);


app.controller("EntidadBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'actualizar'
        };

        $scope.estilo = "";

        $scope.entidadBancaria = {
            idEntidadBancaria: $routeParams.idEntidadBancaria
        };

        $scope.irLista = function () {
            $location.path("/entidadbancaria/list");
        };


        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function (data) {
                $scope.entidadBancaria = data;
                $scope.entidadBancaria.fechaCreacionEntidadBancaria = new Date($scope.entidadBancaria.fechaCreacionEntidadBancaria);
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };
        $scope.get();
        
        
        $scope.update = function () {
            $scope.mostrarValidaciones = true;
            $(".validacion-caja-mensajes").fadeIn(500, "linear");
            
            if (!$scope.formularioEntidadBancaria.$invalid) {
                $http({
                    method: "PUT",
                    url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria,
                    data: $scope.entidadBancaria
                }).success(function () {
                    $scope.entidadBancaria = {};
                    $scope.irLista();
                }).error(function () {
                    alert("Error: no se ha podido realizar la operación");
                });
            }
        };

        $scope.findAllSucursalesByEntidad = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria + "/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;

            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllSucursalesByEntidad();

    }]);

app.controller("EntidadBancariaDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        $rootScope.comprobarSesion();
        $scope.estado = {
            accion: 'borrar'
        };

        $scope.estilo = $rootScope.estiloBloqueado;

        $scope.entidadBancaria = {
            idEntidadBancaria: $routeParams.idEntidadBancaria
        };

        $scope.irLista = function () {
            $location.path("/entidadbancaria/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function (data) {
                $scope.entidadBancaria = data;
                $scope.entidadBancaria.fechaCreacionEntidadBancaria = new Date($scope.entidadBancaria.fechaCreacionEntidadBancaria);
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria
            }).success(function () {
                $scope.entidadBancaria = {};
                $scope.irLista();
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllSucursalesByEntidad = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $scope.entidadBancaria.idEntidadBancaria + "/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

        $scope.findAllSucursalesByEntidad();
    }]);