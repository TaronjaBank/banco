app.controller("CuentaBancariaInsertController", ["$scope", "$http", "$location", function ($scope, $http, $location) {
        
        $scope.estado = {
            accion: 'insertar'
        };
        
        $scope.estilo = "";
        
        $scope.irLista = function() {
            $location.path("/cuentabancaria/list");
        };
        
        //Para el ng-Options
        $scope.cuentaBancaria={};
        $scope.cuentaBancaria.sucursalBancaria={};
        $scope.sucursalBancaria={};
        $scope.sucursalBancaria.idSucursalBancaria=null;
        
        $scope.insert = function () {
            $scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria=$scope.sucursalBancaria.idSucursalBancaria;
            $http({
                method: "POST",
                data: $scope.cuentaBancaria,
                url: contextPath + "/api/CuentaBancaria"
            }).success(function (data) {
                $scope.cuentaBancaria = data;
                $scope.cuentaBancaria = null;
            }).error(function (data, status) {
                alert("Error: no se ha podido realizar la operación");
                //console.log(data + "    " + status);
            });
        };
        
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

app.controller("CuentaBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", function ($scope, $http, $routeParams, $location) {
        
        $scope.estado = {
            accion: 'actualizar'
        };
        
        $scope.estilo = "";
        
        $scope.cuentaBancaria = {
            idCuentaBancaria:$routeParams.idCuentaBancaria
        };
        
        $scope.irLista = function() {
            $location.path("/cuentabancaria/list");
        };
        
         //Para el ng-Options
        $scope.cuentaBancaria.sucursalBancaria={};
        $scope.sucursalBancaria={};

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
             $scope.cuentaBancaria.sucursalBancaria.idSucursalBancaria=$scope.sucursalBancaria.idSucursalBancaria;
            $http({
                method: "PUT",
                url: contextPath + "/api/CuentaBancaria/" + $scope.cuentaBancaria.idCuentaBancaria,
                data: $scope.cuentaBancaria
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

