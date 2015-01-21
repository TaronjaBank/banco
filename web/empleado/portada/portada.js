app.controller("PortadaController", ['$scope', '$rootScope', '$location', function ($scope, $rootScope, $location) {
        $scope.irMain = function () {
            $location.path("/index");
        };

        if ($rootScope.empleado !== null) {
            $scope.irMain();
        }
    }]);


