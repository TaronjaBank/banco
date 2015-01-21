app.controller("EntidadBancariaListController", ["$scope", "$http","$rootScope", "$location", function($scope, $http ,$rootScope, $location) {
        
        
        $rootScope.asignarEstadoSesion();
        if ($rootScope.empleado === null){
            $location.path("/portada");
        }
        
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


