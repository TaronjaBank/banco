app.controller("ClienteListController", ["$scope", "$http", "$rootScope", "$location", function ($scope, $http, $rootScope, $location) {

        var promise = $rootScope.comprobarSesion();

        promise.then(function (status) {
            if (status === 200) {
                $scope.findAll();
            } else {
                $location.path("/portada");
                $rootScope.empleado = null;
            }
        }, function (error) {
            alert("Se ha producido un error al obtener el dato:" + error);
        });

        $scope.findAll = function () {

            $http({
                method: "GET",
                url: contextPath + "/api/Cliente"
            }).success(function (data) {
                $scope.clientes = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);