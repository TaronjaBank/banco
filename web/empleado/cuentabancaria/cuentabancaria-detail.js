app.controller("CuentaBancariaInsertController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        
        $scope.estado = {
            accion: 'insertar'
        };
        
        $scope.estilo = "";
        
        //Para el ng-Options
        $scope.cuentaBancaria={};
        
        $scope.insert = function () {
            $http({
                method: "POST",
                data: $scope.cuentaBancaria,
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentaBancaria = null;
            }).error(function (data, status) {
                alert("Error: No se ha podido Insertar");
            });
        };
        
        $scope.findAll = function () {
             $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
                for (var i = 0; i < $scope.sucursalesBancarias.length; i++){
                    var sucursalBancaria=$scope.sucursalesBancarias[i];
                    if (sucursalBancaria.idSucursalBancaria===($routeParams.idSucursalBancaria*1)) {
                        $scope.cuentaBancaria.sucursalBancaria=sucursalBancaria;
                        $scope.insertdesdedetail = {
                            accion: 'insertardesdedetail'
                        };
                    }
                }
            }).error(function () {
                alert("Error: no se ha podido listar las Sucursales");
            });
        };
        $scope.findAll();

    }]);

app.controller("CuentaBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        
        $scope.estado = {
            accion: 'actualizar'
        };
        
        $scope.estilo = "";
        
        $scope.cuentaBancaria = {
            idCuentaBancaria:$routeParams.idCuentaBancaria
        };
        
        
        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function (data) {
                $scope.cuentaBancaria = data;
                $scope.sucursalBancaria.idSucursalBancaria=$scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();

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
        
         $scope.findAllMovimientosByCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/"+ $scope.cuentaBancaria.idCuentaBancaria+"/MovimientoBancario"
            }).success(function(data) {
                $scope.movimientosBancarios = data;
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        
        $scope.findAllMovimientosByCuenta();
        
        $scope.findAll = function () {

            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        $scope.findAll();
    }]);

app.controller("CuentaBancariaDeleteController", ["$rootScope","$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        
        $scope.estado = {
            accion: 'borrar'
        };
        
        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled
        
        $scope.cuentaBancaria = {
            idCuentaBancaria:$routeParams.idCuentaBancaria
        };
        
        $scope.irLista = function() {
            $location.path("/cuentabancaria/list");
        };
        $scope.sucursalesBancarias=[];
        $scope.sucursalBancaria={};
        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria
            }).success(function (data) {
                $scope.cuentaBancaria = data;
                 $scope.sucursalesBancarias[0]=$scope.cuentaBancaria.sucursalBancaria;
                $scope.sucursalBancaria.idSucursalBancaria=$scope.sucursalesBancarias[0].idSucursalBancaria;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });
        };

        $scope.get();

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
        
        $scope.findAllMovimientosByCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/CuentaBancaria/"+ $scope.cuentaBancaria.idCuentaBancaria+"/MovimientoBancario"
            }).success(function(data) {
                $scope.movimientosBancarios = data;
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        
        $scope.findAllMovimientosByCuenta();
    }]);

