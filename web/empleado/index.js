app.controller("IndexController", ['$location', '$rootScope', '$scope', '$http', function ($location, $rootScope, $scope, $http) {
        

        $scope.logOut = function() {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Session/Empleado"
            }).success(function() {
                $rootScope.empleado = null;
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };

    }]);
