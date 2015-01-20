app.controller("EntidadBancariaListController", ["$scope", "$http","$rootScope", function($scope, $http ,$rootScope) {
        
         $scope.verEstadoSesion = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Session/Empleado"
            }).success(function(data) {
                if ($rootScope.empleado === data) {
                    alert("Sesión abierta");
                } else {
                    $rootScope.empleado=data;
                }
            }).error(function(status) {
                alert("Error en la peticiión al servidor; error: " + status);
            });
        };
        $scope.verEstadoSesion();
        
        $scope.findAll = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function(data) {
                $scope.entidadesBancarias = data;
                for (var i = 0; i < $scope.entidadesBancarias.length; i++){
                    var fecha = $scope.entidadesBancarias[i].fechaCreacionEntidadBancaria;
                    $scope.entidadesBancarias[i].fechaCreacionEntidadBancaria = new Date(fecha);
                }
            }).error(function() {
                alert("Error: no se ha podido realizar la operación");
            });
        };
        
        $scope.findAll();
        
    }]);


