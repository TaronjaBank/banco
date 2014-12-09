app.controller("PortadaController", ['$scope', '$rootScope', '$location', function ($scope, $rootScope, $location) {
        $scope.irMain = function () {
            $location.path("/main");
        };

        if ($rootScope.empleado !== null) {
            $scope.irMain();
        }
    }]);


