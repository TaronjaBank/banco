app.controller("SucursalBancariaListController", ["$scope", "$http", "$rootScope", function ($scope, $http, $rootScope) {
        
        
        $scope.sucursalesBancarias = {};

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