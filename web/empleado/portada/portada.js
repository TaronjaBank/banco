app.controller("PortadaController", ['$scope', '$rootScope', '$location', '$http', function ($scope, $rootScope, $location, $http) {
        
        $scope.getSesion = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Session/Empleado"
            }).success(function(data,status) {
                if(status===200){
                    $rootScope.empleado=data;
                    $location.path("/main");
                }
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };
        $scope.getSesion();
    }]);


