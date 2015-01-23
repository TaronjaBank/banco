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
        f      
        var promise = $rootScope.comprobarSesiona();
        promise.then(function(status) {
            if(status===200){
                $scope.findAll();
            }
        }, function(error) {
            alert("Error: no se ha podido realizar la operación");
        });
 
        
    }]);


