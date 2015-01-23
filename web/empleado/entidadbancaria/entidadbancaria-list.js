app.controller("EntidadBancariaListController", ["$rootScope", "$scope", "$http", "$location", function($rootScope, $scope, $http , $location) {
        
        
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
        
        $rootScope.comprobarSesiona($scope.findAll).success(function(data,status) {
                if(status===200){
                    $rootScope.empleado=data;
                    $scope.findAll;
                }else{
                    $location.path("/portada");
                }
            });
        
    }]);


