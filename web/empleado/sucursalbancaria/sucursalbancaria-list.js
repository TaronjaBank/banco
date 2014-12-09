app.controller("SucursalBancariaListController", ["$scope", "$http", function ($scope, $http) {

        $scope.sucursalesBancarias = {};

        $scope.list = function () {

            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });
        };

    }]);