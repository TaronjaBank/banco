app.controller("MovimientoBancarioInsertController", ["$scope", "$http", "$location", function ($scope, $http, $location) {
        
        $scope.estado = {
            accion: 'insertar'
        };
        
        $scope.estilo = "";
        
        $scope.irLista = function() {
            $location.path("/movimientobancario/list");
        };

        $scope.insert = function () {
            $http({
                method: "POST",
                url: contextPath + "/api/MovimientoBancario",
                data: $scope.movimientoBancario
            }).success(function (data) {
                //alert("El nuevo movimiento bancario ha sido insertado correctamente...");
                $scope.movimientoBancario = data;
                $scope.movimientoBancario = null;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });//success.Error
        };
    }]);

app.controller("MovimientoBancarioUpdateController", ["$scope", "$http", "$routeParams", "$location", function ($scope, $http, $routeParams, $location) {

        $scope.estado = {
            accion: 'actualizar'
        };
        
        $scope.estilo = "";

        $scope.movimientoBancario = {
            idMovimientoBancario: $routeParams.idMovimientoBancario
        };
        
        $scope.irLista = function() {
            $location.path("/movimientobancario/list");
        };

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


        $scope.update = function () {

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

        };

    }]);

app.controller("MovimientoBancarioDeleteController", ["$rootScope","$scope", "$http", "$routeParams", "$location", function ($rootScope, $scope, $http, $routeParams, $location) {

        $scope.estado = {
            accion: 'borrar'
        };
        
        $scope.estilo = $rootScope.estiloBloqueado;//Estilo para los input disabled

        $scope.movimientoBancario = {
            idMovimientoBancario: $routeParams.idMovimientoBancario
        };
        
        $scope.irLista = function() {
            $location.path("/movimientobancario/list");
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario
            }).success(function (data) {
                $scope.movimientoBancario = data;
            }).error(function () {
                alert("Error: no existe coincidencia en la base de datos");
            });//success.Error
        };//Consultar

        $scope.get();


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
            });//success.Error
        };//Consultar


    }]);
