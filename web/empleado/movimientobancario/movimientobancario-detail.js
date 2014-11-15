app.controller("MovimientoBancarioInsertController", ["$scope", "$http", function ($scope, $http) {
        
        $scope.visible = {
            insert: true,
            update: false,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false
        };

        $scope.insert = function () {
            $http({
                method: "POST",
                url: contextPath + "/api/MovimientoBancario/",
                data: $scope.movimientoBancario
            }).success(function (data) {
                alert("Se ha insertado el Movimiento: ");
                $scope.movimientoBancario = data;
            }).error(function () {
                alert("No se ha insertado el Movimiento");
            });//success.Error
        };
    }]);

app.controller("MovimientoBancarioUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.visible = {
            insert: false,
            update: true,
            delete: false
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: false
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario
            }).success(function (data) {
                $scope.movimientoBancario = data;
            }).error(function () {
                alert("No existe el movimiento");
            });
        };
        
        if ($routeParams !== undefined) {
            $scope.movimientoBancario = {};
            $scope.movimientoBancario.idMovimientoBancario = $routeParams.idMovimientoBancario;
            $scope.get();
        }
        
        $scope.update=function(){
            
            $http({
                method: "PUT",
                url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario,
                data: $scope.movimientoBancario
            }).success(function (data) {
                alert("Se ha editado el Movimiento: " + $routeParams.idMovimientoBancario);
                $scope.movimientoBancario = data;
            }).error(function () {
                alert("No se ha editado el Movimiento");
            });
            
        }

    }]);

app.controller("MovimientoBancarioDeleteController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.visible = {
            insert: false,
            update: false,
            delete: true
        };

        $scope.deshabilitado = {
            estadoId: true,
            estado: true
        };

        $scope.get = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario
            }).success(function (data) {
                $scope.movimientoBancario = data;
            }).error(function () {
                alert("No existe el movimiento");
            });//success.Error
        };//Consultar
        if ($routeParams !== undefined) {
            $scope.movimientoBancario = {};
            $scope.movimientoBancario.idMovimientoBancario = $routeParams.idMovimientoBancario;
            $scope.get();
        }

        $scope.deleteData = function () {
            $http({
                method: "DELETE",
                url: contextPath + "/api/MovimientoBancario/" + $scope.movimientoBancario.idMovimientoBancario
            }).success(function (data) {
                alert("Se ha borrado el Movimiento: " + $routeParams.idMovimientoBancario);
                $scope.movimientoBancario = {};
            }).error(function () {
                alert("No se ha Borrado el Movimiento");
            });//success.Error
        };//Consultar


    }]);
