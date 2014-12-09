app.controller("EntidadBancariaListController", ["$scope", "$http", function ($scope, $http) {

        $scope.findAll = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function (data) {
                $scope.entidadesBancarias = data;
            }).error(function () {
                alert("Error: no se ha podido realizar la operación");
            });//success.Error
        };//Consultar 
        $scope.findAll();
    }]);


