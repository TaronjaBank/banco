app.controller("SucursalBancariaListController", ["$scope", "$http", function ($scope, $http) {

    $scope.sucursalesBancarias = {};

    $scope.list = function () {

        $http({
            method: "GET",
            url: contextPath + "/api/SucursalBancaria"
        }).success(function (data) {
            $scope.sucursalesBancarias = data;
        }).error(function (status) {
            alert("Ha ocurrido un error en la peticion al servidor: error " + status);
        });
    };
    
}]);