app.controller("EntidadBancariaInsertController", ["$scope", "$http", "$rootScope", function ($scope, $http, $rootScope) {
        
        
        $scope.estado = {
            accion: 'insertar'
        };

        $scope.estilo = "";

        $scope.entidadBancaria = {
            fechaCreacionEntidadBancaria: new Date()
        };

        $scope.insert = function () {
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
        };
    }]);


app.controller("EntidadBancariaUpdateController", ["$scope", "$http", "$routeParams", "$location", "$rootScope", function ($scope, $http, $routeParams, $location, $rootScope) {
        
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
            };
            
             $scope.findAllSucursalesByEntidad = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/"+ $scope.entidadBancaria.idEntidadBancaria+"/SucursalBancaria"
            }).success(function(data) {
                $scope.sucursalesBancarias = data;
                
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        
        $scope.findAllSucursalesByEntidad();

    }]);

app.controller("EntidadBancariaDeleteController", ["$rootScope", "$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {
        
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
        
         $scope.findAllSucursalesByEntidad = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/"+ $scope.entidadBancaria.idEntidadBancaria+"/SucursalBancaria"
            }).success(function(data) {
                $scope.sucursalesBancarias = data;
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        
        $scope.findAllSucursalesByEntidad();
    }]);