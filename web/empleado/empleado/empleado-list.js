app.controller("EmpleadoListController", ["$scope", "$http", function ($scope, $http) {

        $scope.findAll = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/Empleado"
            }).success(function (data) {
                $scope.empleados = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });//success.Error
        };//Consultar 
        $scope.findAll();
    }]);


