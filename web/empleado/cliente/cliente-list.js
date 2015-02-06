app.controller("ClienteListController", ["$scope", "$http", "$rootScope", function ($scope, $http, $rootScope) {
        
         $rootScope.comprobarSesion();
       

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
        $scope.findAll();

    }]);